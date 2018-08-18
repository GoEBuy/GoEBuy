package com.goebuy.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.goebuy.entity.user.User;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MultipartFile;

import com.goebuy.annotation.SystemLogAnnotation;
import com.goebuy.service.UserService;

@Controller
public class UserController {


	// 自动装配数据库接口，不需要再写原始的Connection来操作数据库
	@Autowired
	UserService userRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		return "index";
	}

	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	@SystemLogAnnotation(operationType = "list", operationName = "user")
	public String getUsers(HttpServletRequest request, ModelMap modelMap) {
		// 查询user表中所有记录
		System.out.println("getUsers");
		List<User> userList = userRepository.findAll();
		String count = userRepository.count() + "";
		// 将所有记录传递给要返回的jsp页面，放在userList当中
		modelMap.addAttribute("userList", userList);
		modelMap.addAttribute("userCnt", count);
		// 返回pages目录下的admin/users.jsp页面
		return "admin/users";
	}

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

	/**
	 * get请求，访问添加用户 页面
	 */
	@RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		// 返回 admin/addUser.jsp页面
		return "admin/addUser";
	}

	/**
	 * post请求，处理添加用户请求，并重定向到用户管理页面
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
	@SystemLogAnnotation(operationType = "add", operationName = "user")
	public String addUserPost(HttpServletRequest request, @ModelAttribute("user") User user) {
		// 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
		// 通过@ModelAttribute()注解可以获取传递过来的'user'，并创建这个对象

		// 数据库中添加一个用户，该步暂时不会刷新缓存
		// userRepository.save(user);
		System.out.println(user.getName());

		// 数据库中添加一个用户，并立即刷新缓存
		userRepository.saveAndFlush(user);

		// 重定向到用户管理页面，方法为 redirect:url
		return "redirect:/admin/users";
	}

	/**
	 * 查看用户详情
	 * 
	 * @param userId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
	@SystemLogAnnotation(operationType = "list", operationName = "user")
	public String showUser(HttpServletRequest request, @PathVariable("id") Integer userId, ModelMap modelMap) {
		System.out.println("showUser");
		// 找到userId所表示的用户
		User user = userRepository.findOne(userId);
		System.out.println(user);
		// 传递给请求页面
		modelMap.addAttribute("user", user);
		System.out.println("admin/userDetail");
		return "admin/userDetail";
	}

	// 更新用户信息 页面
	@RequestMapping(value = "/admin/users/update/{id}", method = RequestMethod.GET)
	@SystemLogAnnotation(operationType = "update", operationName = "user")
	public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

		System.out.println("updateUser");
		// 找到userId所表示的用户
		User user = userRepository.findOne(userId);
		// 传递给请求页面
		modelMap.addAttribute("user", user);
		return "admin/updateUser";
	}

	// 更新用户信息 操作
	@RequestMapping(value = "/admin/users/updateP", method = RequestMethod.POST)
	@SystemLogAnnotation(operationType = "update", operationName = "user")
	public String updateUserPost(HttpServletRequest request, @ModelAttribute("user") User user) {
		userRepository.updateUser(user.getName(), user.getId());
		userRepository.flush(); // 刷新缓冲区
		return "redirect:/admin/users";
	}

	/**
	 *  删除用户
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
	@SystemLogAnnotation(operationType = "delete", operationName = "user")
	public String deleteUser(@PathVariable("id") Integer userId) {

		// 删除id为userId的用户
		userRepository.delete(userId);		
		// 立即刷新
		userRepository.flush();
		return "redirect:/admin/users";
	}

}
