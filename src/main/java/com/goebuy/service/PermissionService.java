package com.goebuy.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.goebuy.entity.Permission;
import com.goebuy.entity.Role;

@Repository
public interface PermissionService extends JpaRepository<Permission, Integer> {

	@Query(value = "select b from Permission b where b.permission =:permission")
	Permission findByName(@Param("permission") String permission);

	@Query(value = "select b from Permission b where b.desc like %:desc%")
	List<Permission> findByDescMatch(@Param("desc") String desc);

	 @Query(value = "select b from Permission b where b.permission like %:permission%")
	List<Permission> findByNameMatch(@Param("permission") String permission);
	    
	
}
