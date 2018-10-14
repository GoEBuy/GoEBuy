package com.goebuy.biz;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.goebuy.entity.Order;
import junit.framework.TestCase;

////@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class OrderBizTest extends TestCase {

//	 @Autowired
//	 ApplicationContext ctx;

	@Autowired
    OrderBiz biz;
	
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
		List<Order> roleList =biz.findAll();
		if(roleList!=null) {
			for(Order r : roleList ) {
				System.out.println("Order: " + r );
			}
		}else {
			System.out.println("Orders is null");
		}
	}

//	@Test
//	public void testFind() {
//		System.out.println("testFind");
//		List<SystemLog> roleList = biz.findByNameMatch("adm");
//		if (roleList!=null) {
//			for(Activity r: roleList) {
//				System.out.println(r);
//			}
//		}
//				
//	}
	
	@Test
	public void testAdd() {
		System.out.println("testAdd");
//		Order r1 = new Order();
//		r1.setCreateDate("2018-09-02 19:43:26");
//		r1.setLogType(-1);
//		r1.setLoginName("");
//		r1.setMethod("get");
//		r1.setOperationName("user");
//		r1.setOperationType("list");
//		r1.setParams("[2]");
//		r1.setResultMsg("<200 OK,{\\\"address\\\":\\\"address\\\",\\\"wechatNo\\\":\\\"wechatNo\\\"},{}>");
//		biz.saveAndFlush(r1);
//		List<Activity> list = new ArrayList<>();
//		list.add(r1);
//		list.add(r2);
//		list.add(r3);
//		list.add(r4);
//		for(Activity r: list) {
//			if(biz.findByName(r.getName())==null) {
//				biz.saveAndFlush(r);
//			}else {
//				System.out.println("activity "+r.getName() +" exist");
//			}
//		}
	}
}
