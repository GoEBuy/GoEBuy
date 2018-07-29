//package com.goebuy.service;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
//
//import com.goebuy.controller.BlogController;
//import com.goebuy.controller.UserController;
//
///**
// * @deprecated
// * @author Administrator
// *
// */
//public class TestService {
//
//	public static void main(String[] args) {
//		 ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:mvc-dispatcher-servlet.xml");
////		 用文件系统的路径,默认指项目的根路径
////		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml");
//		System.out.println("main");
////		UserController service = (UserController)applicationContext.getBean("UserController"); 
//		BlogService service = (BlogService)applicationContext.getBean("BlogService");
//		service.findAll();
//		System.out.println(service.count()+"");
//		//		UserService service = (UserService)applicationContext.getBean("UserService"); 
//		System.out.println("finished");
//	}
//
//}
