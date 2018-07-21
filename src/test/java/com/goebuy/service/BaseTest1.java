package com.goebuy.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.goebuy.controller.MainController;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mvc-dispatcher-servlet.xml" })
@Transactional
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class BaseTest1 extends TestCase {
	@Autowired 
	ApplicationContext ctx;

    protected Logger logger = LoggerFactory.getLogger(getClass());

//
//public class BaseTest1 extends BaseTest {
	@Resource(name = "postService")
	private MainController postService;

 @Test
	public void testQuery2LevelPostType() {
	 System.out.println("hello");
//	 	postService.getUsers();
//		Map<Integer,Object> map= postService.query2LevelPostType();
//		System.out.println("data size:" + map.size());
	}
}
