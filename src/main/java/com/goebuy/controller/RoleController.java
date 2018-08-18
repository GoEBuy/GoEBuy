package com.goebuy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ValueConstants;

import com.goebuy.annotation.SystemLogAnnotation;
import com.goebuy.entity.auth.Role;
import com.goebuy.service.RoleService;

//@RequestMapping

@Controller
public class RoleController {
	
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	private static final String url_add="";
	private static final String url_update="";
	private static final String url_get="";
	private static final String url_getAll="";
	private static final String url_del="";
	private static final String url_delAll="";
	

    @Autowired
    RoleService roleRepository;	


//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String index(HttpServletRequest request) {
//		return "index";
//	}

    
    /**
     *  查看所有博文
     * @param request
     * @param modelMap
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/admin/roles", method = RequestMethod.GET)
    public String showRoles(HttpServletRequest request, ModelMap modelMap,@RequestParam(value="pi",required=false, defaultValue=ValueConstants.DEFAULT_NONE) String pageIndex,  @RequestParam(value="ps",	required=false, defaultValue=ValueConstants.DEFAULT_NONE) String pageSize ) {
//    	ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
//    			.getRequestAttributes();
//    	HttpServletRequest  request =		 attrs.getRequest(); 
    	logger.info("showRoles");
    	
    Pageable pageable = null;
      List<Role> roleList = null;
      if(pageSize!=null) {
    	  int pd= 0;
    	  if (pageIndex!=null) {
    	   pd= Integer.parseInt(pageIndex.trim());
    	  }
    	//分页信息
//      Sort sort = new Sort(Sort.Direction.DESC,"createTime"); //创建时间降序排序
    	  pageable = new PageRequest( pd, Integer.parseInt(pageSize.trim()), null); 
    	  Page<Role> roleList1 = roleRepository.findAll(pageable);
    	  if(roleList1!=null) {
    		  roleList = roleList1.getContent();
    	  }
      }else {
    	//不分页
    	 roleList = roleRepository.findAll();
      }
        modelMap.addAttribute("roleList", roleList);
        return "admin/blogs";
    }
    


    // 添加博文
    @RequestMapping(value = "/admin/roles/add", method = RequestMethod.GET)
    public String addRole(HttpServletRequest request, ModelMap modelMap) {

    	logger.info("addRole");
        List<Role> roleList = roleRepository.findAll();
        try {
        	 // 向jsp注入用户列表
            modelMap.addAttribute("roleList", roleList);
            return "admin/addRole";
		} catch (Exception e) {
			logger.error(e.getMessage());
			System.err.println(e.getMessage());
			 return "admin/addRole";
		}
       
    }

    // 添加博文，POST请求，重定向为查看博客页面
    @RequestMapping(value = "/admin/roles/addP", method = RequestMethod.POST)
    @SystemLogAnnotation(operationType = "add", operationName = "role")
    public String addRolePost(HttpServletRequest request, @ModelAttribute("Role") Role roleEntity) {
    	
    	logger.info("addBlogPost");
    	
        System.out.println(roleEntity.getRole());
        System.out.println(roleEntity.getDescription() );
        roleRepository.saveAndFlush(roleEntity);
        // 重定向地址
        return "redirect:/admin/roles";
    }

    // 查看博文详情，默认使用GET方法时，method可以缺省
    @RequestMapping("/admin/roles/show/{id}")
    public String showRole(HttpServletRequest request, @PathVariable("id") int id,  ModelMap modelMap) {
    	
    	logger.info("showBlog");
        Role blog = roleRepository.findOne(id);
        modelMap.addAttribute("role", blog);
        return "admin/roleDetail";
    }

    // 修改博文内容，页面
    @RequestMapping("/admin/roles/update/{id}")
    public String updateRole(HttpServletRequest request, @PathVariable("id") int id, ModelMap modelMap) {
    	logger.info("updateBlog");
    	
        Role blog = roleRepository.findOne(id);
        List<Role> roleList = roleRepository.findAll();
        modelMap.addAttribute("Role", blog);
        modelMap.addAttribute("roleList", roleList);
        return "admin/updateRole";
    }

    // 修改博客内容，POST请求
    @RequestMapping(value = "/admin/roles/updateP", method = RequestMethod.POST)
    @SystemLogAnnotation(operationType = "update", operationName = "role")
    public String updateRolePost(HttpServletRequest request, @ModelAttribute("role") Role roleEntity) {
    	
    	logger.info("updateRolePost");
    	
        // 更新博客信息
//        System.out.println(roleEntity.getTitle());
        roleRepository.updateRole( roleEntity.getRole(), roleEntity.getDescription(), roleEntity.getId());
    	roleRepository.flush();
        return "redirect:/admin/roles";
    }

    /**
     *  删除博客文章
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/admin/roles/delete/{id}")
    @SystemLogAnnotation(operationType = "delete", operationName = "role")
    public String deleteRole(HttpServletRequest request, @PathVariable("id") int id) {
    	
    	logger.info("deleteRole");
    	
        roleRepository.delete(id);
        roleRepository.flush();
        return "redirect:/admin/roles";
    }
}
