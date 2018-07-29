package com.goebuy.service;

import org.springframework.stereotype.Repository;

import com.goebuy.entity.Permission;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository//
public interface PermissionService extends JpaRepository<Permission, Integer> {

}
