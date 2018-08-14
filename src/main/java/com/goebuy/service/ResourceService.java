package com.goebuy.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goebuy.entity.Resource;

@Repository
public interface ResourceService extends JpaRepository<Resource, Integer> {

}
