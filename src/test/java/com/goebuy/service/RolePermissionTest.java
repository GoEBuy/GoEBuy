package com.goebuy.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.goebuy.biz.RolePermissionBiz;
import com.goebuy.entity.auth.Permission;
import com.goebuy.entity.auth.Role;
import com.goebuy.entity.auth.RolePermission;

import junit.framework.TestCase;

////@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class RolePermissionTest extends TestCase {

//	 @Autowired
//	 ApplicationContext ctx;

//	    protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	RolePermissionBiz rolePermissionBiz;
	
	@Autowired
	RoleService roleService;

	@Autowired
	PermissionService permissionService;
	
	@Before
	public void init() {
		System.out.println("init");
		if(rolePermissionBiz==null) {
			throw new RuntimeException("rolePermissionService is null");
		}
		
//		Role r1 = new Role("staff");
//		Role r2 = new Role("admin");
//		Role r3 = new Role("superadmin");
//		roleService.save(r1);
//		roleService.save(r2);
//		roleService.save(r3);
//		
//		roleService.flush();
//		
//		Permission p1 = new Permission("add");
//		Permission p2 = new Permission("update");
//		Permission p3 = new Permission("delete");
//		Permission p4 = new Permission("query");
//		Permission p5 = new Permission("list");
//		permissionService.save(p1);
//		permissionService.save(p2);
//		permissionService.save(p3);
//		permissionService.save(p4);
//		permissionService.save(p5);
//		permissionService.flush();
//		
	}
	
	@Test
	public void testCount() {
//		System.out.println("count: " + rolePermissionBiz.count());
	}
	
	@Test
	public void testListAll() {
		List<RolePermission> rolePermissions =rolePermissionBiz.findAll();
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
		Role role = roleService.findByRoleName("superadmin");
		if(role!=null) {
			List<Permission> permissionList = permissionService.findAll();
			rolePermissionBiz.addPermissionToRole(permissionList, role);
		}
	}
	
}
