package com.goebuy.utils;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;


/**
 * spring事件通知机制详解
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class TestPortal extends TestCase {
	
	@Autowired
	CustomizePublisher customizePublisher;
	

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		assertNotNull(customizePublisher);
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
	public void test()  {

//	      final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

//	      String[] definitionNames = applicationContext.getBeanDefinitionNames();
//	      System.out.println("==============bean====start=================");
//	      for (String definitionName : definitionNames) {
//	         System.out.println("bean----:" + definitionName);
//	      }
//	      System.out.println("==============bean====end=================");
//	      System.out.println();
//	      final CustomizePublisher customizePublisher = applicationContext.getBean(CustomizePublisher.class);


	      Thread thread = new Thread(new Runnable() {
	         @Override
	         public void run() {
	            try {
	               System.out.println("开始吃饭：");

	               MealEvent lunchEvent = new MealEvent("A吃午饭了", "lunch");
	               MealEvent breakfastEvent = new MealEvent("B吃早饭了", "breakfast");
	               MealEvent dinnerEvent = new MealEvent("C吃晚饭了", "dinner");
	               customizePublisher.publish(lunchEvent);
	               TimeUnit.SECONDS.sleep(1);
	               customizePublisher.publish(breakfastEvent);
	               TimeUnit.SECONDS.sleep(1);
	               customizePublisher.publish(dinnerEvent);
	               TimeUnit.SECONDS.sleep(1);

	               System.out.println("他们吃完了！");
	            } catch (InterruptedException e) {
	               e.printStackTrace();
	            }
	         }
	      });
	      thread.setName("meal-thread");
	      thread.start();

	      System.out.println(Thread.currentThread().getName() + " is waiting for ....");
	      try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	      System.out.println("Done!!!!!!!!!!!!");
	}
	
	   public static void main(String[] args) throws InterruptedException {
		   TestPortal testPortal=new TestPortal();
		   testPortal.test();
	   }
	}