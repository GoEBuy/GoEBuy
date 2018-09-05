package com.goebuy.biz.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.event.Message;
import com.goebuy.service.event.MessageService;

@Service
public class MessageBiz extends AbstractBiz<Message, Integer>{

	@Autowired
	private MessageService service;
	
	
	@Override
	public Message save(Message addObj) {
		return service.save(addObj);
	}

	@Override
	public Message saveAndFlush(Message addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<Message> save(Iterable<Message> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<Message> findAll() {
		return service.findAll();
	}

	@Override
	public List<Message> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<Message> findAll(Pageable pageable) {
		Page<Message> page= service.findAll(pageable);
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
	public void deleteByObj(Message o) {
		service.delete(o);
	}

	@Override
	public Message findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<Message> findByNameMatch(String name) {
		return null;
//		return service.findByNameMatch(name);
	}

	@Override
	public Message findByName(String name) {
		return null;
//		return service.findByName(name);
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<Message> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<Message> findByIds(Iterable<Integer> ids) {
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
