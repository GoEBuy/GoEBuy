package com.goebuy.biz.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.event.Question;
import com.goebuy.service.event.QuestionService;

@Service
public class QuestionBiz extends AbstractBiz<Question, Integer>{

	@Autowired
	private QuestionService service;
	
	
	@Override
	public Question save(Question addObj) {
		return service.save(addObj);
	}

	@Override
	public Question saveAndFlush(Question addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<Question> save(Iterable<Question> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<Question> findAll() {
		return service.findAll();
	}

	@Override
	public List<Question> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<Question> findAll(Pageable pageable) {
		Page<Question> page= service.findAll(pageable);
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
	public void deleteByObj(Question o) {
		service.delete(o);
	}

	@Override
	public Question findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<Question> findByNameMatch(String name) {
		return service.findByNameMatch(name);
	}

	@Override
	public Question findByName(String name) {
		return service.findByName(name);
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<Question> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<Question> findByIds(Iterable<Integer> ids) {
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
