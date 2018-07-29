package com.goebuy.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;

////@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class RoleTest extends TestCase {

//	 @Autowired
//	 ApplicationContext ctx;

//	    protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	RoleService roleService;
	

	@Before
	public void init() {
//		EntityManagerFactory factory=Persistence.createEntityManagerFactory("entityManagerFactory");
//		EntityManager em=factory.createEntityManager();
//		em.getTransaction().begin();//开始事物
//		    //Session.save()-->Persist();
//		em.persist(new Person("创梦网络")); //持久化到数据库.persist:持久化
//		em.getTransaction().commit();
//		em.close();
//		factory.close();
		System.out.println("init");
		if(roleService==null) {
			System.out.println("roleService is null");
		}else {
			System.out.println(roleService);
		}
	}
	
	@Test
	public void testCount() {
//		System.out.println("role count: " + roleService.count());
	}
	
	@Test
	public void testListAll() {
//		List<Role> users =roleService.findAll();
//		if(users!=null) {
//			for(Role userEntity : users ) {
//				System.out.println("Role: " + userEntity );
//			}
//		}else {
//			System.out.println("Roles is null");
//		}
	}

	@Test
	public void testUserAdd() {
//		System.out.println("hello");
//		if (roleService == null) {
//			System.out.println("roleService is null");
//		}
	}
}
