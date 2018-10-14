package com.goebuy.service;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.goebuy.biz.auth.PermissionBiz;
import com.goebuy.biz.auth.RoleBiz;
import com.goebuy.biz.auth.RolePermissionBiz;
import com.goebuy.entity.auth.Permission;
import com.goebuy.entity.auth.Role;
import com.goebuy.entity.auth.RolePermission;

import junit.framework.TestCase;

////@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class RolePermissionTest extends TestCase {


	@Autowired
	private RolePermissionBiz biz;
	
	@Autowired
	private RoleBiz roleBiz;

	@Autowired
	private PermissionBiz permissionBiz;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Before
	public void before() {
		System.out.println("before");
		assertNotNull(roleBiz);
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
	
	@Test
	public void testCount() {
		System.out.println("testCount");
		System.out.println("count: " + biz.count());
	}
	
	@Test
	public void testDeleteAllInBatch() {
		System.out.println("testDeleteAllInBatch");
		biz.deleteAllInBatch();
	}
	
	@Test
	public void testListAll() {
		List<RolePermission> rolePermissions =biz.findAll();
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
//		if (rolePermissionService == null) {
//			System.out.println("rolePermissionService is null");
//		}
//		Role r1 = roleService.findOne(1);
//		Permission p1 = permissionService.findOne(1);
//		rolePermissionBiz.addPermissionToRole(new RolePermission(r1, p1));
		
	}
	
	@Test
	public void testAddRolePermission() {
		Role role = roleBiz.findRoleByRoleName("superadmin");
		if(role!=null) {
			List<Permission> permissionList = permissionBiz.findAll();
			biz.addPermissionToRole(role, permissionList);
		}
		
		
		
		
	}
	
}
