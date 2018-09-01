package com.goebuy.service.event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goebuy.entity.event.ActivityCategory;
import com.goebuy.entity.user.User;

@Repository
public interface ActivityCategoryService extends JpaRepository<ActivityCategory, Integer> {

//	@Autowired
//	EntityManager entityManager=null;

//	 @Modifying      // 说明该方法是修改操作
//   @Transactional  // 说明该方法是事务性操作
//	@Query
//	public void addSysLog(@Param())
	
	 @Query(value = "select b from ActivityCategory b where b.cate_name like %:name%")
	 List<ActivityCategory> findByNameMatch(@Param("name") String cateName);
	    
	    
	@Query(value = "select b from ActivityCategory b where b.cate_name=:qname")
	ActivityCategory findByName(@Param("qname") String catename);
	
	
//    @Modifying      // 说明该方法是修改操作
//    @Transactional  // 说明该方法是事务性操作
//    // 定义查询
//    // @Param注解用于提取参数
//    @Query("update User us set us.nickname=:qNickname, us.firstName=:qFirstName, us.lastName=:qLastName, us.password=:qPassword where us.id=:qId")
//    public void updateUser(@Param("qNickname") String nickname, @Param("qFirstName") String firstName,
//                           @Param("qLastName") String qLastName, @Param("qPassword") String password, @Param("qId") Integer id);


//    @Modifying      // 说明该方法是修改操作
//    @Transactional  // 说明该方法是事务性操作
//    // 定义查询
//    // @Param注解用于提取参数
//    @Query("update User us set us.nickname=:qNickname, us.firstName=:qFirstName, us.lastName=:qLastName, us.password=:qPassword where us.id=:qId")
//    public void updateUser(@Param("qNickname") String nickname, @Param("qFirstName") String firstName,
//                           @Param("qLastName") String qLastName, @Param("qPassword") String password, @Param("qId") Integer id);

    
    

}
