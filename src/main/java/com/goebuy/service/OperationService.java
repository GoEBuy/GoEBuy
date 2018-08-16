package com.goebuy.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goebuy.entity.auth.Operation;


@Repository
public interface OperationService extends JpaRepository<Operation, Integer> {

	
	
}
