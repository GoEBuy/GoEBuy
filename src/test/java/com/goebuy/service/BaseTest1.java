package com.goebuy.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;

//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:mvc-dispatcher-servlet.xml"})
public class BaseTest1 extends TestCase {

//    @Autowired
//    ApplicationContext ctx;
//
//    protected Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Resource(name = "UserService")
    @Autowired
    UserService userService;

    @Before
    public void init() {
        System.out.println("init");
    }

    @Test
    public void testUserAdd() {
        System.out.println("hello");
        if(userService == null) {
            System.out.println("userService is null" );
        }
//	 long count =userService.count();
//	 System.out.println(String.valueOf(count));
//	 userService.deleteUser(userId)
//	 	postService.getUsers();
//		Map<Integer,Object> map= postService.query2LevelPostType();
//		System.out.println("data size:" + map.size());
    }
}
