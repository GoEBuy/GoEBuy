package com.goebuy.biz.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.auth.UserRole;
import com.goebuy.service.auth.UserRoleService;


@Service
public class UserRoleBiz extends AbstractBiz<UserRole, Integer>{
	
	@Autowired
	private UserRoleService service;


	@Override
	public UserRole save(UserRole addObj) {
		return service.save(addObj);
	}

	@Override
	public UserRole saveAndFlush(UserRole addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<UserRole> save(Iterable<UserRole> addObjs) {
		return service.save(addObjs);
	}


	@Override
	public List<UserRole> findAll() {
		return service.findAll();
	}
	
	
	@Override
	public List<UserRole> findAll(Sort sort) {
		return service.findAll();
	}

	@Override
	public List<UserRole> findAll(Pageable pageable) {
		Page<UserRole> page = service.findAll(pageable);
		if(page!=null) {
			return page.getContent();
		}
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		service.delete(id);
	}

	@Override
	public void deleteByObj(UserRole o) {
		service.delete(o);
	}

	@Override
	public UserRole findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<UserRole> findByNameMatch(String name) {
//		return service.findByNa;
		return null;
	}

	@Override
	public UserRole findByName(String name) {
		return null;
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<UserRole> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<UserRole> findByIds(Iterable<Integer> ids) {
		return service.findAll(ids);
	}

	@Override
	public void flush() {
		service.flush();
	}

	@Override
	public long count() {
		return service.count();
	}

	@Override
	public boolean exists(int id) {
		return service.exists(id);
	}

	
	
}
