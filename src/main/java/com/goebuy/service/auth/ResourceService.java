package com.goebuy.service.auth;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.goebuy.entity.auth.Resource;

@Repository
public interface ResourceService extends JpaRepository<Resource, Integer> {
	
	
	 @Query(value = "select b from Resource b where b.resource like %:name%")
	    List<Resource> findByNameMatch(@Param("name") String name);
	    
	    
	    @Query(value = "select b from Resource b where b.resource=:qname")
	    Resource findByName(@Param("qname") String name);
}
