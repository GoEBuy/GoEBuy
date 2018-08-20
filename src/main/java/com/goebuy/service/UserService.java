package com.goebuy.service;

import java.util.List;

import com.goebuy.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 索引参数与命名参数 
 * @author Administrator
 *
 */
@Repository
public interface UserService extends JpaRepository<User, Integer> {

    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
//    @Query("update User us set us.nickname=:qNickname, us.firstName=:qFirstName, us.lastName=:qLastName, us.password=:qPassword where us.id=:qId")
//    public void updateUser(@Param("qNickname") String nickname, @Param("qFirstName") String firstName,
//                           @Param("qLastName") String qLastName, @Param("qPassword") String password, @Param("qId") Integer id);
    @Query("update User us set us.name=:qname where us.id=:qId")
    public void updateUser(@Param("qname") String name, @Param("qId") Integer id);
    
    @Query(value = "select b from User b where b.nickname like %:name%")
    List<User> findByNameMatch(@Param("name") String name);
    
    
    @Query(value = "select b from User b where b.name=:qname")
    User findByName(@Param("qname") String name);
    
    
//    @Modifying 
//    @Transactional  // 说明该方法是事务性操作
//    @Query("update User u set u.firstname = ?1 where u.lastname = ?2") 
//    int setFixedFirstnameFor(String firstname, String lastname); 

//    @Modifying      // 说明该方法是修改操作
//    @Transactional  // 说明该方法是事务性操作
//    // 定义查询
//    // @Param注解用于提取参数
//    @Query("update User us set us.nickname=:qNickname, us.firstName=:qFirstName, us.lastName=:qLastName, us.password=:qPassword where us.id=:qId")
//    public void updateUser(@Param("qNickname") String nickname, @Param("qFirstName") String firstName,
//                           @Param("qLastName") String qLastName, @Param("qPassword") String password, @Param("qId") Integer id);

    
    

}
