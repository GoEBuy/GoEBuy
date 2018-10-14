package com.goebuy.biz;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.goebuy.biz.auth.UserRoleBiz;
import com.goebuy.entity.auth.UserRole;

import junit.framework.TestCase;

////@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class UserRoleBizTest extends TestCase {

//	 @Autowired
//	 ApplicationContext ctx;

	@Autowired
    UserRoleBiz biz;
	
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
		List<UserRole> roleList =biz.findAll();
		if(roleList!=null) {
			for(UserRole r : roleList ) {
				System.out.println("UserRole: " + r );
			}
		}else {
			System.out.println("UserRoles is null");
		}
	}

//	@Test
//	public void testFind() {
//		System.out.println("testFind");
//		List<UserRole> roleList = biz.findByNameMatch("adm");
//		if (roleList!=null) {
//			for(Activity r: roleList) {
//				System.out.println(r);
//			}
//		}
//				
//	}
	
	public void testAdd() {
		System.out.println("testAdd");
//		UserRole r1 = new UserRole("act1", "2018-08-09 12:01:01");
//		UserRole r2 = new UserRole("act2", "2018-08-19 12:01:01");
//		UserRole r3 = new UserRole("act3", "2018-08-29 12:01:01");
//		UserRole r4 = new UserRole("act4", "2018-07-09 12:01:01");
//		List<Activity> list = new ArrayList<>();
//		list.add(r1);
//		list.add(r2);
//		list.add(r3);
//		list.add(r4);
//		for(Activity r: list) {
//			if(biz.findByName(r.getName())==null) {
//				biz.saveAndFlush(r);
//			}else {
//				System.out.println("activity "+r.getName() +" exist");
//			}
//		}
	}
}
