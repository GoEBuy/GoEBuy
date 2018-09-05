package com.goebuy.biz.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.auth.Resource;
import com.goebuy.service.auth.ResourceService;

@Service
public class ResourceBiz extends AbstractBiz<Resource, Integer>{
	
	@Autowired
	private ResourceService service;
	
	public List<Resource>  findByNameMatch(String name) {
		List<Resource> pList = service.findByNameMatch(name);
		return pList;
	}
	
	public Resource  findByName(String name) {
		Resource p = service.findByName(name);
		return p;
	}
	
	@Override
	public Resource save(Resource addObj) {
		return service.save(addObj);
	}
	
	@Override
	public Resource saveAndFlush(Resource addObj) {
		return service.saveAndFlush(addObj);
	}
	
	@Override
	public List<Resource> save(Iterable<Resource> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public void deleteById(Integer id) {
		service.delete(id);
	}

	@Override
	public Resource findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<Resource> findByIds(Iterable<Integer> ids) {
		return service.findAll(ids);
	}

	@Override
	public void deleteByObj(Resource o) {
		service.delete(o);
	}

	@Override
	public void deleteInBatch(Iterable<Resource> delObjs) {
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
	public List<Resource> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> findAll(Pageable pageable) {
		Page<Resource> objs= service.findAll(pageable);
		if(objs!=null) {
			return objs.getContent();
		}else {
			return null;
		}
	}

	@Override
	public List<Resource> findAll() {
		return service.findAll();
	}

	@Override
	public boolean exists(int id) {
		return service.exists(id);
	}

	
}
