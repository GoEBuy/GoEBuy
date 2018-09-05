package com.goebuy.biz.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.event.UserEntryForm;
import com.goebuy.service.event.UserEntryFormService;

@Service
public class UserEntryFormBiz extends AbstractBiz<UserEntryForm, Integer>{

	@Autowired
	private UserEntryFormService service;
	
	
	@Override
	public UserEntryForm save(UserEntryForm addObj) {
		return service.save(addObj);
	}

	@Override
	public UserEntryForm saveAndFlush(UserEntryForm addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<UserEntryForm> save(Iterable<UserEntryForm> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<UserEntryForm> findAll() {
		return service.findAll();
	}

	@Override
	public List<UserEntryForm> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<UserEntryForm> findAll(Pageable pageable) {
		Page<UserEntryForm> page= service.findAll(pageable);
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
	public void deleteByObj(UserEntryForm o) {
		service.delete(o);
	}

	@Override
	public UserEntryForm findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<UserEntryForm> findByNameMatch(String name) {
//		return service.findByNameMatch(name);
		return null;
	}

	@Override
	public UserEntryForm findByName(String name) {
//		return service.findByName(name);
		return null;
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<UserEntryForm> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<UserEntryForm> findByIds(Iterable<Integer> ids) {
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
