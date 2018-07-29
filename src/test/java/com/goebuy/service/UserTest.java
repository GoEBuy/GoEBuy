package com.goebuy.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.goebuy.entity.UserEntity;

import junit.framework.TestCase;

////@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class UserTest extends TestCase {

//	 @Autowired
//	 ApplicationContext ctx;

//	    protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UserService userService;
	
	

	@Before
	public void init() {
		System.out.println("init");
	}
	
	@Test
	public void testCount() {
		System.out.println("user count: " + userService.count());
	}
	
	@Test
	public void testListAll() {
		List<UserEntity> users =userService.findAll();
		if(users!=null) {
			for(UserEntity userEntity : users ) {
				System.out.println("user: " + userEntity );
			}
		}else {
			System.out.println("users is null");
		}
	}

	@Test
	public void testUserAdd() {
		System.out.println("hello");
		if (userService == null) {
			System.out.println("userService is null");
		}else {
			UserEntity u =new UserEntity();
			u.setNickname("addyyy2");
			u.setPassword("yyy2");
			userService.saveAndFlush( u);
		}
//		EntityManagerFactory factory=Persistence.createEntityManagerFactory("entityManagerFactory");
//		EntityManager em=factory.createEntityManager();
//		UserEntity u =new UserEntity();
//		u.setNickname("addyyy1");
//		u.setPassword("yyy1");
//		em.getTransaction().begin();//开始事物
//		    //Session.save()-->Persist();
//		em.persist(u); //持久化到数据库.persist:持久化
//		em.getTransaction().commit();
//		em.close();
//		factory.close();
		
	}
	
//	@Test
//	public void testUserDelete() {
//		if (userService == null) {
//			System.out.println("userService is null");
//		}else {
//			userService.findOne(new Exam)
//			UserEntity u =new UserEntity();
//			u.setNickname("addyyy2");
//			u.setPassword("yyy2");
//			userService.saveAndFlush( u);
//		}
//		EntityManagerFactory factory=Persistence.createEntityManagerFactory("entityManagerFactory");
//		EntityManager em=factory.createEntityManager();
//		UserEntity u =new UserEntity();
//		u.setNickname("addyyy1");
//		u.setPassword("yyy1");
//		em.getTransaction().begin();//开始事物
//		    //Session.save()-->Persist();
//		em.persist(u); //持久化到数据库.persist:持久化
//		em.getTransaction().commit();
//		em.close();
//		factory.close();
//	}
	
}
