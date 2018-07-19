package com.goebuy.controller;

import java.util.List;

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
import com.goebuy.entity.BlogEntity;
import com.goebuy.entity.UserEntity;
import com.goebuy.service.BlogService;
import com.goebuy.service.UserService;

@Controller
public class BlogController {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	private static final String url_add="";
	private static final String url_update="";
	private static final String url_get="";
	private static final String url_getAll="";
	private static final String url_del="";
	private static final String url_delAll="";
	

    @Autowired
    BlogService blogRepository;	

    @Autowired
    UserService userRepository;

    // 查看所有博文
    @RequestMapping(value = "/admin/blogs", method = RequestMethod.GET)
    public String showBlogs(ModelMap modelMap,@RequestParam(value="pi",required=false, defaultValue=ValueConstants.DEFAULT_NONE) String pageIndex,  @RequestParam(value="ps",	required=false, defaultValue=ValueConstants.DEFAULT_NONE) String pageSize ) {
    
    	logger.info("showBlogs");
    	
    Pageable pageable = null;
      List<BlogEntity> blogList = null;
      if(pageSize!=null) {
    	  int pd= 0;
    	  if (pageIndex!=null) {
    	   pd= Integer.parseInt(pageIndex.trim());
    	  }
    	//分页信息
//      Sort sort = new Sort(Sort.Direction.DESC,"createTime"); //创建时间降序排序
    	  pageable = new PageRequest( pd, Integer.parseInt(pageSize.trim()), null); 
    	  Page<BlogEntity> blogList1 = blogRepository.findAll(pageable);
    	  blogList = blogList1.getContent();
      }else {
    	//不分页
    	 blogList = blogRepository.findAll();
      }
        modelMap.addAttribute("blogList", blogList);
        return "admin/blogs";
    }
    


    // 添加博文
    @RequestMapping(value = "/admin/blogs/add", method = RequestMethod.GET)
    public String addBlog(ModelMap modelMap) {
    	
    	logger.info("addBlog");
        List<UserEntity> userList = userRepository.findAll();
        // 向jsp注入用户列表
        modelMap.addAttribute("userList", userList);
        return "admin/addBlog";
    }

    // 添加博文，POST请求，重定向为查看博客页面
    @RequestMapping(value = "/admin/blogs/addP", method = RequestMethod.POST)
    public String addBlogPost(@ModelAttribute("blog") BlogEntity blogEntity) {
    	
    	logger.info("addBlogPost");
    	
        // 打印博客标题
        System.out.println(blogEntity.getTitle());
        // 打印博客作者
        System.out.println(blogEntity.getUserByUserId().getNickname());
        // 存库
        blogRepository.saveAndFlush(blogEntity);
        // 重定向地址
        return "redirect:/admin/blogs";
    }

    // 查看博文详情，默认使用GET方法时，method可以缺省
    @RequestMapping("/admin/blogs/show/{id}")
    public String showBlog(@PathVariable("id") int id,  ModelMap modelMap) {
    	
    	logger.info("showBlog");
        BlogEntity blog = blogRepository.findById(id).get();
        modelMap.addAttribute("blog", blog);
        return "admin/blogDetail";
    }

    // 修改博文内容，页面
    @RequestMapping("/admin/blogs/update/{id}")
    public String updateBlog(@PathVariable("id") int id, ModelMap modelMap) {
    	logger.info("updateBlog");
    	
        BlogEntity blog = blogRepository.findById(id).get();
        List<UserEntity> userList = userRepository.findAll();
        modelMap.addAttribute("blog", blog);
        modelMap.addAttribute("userList", userList);
        return "admin/updateBlog";
    }

    // 修改博客内容，POST请求
    @RequestMapping(value = "/admin/blogs/updateP", method = RequestMethod.POST)
    public String updateBlogP(@ModelAttribute("blog") BlogEntity blogEntity) {
    	
    	logger.info("updateBlogP");
    	
        // 更新博客信息
        System.out.println(blogEntity.getTitle());
        blogRepository.updateBlog(blogEntity.getTitle(), blogEntity.getUserByUserId().getId(),
                blogEntity.getContent(), blogEntity.getPubDate(), blogEntity.getId());
        blogRepository.flush();
        return "redirect:/admin/blogs";
    }

    // 删除博客文章
    @RequestMapping("/admin/blogs/delete/{id}")
    public String deleteBlog(@PathVariable("id") int id) {
    	
    	logger.info("deleteBlog");
    	
        blogRepository.deleteById(id);
        blogRepository.flush();
        return "redirect:/admin/blogs";
    }
}
