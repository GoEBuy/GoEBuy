package com.goebuy.biz.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.event.UserTip;
import com.goebuy.service.event.UserTipService;

@Service
public class UserTipBiz extends AbstractBiz<UserTip, Integer>{

	@Autowired
	private UserTipService service;
	
	
	@Override
	public UserTip save(UserTip addObj) {
		return service.save(addObj);
	}

	@Override
	public UserTip saveAndFlush(UserTip addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<UserTip> save(Iterable<UserTip> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<UserTip> findAll() {
		return service.findAll();
	}

	@Override
	public List<UserTip> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<UserTip> findAll(Pageable pageable) {
		Page<UserTip> page= service.findAll(pageable);
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
	public void deleteByObj(UserTip o) {
		service.delete(o);
	}

	@Override
	public UserTip findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<UserTip> findByNameMatch(String name) {
//		return service.findByNameMatch(name);
		return null;
	}

	@Override
	public UserTip findByName(String name) {
//		return service.findByName(name);
		return null;
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<UserTip> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<UserTip> findByIds(Iterable<Integer> ids) {
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
