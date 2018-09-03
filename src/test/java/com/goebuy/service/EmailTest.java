package com.goebuy.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goebuy.utils.AttMailsendServiceImpl;

import junit.framework.TestCase;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class EmailTest extends TestCase{
	
	@Autowired
	AttMailsendServiceImpl mailsendService;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		assertNotNull(mailsendService);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Before
	public void before() {
		System.out.println("before");
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
	
	@Ignore
	@Test
	public void testMail() {
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
