package com.goebuy.biz.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.event.Activity;
import com.goebuy.service.event.ActivityService;

@Service
public class ActivityBiz extends AbstractBiz<Activity, Integer>{

	@Autowired
	private ActivityService service;
	
	
	@Override
	public Activity save(Activity addObj) {
		return service.save(addObj);
	}

	@Override
	public Activity saveAndFlush(Activity addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<Activity> save(Iterable<Activity> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<Activity> findAll() {
		return service.findAll();
	}

	@Override
	public List<Activity> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<Activity> findAll(Pageable pageable) {
		Page<Activity> page= service.findAll(pageable);
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
	public void deleteByObj(Activity o) {
		service.delete(o);
	}

	@Override
	public Activity findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<Activity> findByNameMatch(String name) {
		return service.findByNameMatch(name);
	}

	@Override
	public Activity findByName(String name) {
		return service.findByName(name);
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<Activity> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<Activity> findByIds(Iterable<Integer> ids) {
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
