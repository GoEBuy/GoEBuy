package com.goebuy.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.goebuy.utils.AttMailsendServiceImpl;


@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class EmailTest {
	
	@Autowired
	AttMailsendServiceImpl mailsendService;
	

	@Before
	public void init() {
		System.out.println("init");
		if (mailsendService==null) {
			System.out.println("mailservice is null");
			
		}
	}
	
	
	@Test
	public void testMail() {
//		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext.xml"); 
		//简单邮件
		//IMailsendService mailsendService=(IMailsendService) ctx.getBean("simpleMailsendService");
		
		//复杂邮件
		//IMailsendService mailsendService=(IMailsendService) ctx.getBean("AttMailsendService");
		
		//使用模板的文件
//		IMailsendService mailsendService=(IMailsendService) ctx.getBean("createMatterService");
		mailsendService.sendMessage();
		System.out.println("发送成功！");
	}
	
}
