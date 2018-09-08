package com.goebuy.biz;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.goebuy.biz.event.ActivityCategoryBiz;
import com.goebuy.entity.event.ActivityCategory;
import junit.framework.TestCase;

////@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:mvc-dispatcher-servlet.xml" })
public class ActivityCategoryBizTest extends TestCase {

//	 @Autowired
//	 ApplicationContext ctx;

	@Autowired
	ActivityCategoryBiz biz;
	
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
		List<ActivityCategory> roleList =biz.findAll();
		if(roleList!=null) {
			for(ActivityCategory r : roleList ) {
				System.out.println("ActivityCategory: " + r );
			}
		}else {
			System.out.println("ActivityCategorys is null");
		}
	}

	@Test
	public void testFind() {
		System.out.println("testFind");
		List<ActivityCategory> roleList = biz.findByNameMatch("adm");
		if (roleList!=null) {
			for(ActivityCategory r: roleList) {
				System.out.println(r);
			}
		}
				
	}
	
	@Test
	public void testAdd() {
		System.out.println("testAdd");
		String[] cateArray = {"运动", "学习", "旅游", "居家", "亲子", "学习","其他" };
		for(String r: cateArray) {
			if(biz.findByName(r)==null) {
				ActivityCategory obj = new ActivityCategory(r);
				biz.saveAndFlush(obj);
			}else {
				System.out.println("ActivityCategory "+r +" exist");
			}
		}
	}
	
	@Ignore
	public void testDeleteAllInBatch() {
		biz.deleteAllInBatch();
	}
	
	
}
