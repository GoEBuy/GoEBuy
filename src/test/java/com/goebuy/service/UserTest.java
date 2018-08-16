package com.goebuy.service;

import java.util.ArrayList;
import java.util.List;

import com.goebuy.entity.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

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
		List<User> users =userService.findAll();
		if(users!=null) {
			for(User user : users ) {
				System.out.println("user: " + user);
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
			User u =new User();
			u.setNickname("addyyy2");
			u.setPassword("yyy2");
			userService.saveAndFlush( u);
		}
//		EntityManagerFactory factory=Persistence.createEntityManagerFactory("entityManagerFactory");
//		EntityManager em=factory.createEntityManager();
//		User u =new User();
//		u.setNickname("addyyy1");
//		u.setPassword("yyy1");
//		em.getTransaction().begin();//开始事物
//		    //Session.save()-->Persist();
//		em.persist(u); //持久化到数据库.persist:持久化
//		em.getTransaction().commit();
//		em.close();
//		factory.close();
		
	}
	
	@Test 
	public void testUserFind() {
		System.out.println("testUserFind");
	List<User> userList = 	userService.findByNameMatch("yyy");
	if(userList !=null) {
		for(User u : userList) {
			System.out.println(u);
		}
	}else {
		System.out.println("userlist is null");
	}
	}
	
	
	@Test//通过id列表来查询
	public void testFindUserByIds(){
		List<Integer> listIds = new ArrayList<Integer>();
		listIds.add(2);
		listIds.add(4);
		listIds.add(7);
		List<User> users  = userService.findAll(listIds);
//		System.out.println(JSON.toJSONString(users));
	}
	
	
//	@Test
//	public void testUserDelete() {
//		if (userService == null) {
//			System.out.println("userService is null");
//		}else {
//			userService.findOne(new Exam)
//			User u =new User();
//			u.setNickname("addyyy2");
//			u.setPassword("yyy2");
//			userService.saveAndFlush( u);
//		}
//		EntityManagerFactory factory=Persistence.createEntityManagerFactory("entityManagerFactory");
//		EntityManager em=factory.createEntityManager();
//		User u =new User();
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
