package com.goebuy.service;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.goebuy.biz.PermissionBiz;
import com.goebuy.biz.RolePermissionBiz;
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
	private RoleService roleBiz;

	@Autowired
	private PermissionBiz permissionBiz;
	

	
	@Before
	public void init() {
		System.out.println("init");
		if(biz==null) {
			throw new RuntimeException("rolePermissionService is null");
		}
		
	}
	
	@Test
	public void testCount() {
		System.out.println("count: " + biz.count());
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
		Role role = roleBiz.findByRoleName("superadmin");
		if(role!=null) {
			List<Permission> permissionList = permissionBiz.findAll();
			biz.addPermissionToRole(permissionList, role);
		}
	}
	
}
