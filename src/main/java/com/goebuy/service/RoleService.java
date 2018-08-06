package com.goebuy.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goebuy.entity.Role;

@Repository
public interface RoleService extends JpaRepository<Role, Integer> {

	
	 // 修改博文操作
    @Modifying
    @Transactional
    @Query("update Role role set role.role=:qRole, role.description=:qDesc where role.id=:qId")
    void updateRole(@Param("qRole") String rolename, @Param("qDesc") String desc, @Param("qId") int id);

    
//    @Modifying
//    @Query("update Role sc set sc.deleted = true where sc.id in :ids")
//    public void deleteByIds(@Param(value = "ids") List<String> ids);
    
    @Query(value = "select b from Role b where b.role like %:rolename%")
    List<Role> findByRoleNameMatch(@Param("rolename") String rolename);
    
    
    @Query(value = "select b from Role b where b.role =:rolename")
    Role findByRoleName(@Param("rolename") String rolename);
    
    
    
    @Query(value = "select b from Role b where b.description like %:roleDesc%")
    List<Role> findByRoleDescMatch(@Param("roleDesc") String roleDesc);
    
    
	
}
