package com.goebuy.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.goebuy.entity.RolePermission;

import junit.framework.TestCase;

////@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class RolePermissionTest extends TestCase {

	 @Autowired
	 ApplicationContext ctx;

//	    protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	RolePermissionService rolePermissionService;
	
	

	@Before
	public void init() {
		System.out.println("init");
		if(rolePermissionService==null) {
			throw new RuntimeException("rolePermissionService is null");
		}
	}
	
	@Test
	public void testCount() {
		System.out.println("count: " + rolePermissionService.count());
	}
	
	@Test
	public void testListAll() {
		List<RolePermission> rolePermissions =rolePermissionService.findAll();
		if(rolePermissions!=null) {
			for(RolePermission r : rolePermissions ) {
				System.out.println("RolePermission: " + r );
			}
		}else {
			System.out.println("RolePermissions is null");
		}
	}

	@Test
	public void testAdd() {
//		System.out.println("hello");
//		if (userService == null) {
//			System.out.println("userService is null");
//		}
	}
}
