package com.goebuy.service.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goebuy.entity.user.Merchant;

/**
 * 索引参数与命名参数 
 * @author Administrator
 *
 */
@Repository
public interface MerchantService extends JpaRepository<Merchant, Integer> {

//    @Modifying      // 说明该方法是修改操作
//    @Transactional  // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
//    @Query("update User us set us.nickname=:qNickname, us.firstName=:qFirstName, us.lastName=:qLastName, us.password=:qPassword where us.id=:qId")
//    public void updateUser(@Param("qNickname") String nickname, @Param("qFirstName") String firstName,
//                           @Param("qLastName") String qLastName, @Param("qPassword") String password, @Param("qId") Integer id);
//    @Query("update User us set us.name=:qname where us.id=:qId")
//    public void updateUser(@Param("qname") String name, @Param("qId") Integer id);
//    
    @Query(value = "select b from Merchant b where b.name like %:name%")
    List<Merchant> findByNameMatch(@Param("name") String name);
    
    @Query(value = "select b from Merchant b where b.name=:qname")
    Merchant findByName(@Param("qname") String name);
    
    @Query(value = "select b from Merchant b where b.email=:qemail and b.password=:qpassword")
    Merchant loginByEmail(@Param("qemail") String email,@Param("qpassword") String password );
    
    @Query(value = "select b from Merchant b where b.phoneNo=:qphone and b.password=:qpassword")
    Merchant loginByPhone(@Param("qphone") String phone, @Param("qpassword") String password );
    
//    Merchant registerByEmail(@Param("qemail") String email,@Param("qpassword") String password );
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
