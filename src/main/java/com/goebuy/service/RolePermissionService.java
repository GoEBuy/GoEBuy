package com.goebuy.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goebuy.entity.RolePermission;

@Repository
public interface RolePermissionService extends JpaRepository<RolePermission, Integer> {
	
//    // 修改博文操作
//    @Modifying
//    @Transactional
//    @Query("update BlogEntity blog set blog.title=:qTitle, blog.userByUserId.id=:qUserId," +
//            " blog.content=:qContent, blog.pubDate=:qPubDate where blog.id=:qId")
//    void updateBlog(@Param("qTitle") String title, @Param("qUserId") int userId, @Param("qContent") String content,
//                    @Param("qPubDate") Date pubDate, @Param("qId") int id);
	 
	/**
	 * 使用Native SQL Query
	 * @param roleId
	 * @param permissionId
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into auth_rolepermission(role_id, permission_id ) values(:qRoleId, :qPermissionId)", nativeQuery = true)
	void addRolePermission(@Param("qRoleId") int roleId, @Param("qPermissionId") int permissionId);
    

}
