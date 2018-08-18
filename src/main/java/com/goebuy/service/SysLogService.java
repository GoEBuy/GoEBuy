package com.goebuy.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goebuy.entity.SystemLog;

@Repository
public interface SysLogService extends JpaRepository<SystemLog, Integer> {

//	@Autowired
//	EntityManager entityManager=null;

//	 @Modifying      // 说明该方法是修改操作
//   @Transactional  // 说明该方法是事务性操作
//	@Query
//	public void addSysLog(@Param())
	
	
		
	
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
