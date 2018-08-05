package com.goebuy.service;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.goebuy.entity.Role;

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
		System.out.println("role count: " + roleService.count());
	}
	
	@Test
	public void testListAll() {
		List<Role> roleList =roleService.findAll();
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
		List<Role> roleList = roleService.findByRoleNameMatch("adm");
		if (roleList!=null) {
			for(Role r: roleList) {
				System.out.println(r);
			}
		}
				
	}
	
	@Ignore
	@Test
	public void testAdd() {
		System.out.println("testAdd");
		if (roleService == null) {
			System.out.println("roleService is null");
		}else {
			if(roleService.findByRoleNameMatch("normal")==null) {
				roleService.save(new Role("normal", "normal"));
			}
		}
	}
}
