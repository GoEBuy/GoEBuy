package com.goebuy.service.auth;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goebuy.entity.auth.UserRole;

@Repository
public interface UserRoleService extends JpaRepository<UserRole, Integer> {

	
	
	 /**
     * 	 用户联查询
     * @param id
     * @return
     */
    @Query(value = "select * from auth_user_role where merchant_id=?1", nativeQuery = true)
    List<UserRole> getUserRolesByMerchantId(Integer id);
    
    /**
     * 	角色联查询
     * @param id
     * @return
     */
    @Query(value = "select * from auth_user_role where role_id=?1", nativeQuery = true)
    List<UserRole> getUserRolessByRoleId(Integer id);
    
    
    /**
     * 2.1、通过用户 id 删除用户角色关系
     */
    @Modifying
    @Transactional
    @Query(value="delete from auth_user_role where merchant_id=?1",nativeQuery=true)
    void deleteUserRolesByUserId(Integer merchantId);
    
    
    /**
     * 2.2、通过角色 id 删除关系
     */
    @Modifying
    @Transactional
    @Query(value="delete from auth_user_role where role_id=?1",nativeQuery=true)
    void deleteConnectionByStudentId(Integer studentId);
    
//	
//	 // 修改博文操作
//    @Modifying
//    @Query("update UserRole role set role.role=:qRole, role.description=:qDesc where role.id=:qId")
//    void updateRole(@Param("qRole") String rolename, @Param("qDesc") String desc, @Param("qId") int id);
//
//    
////    @Modifying
////    @Query("update Role sc set sc.deleted = true where sc.id in :ids")
////    public void deleteByIds(@Param(value = "ids") List<String> ids);
//    
//    @Query(value = "select b from Role b where b.role like %:rolename%")
//    List<Role> findByRoleNameMatch(@Param("rolename") String rolename);
//    
//    
//    @Query(value = "select b from Role b where b.role =:rolename")
//    Role findByRoleName(@Param("rolename") String rolename);
//    
//    
//    
//    @Query(value = "select b from Role b where b.description like %:roleDesc%")
//    List<Role> findByRoleDescMatch(@Param("roleDesc") String roleDesc);
//    
//    
	
}
