package com.goebuy.biz.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.event.UserQuestion;
import com.goebuy.service.event.UserQuestionService;

@Service
public class UserQuestionBiz extends AbstractBiz<UserQuestion, Integer>{

	@Autowired
	private UserQuestionService service;
	
	
	@Override
	public UserQuestion save(UserQuestion addObj) {
		return service.save(addObj);
	}

	@Override
	public UserQuestion saveAndFlush(UserQuestion addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<UserQuestion> save(Iterable<UserQuestion> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<UserQuestion> findAll() {
		return service.findAll();
	}

	@Override
	public List<UserQuestion> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<UserQuestion> findAll(Pageable pageable) {
		Page<UserQuestion> page= service.findAll(pageable);
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
	public void deleteByObj(UserQuestion o) {
		service.delete(o);
	}

	@Override
	public UserQuestion findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<UserQuestion> findByNameMatch(String name) {
//		return service.findByNameMatch(name);
		return null;
	}

	@Override
	public UserQuestion findByName(String name) {
//		return service.findByName(name);
		return null;
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<UserQuestion> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<UserQuestion> findByIds(Iterable<Integer> ids) {
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
