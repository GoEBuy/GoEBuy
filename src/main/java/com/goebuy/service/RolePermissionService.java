package com.goebuy.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

    

}
