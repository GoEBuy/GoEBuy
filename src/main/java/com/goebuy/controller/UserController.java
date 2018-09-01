package com.goebuy.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ValueConstants;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.goebuy.annotation.SystemLogAnnotation;
import com.goebuy.biz.user.UserBiz;
import com.goebuy.entity.user.User;

//@RequestMapping("/user")
//@EnableSwagger2
@Controller
public class UserController {


	// 自动装配数据库接口，不需要再写原始的Connection来操作数据库
	@Autowired
	UserBiz biz;

	
	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAll(HttpServletRequest request,
			@RequestParam(value = "pi", required = false, defaultValue = ValueConstants.DEFAULT_NONE) String pageIndex,
			@RequestParam(value = "ps", required = false, defaultValue = ValueConstants.DEFAULT_NONE) String pageSize) {
		Pageable pageable = null;
		List<User> users = null;
		if (pageSize != null) {
			int pd = 0;
			if (pageIndex != null) {
				pd = Integer.parseInt(pageIndex.trim());
			}
			Sort sort = null;
			// 分页信息
//	      Sort sort = new Sort(Sort.Direction.DESC,"createTime"); //创建时间降序排序
			pageable = new PageRequest(pd, Integer.parseInt(pageSize.trim()), sort);
			users = biz.findAll(pageable);
		} else {
			users = biz.findAll();
		}
		JSONObject js = new JSONObject();
		js.put("data", users);
		return js;
	}

//	@RequestMapping(value = "/users/", method = RequestMethod.GET  )
//	@SystemLogAnnotation(operationType = "list", operationName = "user")
//	@ResponseBody
//	public String getUsers(HttpServletRequest request, ModelMap modelMap) {
//		// 查询user表中所有记录
//		System.out.println("getUsers");
//		List<User> userList = biz.findAll();
//		String count = biz.count() + "";
//		// 将所有记录传递给要返回的jsp页面，放在userList当中
//		modelMap.addAttribute("userList", userList);
//		modelMap.addAttribute("userCnt", count);
//		// 返回pages目录下的admin/users.jsp页面
//		return "admin/users";
//	}

	// 文件上传、
	@RequestMapping(value = "admin/upload")
	public String showUploadPage(HttpServletRequest request) {
		// 跳转至文件上传界面 admin/file.jsp
		return "admin/file";
	}

//	　1、为保证服务器安全，上传文件应该放在外界无法直接访问的目录下，比如放于WEB-INF目录下。
//	　　2、为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名。
//	　　3、为防止一个目录下面出现太多文件，要使用hash算法打散存储。
//	　　4、要限制上传文件的最大值。
//	　　5、要限制上传文件的类型，在收到上传文件名时，判断后缀名是否合法。
	@RequestMapping(value = "admin/doUpload", method = RequestMethod.POST)
	public String doUploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file, ModelMap modelMap)
			throws IOException {
		// 消息提示
		String message = "";
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		File saveDir = new File("upload");
		if (!saveDir.exists() && !saveDir.isDirectory()) {
			// 判断上传文件的保存目录是否存在
			System.out.println("目录不存在，需要创建");
			// 创建目录
			saveDir.mkdir();
		}

		long upfileSize = file.getSize();
		if (upfileSize > 1024 * 1024 * 100) {
			// 上传文件大小超过100M
			message = String.format("单个上传文件【%s】超过100M", file.getOriginalFilename());
		} else {

			File saveFile = new File("upload", System.currentTimeMillis() + "-" + file.getOriginalFilename());
			try {
				if (!saveFile.exists() && !saveFile.isDirectory()) {

					FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
					message = "文件" + saveFile.getAbsolutePath() + "上传成功！";
				} else {
					System.err.println("file" + saveFile.getAbsolutePath() + " is empty");
					message = "文件 " + saveFile.getAbsolutePath() + " 已存在！";
				}
			} catch (Exception e) {
				message = "文件" + saveFile.getAbsolutePath() + "上传失败！";
				e.printStackTrace();

			}
		}
		modelMap.addAttribute("message", message);
		return "index";
	}

	@RequestMapping(value = "admin/doDownload")
	public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("file") File file,
			ModelMap modelMap) throws Exception {
//	    	  ModelAndView mav = new ModelAndView();

		// 下载显示的文件名，解决中文名称乱码问题
		String filename = file.getCanonicalFile().getName();
		System.out.println("filename: " + filename);
		String downloadFielName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
		HttpHeaders headers = new HttpHeaders();
		// 设置Http状态码
		HttpStatus statusCode = HttpStatus.OK;
//	        HttpStatus.CREATED
		// 设置文件类型
		headers.add("Content-Disposition", "attchement;filename=" + filename);
		// 通知浏览器以attachment（下载方式）打开图片
		headers.setContentDispositionFormData("attachment", downloadFielName);
		// application/octet-stream ： 二进制流数据（最常见的文件下载）。
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, statusCode);
	}

//	/**
//	 * post请求，处理添加用户请求，并重定向到用户管理页面
//	 * 
//	 * @param request
//	 * @param user
//	 * @return
//	 */
//	@RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
//	@SystemLogAnnotation(operationType = "add", operationName = "user")
//	public String saveUser( @ModelAttribute("user") User user) {
//		// 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
//		// 通过@ModelAttribute()注解可以获取传递过来的'user'，并创建这个对象
//
//		// 数据库中添加一个用户，该步暂时不会刷新缓存
//		// userRepository.save(user);
//		System.out.println(user.getName());
//
//		// 数据库中添加一个用户，并立即刷新缓存
//		biz.saveAndFlush(user);
//
//		// 重定向到用户管理页面，方法为 redirect:url
//		return "redirect:/admin/users";
//	}

	/**
	 * 查看用户详情
	 * 
	 * @param userId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET , produces="application/json;charset=UTF-8")
	@SystemLogAnnotation(operationType = "list", operationName = "user")
	@ResponseBody
	public ResponseEntity<User> get(HttpServletRequest request, @PathVariable("id") Integer userId) {
		System.out.println("showUser");
		// 找到userId所表示的用户
		User user = biz.findById(userId);
		if (null == user) {
			// 资源不存在 404
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		System.out.println(user);
		// 资源存在 200
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

//	// 更新用户信息 页面
//	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
//	@SystemLogAnnotation(operationType = "update", operationName = "user")
//	public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {
//
//		System.out.println("updateUser");
//		// 找到userId所表示的用户
//		User user = biz.findById(userId);
//		biz.save(addObj)
////		// 传递给请求页面
////		modelMap.addAttribute("user", user);
////		return "admin/updateUser";
//	}

	/**
	 *     更新用户信息 操作
	 * @param request
	 * @param user
	 * @return
	 */
//	@RequestBody User user
	@RequestMapping( value ="/users/{id}", method = RequestMethod.PUT, produces="application/json;charset=UTF-8")
	@SystemLogAnnotation(operationType = "update", operationName = "user")
	public ResponseEntity<User> update(HttpServletRequest request, @ModelAttribute("user") User user) {
		try {
			biz.saveAndFlush(user);
			// 204
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 出现异常，服务器内部错误
		// 500
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
				null);
	}

	/**
	 *  删除用户
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	@SystemLogAnnotation(operationType = "delete", operationName = "user")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		try {
			User user = biz.findById(id);
			if (null == user) {
				// 资源不存在，响应404
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			// 删除id为userId的用户
			biz.deleteByObj(user);		
			// 立即刷新
			biz.flush();
			  // 删除成功，响应204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			// 出现异常，服务器内部错误
			// 500
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					null);
		}
	}

}
