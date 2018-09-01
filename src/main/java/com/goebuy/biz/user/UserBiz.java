package com.goebuy.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.user.User;
import com.goebuy.service.user.UserService;

@Service
public class UserBiz extends AbstractBiz<User, Integer>{

	@Autowired
	private UserService service;
	

	@Override
	public List<User> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<User> findAll(Pageable pageable) {
		Page<User> page= service.findAll(pageable);
		if(page!=null) return page.getContent();
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		service.delete(id);
	}

	@Override
	public void deleteByObj(User o) {
		service.delete(o);
	}

	@Override
	public User findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<User> findByNameMatch(String name) {
		return service.findByNameMatch(name);
	}

	@Override
	public User findByName(String name) {
		return service.findByName(name);
	}

	public User findByNickName(String nickname) {
		return service.findByNickName(nickname);
	}
	
	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<User> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<User> findByIds(Iterable<Integer> ids) {
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

	@Override
	public User save(User addObj) {
		return service.save(addObj);
	}

	@Override
	public User saveAndFlush(User addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<User> save(Iterable<User> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<User> findAll() {
		return service.findAll();
	}


}
