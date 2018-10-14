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

import com.goebuy.biz.auth.PermissionBiz;
import com.goebuy.entity.auth.Permission;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class PermissionTest extends TestCase {
	
	@Autowired
    PermissionBiz biz;
	
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
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
	
	@Test
	public void testCount() {
		System.out.println("count: " + biz.count());
	}
	
	@Test
	public void testListAll() {
		List<Permission> list =biz.findAll();
		if(list!=null) {
			for(Permission r : list ) {
				System.out.println("Permission: " + r );
			}
		}else {
			System.out.println("Permission list is null");
		}
	}
	
	@Test
	public void testAdd() {
		System.out.println("testAdd");
		List<Permission> permissions = new ArrayList<>();
		permissions.add(new Permission("add"));
		permissions.add(new Permission("delete"));
		permissions.add(new Permission("update"));
		permissions.add(new Permission("list"));
		permissions.add(new Permission("find"));
		permissions.add(new Permission("query"));
		for(Permission permission : permissions) {
			if(biz.findByName(permission.getPermission()) ==null ) {
				biz.saveAndFlush(permission);
			}
		}
	}
	
	@Test
	public void testDeleteByObj() {
		long count = biz.count();
		Permission permission = biz.findByName("delete");
		if(permission!=null) {
			biz.deleteByObj(permission);
			assertEquals(biz.count(), count-1);
			
			biz.saveAndFlush(permission);
			assertEquals(biz.count(), count);
		}
	}

}
