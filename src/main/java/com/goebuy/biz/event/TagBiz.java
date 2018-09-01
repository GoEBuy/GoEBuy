package com.goebuy.biz.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.event.Tag;
import com.goebuy.service.event.TagService;

@Service
public class TagBiz extends AbstractBiz<Tag, Integer>{

	@Autowired
	private TagService service;
	
	
	@Override
	public Tag save(Tag addObj) {
		return service.save(addObj);
	}

	@Override
	public Tag saveAndFlush(Tag addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<Tag> save(Iterable<Tag> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<Tag> findAll() {
		return service.findAll();
	}

	@Override
	public List<Tag> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<Tag> findAll(Pageable pageable) {
		Page<Tag> page= service.findAll(pageable);
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
	public void deleteByObj(Tag o) {
		service.delete(o);
	}

	@Override
	public Tag findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<Tag> findByNameMatch(String name) {
		return service.findByNameMatch(name);
	}

	@Override
	public Tag findByName(String name) {
		return service.findByName(name);
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<Tag> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<Tag> findByIds(Iterable<Integer> ids) {
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
