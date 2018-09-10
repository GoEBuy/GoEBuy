package com.goebuy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

import com.goebuy.biz.user.UserBiz;
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
		assertNotNull(factory);
		EntityManager em = factory.createEntityManager();
		assertNotNull(em);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		if (factory != null) {
			factory.close();
		}
	}
	
	

	@Before
	public void before() {
		System.out.println("before");

	}

	@After
	public void after() {
		System.out.println("after");
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
		User u = new User();
		u.setName("addyyy2");
		u.setAddress("address");
		u.setBirthday("birth");
		u.setCreateTime("cratetime");
		u.setEducation("edu");
		u.setEmail("email");
		u.setExt("ext");
		u.setGender(0);
//		u.setId(1);
		u.setIdCardBackPic("setIdCardBackPic");
		u.setIdCardFrontPic("setIdCardFrontPic");
		u.setIdCardNo("setIdCardNo");
		u.setInstitution("inst");
		u.setJob("job");
		u.setMerchant(false);
		u.setName("name");
		u.setNickname("nickname");
		u.setPassword("password");
		u.setPhoneNo("phoneno");
		u.setUpdateTime("updatetime");
		u.setUser(null);
		u.setWechatHeadPic("wechatHeadPic");
		u.setWechatNickname("wenickname");
		u.setWechatNo("wechatNo");
		if (biz.findByNickName("nickname") == null) {
			biz.saveAndFlush(u);
			assertNotNull(biz.findByNickName(u.getNickname()));
		}else {
			System.out.println("user "+u.getNickname() + " is exists");
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

	@Test 
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
		Random random = new Random();
		int rid= random.nextInt(100);
		User u = new User();
		u.setName("addtest"+rid);
		u.setAddress("address"+rid);
		u.setBirthday("birth");
		u.setCreateTime("cratetime");
		u.setEducation("edu");
		u.setEmail("email");
		u.setExt("ext");
		u.setGender(0);
//		u.setId(1);
		u.setIdCardBackPic("setIdCardBackPic");
		u.setIdCardFrontPic("setIdCardFrontPic");
		u.setIdCardNo("IdCardNo"+rid);
		u.setInstitution("inst");
		u.setJob("job");
		u.setMerchant(false);
		u.setName("name");
		u.setNickname("nickname"+random);
		u.setPassword("password");
		u.setPhoneNo("phoneno"+random);
		u.setUpdateTime("updatetime");
		u.setUser(null);
		u.setWechatHeadPic("wechatHeadPic");	
		u.setWechatNickname("wenickname");
		u.setWechatNo("wechatNo");
		if (biz.findByNickName(u.getNickname()) == null) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			// Session.save()-->Persist();
			em.persist(u); // 持久化到数据库.persist:持久化
			em.getTransaction().commit();
			em.close();
			assertNotNull(biz.findByNickName(u.getNickname()));
		}else {
			System.out.println("user "+u.getNickname() + " is exists");
		}

	}

	@Ignore
	@Test
	public void testUserDelete() {
		User user = biz.findById(1);
		if(user!=null) {
			biz.deleteByObj(user);;
		}
	}
	
	@Ignore
	@Test
	public void testDeleteAllInBatch() {
		biz.deleteAllInBatch();
	}

}
