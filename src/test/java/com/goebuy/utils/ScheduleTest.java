package com.goebuy.utils;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class ScheduleTest extends TestCase {

	
//	@Scheduled(cron="0 33/3 * * * ?") //每小时的33分钟开始执行，每3分钟执行1次
	@Scheduled(fixedRate=3000)
    public void start() { 
		System.out.println("schedule:"+new Date().toGMTString());
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
//		assertNotNull(biz);
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
	
	
	@Test
	public void testRun() {
		start();
	}
}
