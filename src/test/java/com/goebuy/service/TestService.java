package com.goebuy.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.goebuy.controller.MainController;

public class TestService {

	public static void main(String[] args) {
//		 ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:mvc-dispatcher-servlet.xml");
//		 用文件系统的路径,默认指项目的根路径
<<<<<<< HEAD
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml");
		MainController service = (MainController)applicationContext.getBean("MainController"); 
=======
		System.out.println("main");
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml");
//		MainController service = (MainController)applicationContext.getBean("MainController"); 
		UserService service = (UserService)applicationContext.getBean("UserService"); 
>>>>>>> 8fc07125311188871de4b3aa5d7a9be933395643
		System.out.println("finished");
	}

}
