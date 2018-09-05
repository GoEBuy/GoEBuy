package com.goebuy.biz.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.event.ActivityCategory;
import com.goebuy.service.event.ActivityCategoryService;

@Service
public class ActivityCategoryBiz extends AbstractBiz<ActivityCategory, Integer>{

	@Autowired
	private ActivityCategoryService service;
	
	
	@Override
	public ActivityCategory save(ActivityCategory addObj) {
		return service.save(addObj);
	}

	@Override
	public ActivityCategory saveAndFlush(ActivityCategory addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<ActivityCategory> save(Iterable<ActivityCategory> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<ActivityCategory> findAll() {
		return service.findAll();
	}

	@Override
	public List<ActivityCategory> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<ActivityCategory> findAll(Pageable pageable) {
		Page<ActivityCategory> page= service.findAll(pageable);
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
	public void deleteByObj(ActivityCategory o) {
		service.delete(o);
	}

	@Override
	public ActivityCategory findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<ActivityCategory> findByNameMatch(String name) {
		return service.findByNameMatch(name);
	}

	@Override
	public ActivityCategory findByName(String name) {
		return service.findByName(name);
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<ActivityCategory> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<ActivityCategory> findByIds(Iterable<Integer> ids) {
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
