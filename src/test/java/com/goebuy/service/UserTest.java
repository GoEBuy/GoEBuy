package com.goebuy.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.goebuy.entity.UserEntity;

import junit.framework.TestCase;

////@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class UserTest extends TestCase {

	 @Autowired
	 ApplicationContext ctx;

//	    protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UserService userService;
	
	

	@Before
	public void init() {
		System.out.println("init");
	}
	
	@Test
	public void testCount() {
		System.out.println("user count: " + userService.count());
	}
	
	@Test
	public void testListAll() {
		List<UserEntity> users =userService.findAll();
		if(users!=null) {
			for(UserEntity userEntity : users ) {
				System.out.println("user: " + userEntity );
			}
		}else {
			System.out.println("users is null");
		}
	}

	@Test
	public void testUserAdd() {
		System.out.println("hello");
		if (userService == null) {
			System.out.println("userService is null");
		}
	}
}
