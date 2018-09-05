package com.goebuy.biz.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.event.Tip;
import com.goebuy.service.event.TipService;

@Service
public class TipBiz extends AbstractBiz<Tip, Integer>{

	@Autowired
	private TipService service;
	
	
	@Override
	public Tip save(Tip addObj) {
		return service.save(addObj);
	}

	@Override
	public Tip saveAndFlush(Tip addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<Tip> save(Iterable<Tip> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<Tip> findAll() {
		return service.findAll();
	}

	@Override
	public List<Tip> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<Tip> findAll(Pageable pageable) {
		Page<Tip> page= service.findAll(pageable);
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
	public void deleteByObj(Tip o) {
		service.delete(o);
	}

	@Override
	public Tip findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<Tip> findByNameMatch(String name) {
		return service.findByNameMatch(name);
	}

	@Override
	public Tip findByName(String name) {
		return service.findByName(name);
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<Tip> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<Tip> findByIds(Iterable<Integer> ids) {
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
