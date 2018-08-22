package com.goebuy.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.goebuy.biz.UserBiz;
import com.goebuy.entity.user.User;

import junit.framework.TestCase;

////@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class UserTest extends TestCase {

//	 @Autowired
//	 ApplicationContext ctx;

	@Autowired
	private UserBiz biz;

	@Autowired
	private EntityManagerFactory factory;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		assertNotNull(biz);
//			EntityManagerFactory factory=Persistence.createEntityManagerFactory("entityManagerFactory");
		assertNotNull(factory);
		EntityManager em = factory.createEntityManager();
		assertNotNull(em);
	}

	@Before
	public void init() {
		System.out.println("init");

	}

	@After
	public void after() {
		System.out.println("after");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		if (factory != null) {
			factory.close();
		}
	}

	@Test
	public void testCount() {
		System.out.println("user count: " + biz.count());
	}

	@Test
	public void testListAll() {
		List<User> users = biz.findAll();
		if (users != null) {
			for (User userEntity : users) {
				System.out.println("user: " + userEntity);
			}
		} else {
			System.out.println("users is empty");
		}
	}

	@Test
	public void testUserAdd() {
		System.out.println("testUserAdd");
		if (biz.findByName("addyyy2") == null) {
			User u = new User();
			u.setName("addyyy2");
//			u.setPassword("yyy2");
			biz.saveAndFlush(u);
		}

	}

	@Test
	public void testUserFind() {
		System.out.println("testUserFind");
		List<User> userList = biz.findByNameMatch("yyy");
		if (userList != null) {
			for (User u : userList) {
				System.out.println(u);
			}
		} else {
			System.out.println("userlist is null");
		}
	}

	@Test // 通过id列表来查询
	public void testFindUserByIds() {
		List<Integer> listIds = new ArrayList<Integer>();
		listIds.add(2);
		listIds.add(4);
		listIds.add(7);
		List<User> users = biz.findByIds(listIds);
		if(users!=null) {
			for(User u: users) {
				System.out.println(u);
			}
		}
	}

	@Test
	public void testEntityManager() {
		User u = new User();
		u.setName("addtest");
//		u.setPassword("addtest");
		if (biz.findByName(u.getName()) == null) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			// Session.save()-->Persist();
			em.persist(u); // 持久化到数据库.persist:持久化
			em.getTransaction().commit();
			em.close();
			assertNotNull(biz.findByName(u.getName()));
		}

	}

	@Ignore
	@Test
	public void testUserDelete() {
//			userService.findOne(new Exam)
//			UserEntity u =new UserEntity();
//			u.setNickname("addyyy2");
//			u.setPassword("yyy2");
//			userService.saveAndFlush( u);

	}

}
