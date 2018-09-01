package com.goebuy.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.goebuy.biz.event.ActivityBiz;
import com.goebuy.entity.event.Activity;

import junit.framework.TestCase;

////@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class ActivityTest extends TestCase {

//	 @Autowired
//	 ApplicationContext ctx;

	@Autowired
	ActivityBiz biz;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		assertNotNull(biz);
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
	public void testCount() {
		System.out.println("role count: " + biz.count());
	}
	
	@Test
	public void testListAll() {
		List<Activity> roleList =biz.findAll();
		if(roleList!=null) {
			for(Activity r : roleList ) {
				System.out.println("Role: " + r );
			}
		}else {
			System.out.println("Roles is null");
		}
	}

	@Test
	public void testFind() {
		System.out.println("testFind");
		List<Activity> roleList = biz.findByNameMatch("adm");
		if (roleList!=null) {
			for(Activity r: roleList) {
				System.out.println(r);
			}
		}
				
	}
	
	@Test
	public void testAdd() {
		System.out.println("testAdd");
		Activity r1 = new Activity("act1", "2018-08-09 12:01:01");
		Activity r2 = new Activity("act2", "2018-08-19 12:01:01");
		Activity r3 = new Activity("act3", "2018-08-29 12:01:01");
		Activity r4 = new Activity("act4", "2018-07-09 12:01:01");
		List<Activity> list = new ArrayList<>();
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		for(Activity r: list) {
			if(biz.findByName(r.getName())==null) {
				biz.saveAndFlush(r);
			}else {
				System.out.println("activity "+r.getName() +" exist");
			}
		}
	}
}
