package com.goebuy.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.entity.auth.Permission;
import com.goebuy.service.PermissionService;

@Service
public class PermissionBiz extends AbstractBiz<Permission, Integer>{
	
	@Autowired
	private PermissionService service;
	
	public List<Permission>  findByNameMatch(String name) {
		List<Permission> pList = service.findByNameMatch(name);
		return pList;
	}
	
	public Permission  findByName(String name) {
		Permission p = service.findByName(name);
		return p;
	}
	
	public List<Permission>  findByDescMatch(String desc) {
		List<Permission> pList = service.findByDescMatch(desc);
		return pList;
	}

	@Override
	public Permission save(Permission addObj) {
		return service.save(addObj);
	}
	
	@Override
	public Permission saveAndFlush(Permission addObj) {
		return service.saveAndFlush(addObj);
	}
	
	@Override
	public List<Permission> save(Iterable<Permission> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public void deleteById(Integer id) {
		service.delete(id);
	}

	@Override
	public Permission findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<Permission> findByIds(Iterable<Integer> ids) {
		return service.findAll(ids);
	}

	@Override
	public void deleteByObj(Permission o) {
		service.delete(o);
	}

	@Override
	public void deleteInBatch(Iterable<Permission> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public void flush() {
		service.flush();
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public long count() {
		return service.count();
	}

	@Override
	public List<Permission> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permission> findAll(Pageable pageable) {
		Page<Permission> objs= service.findAll(pageable);
		if(objs!=null) {
			return objs.getContent();
		}else {
			return null;
		}
	}

	@Override
	public List<Permission> findAll() {
		return service.findAll();
	}

	
}
