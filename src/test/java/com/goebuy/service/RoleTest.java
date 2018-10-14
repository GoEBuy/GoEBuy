package com.goebuy.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.goebuy.biz.auth.RoleBiz;
import com.goebuy.entity.auth.Role;

import junit.framework.TestCase;

////@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class RoleTest extends TestCase {

//	 @Autowired
//	 ApplicationContext ctx;

	@Autowired
    RoleBiz biz;
	
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
//		EntityManagerFactory factory=Persistence.createEntityManagerFactory("entityManagerFactory");
//		EntityManager em=factory.createEntityManager();
//		em.getTransaction().begin();//开始事物
//		    //Session.save()-->Persist();
//		em.persist(new PersonCertification("创梦网络")); //持久化到数据库.persist:持久化
//		em.getTransaction().commit();
//		em.close();
//		factory.close();
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
		List<Role> roleList =biz.findAll();
		if(roleList!=null) {
			for(Role r : roleList ) {
				System.out.println("Role: " + r );
			}
		}else {
			System.out.println("Roles is null");
		}
	}

	@Ignore
	@Test
	public void testFind() {
		System.out.println("testFind");
		List<Role> roleList = biz.findByNameMatch("adm");
		if (roleList!=null) {
			for(Role r: roleList) {
				System.out.println(r);
			}
		}
				
	}
	
	@Test
	public void testAdd() {
		System.out.println("testAdd");
		Role r1 = new Role("staff");
		Role r2 = new Role("admin");
		Role r3 = new Role("superadmin");
		Role r4 = new Role("normal");
		List<Role> list = new ArrayList<>();
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		for(Role r: list) {
			if(biz.findByName(r.getRole())==null) {
				biz.saveAndFlush(r);
			}else {
				System.out.println("role "+r.getRole()+" exist");
			}
		}
	}
}
