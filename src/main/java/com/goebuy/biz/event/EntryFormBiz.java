package com.goebuy.biz.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.event.EntryForm;
import com.goebuy.service.event.EntryFormService;

@Service
public class EntryFormBiz extends AbstractBiz<EntryForm, Integer>{

	@Autowired
	private EntryFormService service;
	
	
	@Override
	public EntryForm save(EntryForm addObj) {
		return service.save(addObj);
	}

	@Override
	public EntryForm saveAndFlush(EntryForm addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<EntryForm> save(Iterable<EntryForm> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<EntryForm> findAll() {
		return service.findAll();
	}

	@Override
	public List<EntryForm> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<EntryForm> findAll(Pageable pageable) {
		Page<EntryForm> page= service.findAll(pageable);
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
	public void deleteByObj(EntryForm o) {
		service.delete(o);
	}

	@Override
	public EntryForm findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<EntryForm> findByNameMatch(String name) {
		return service.findByNameMatch(name);
	}

	@Override
	public EntryForm findByName(String name) {
		return service.findByName(name);
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<EntryForm> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<EntryForm> findByIds(Iterable<Integer> ids) {
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
