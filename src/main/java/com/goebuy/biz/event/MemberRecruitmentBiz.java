package com.goebuy.biz.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.event.MemberRecruitment;
import com.goebuy.service.event.MemberRecruitmentService;

@Service
public class MemberRecruitmentBiz extends AbstractBiz<MemberRecruitment, Integer>{

	@Autowired
	private MemberRecruitmentService service;
	
	
	@Override
	public MemberRecruitment save(MemberRecruitment addObj) {
		return service.save(addObj);
	}

	@Override
	public MemberRecruitment saveAndFlush(MemberRecruitment addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<MemberRecruitment> save(Iterable<MemberRecruitment> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<MemberRecruitment> findAll() {
		return service.findAll();
	}

	@Override
	public List<MemberRecruitment> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<MemberRecruitment> findAll(Pageable pageable) {
		Page<MemberRecruitment> page= service.findAll(pageable);
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
	public void deleteByObj(MemberRecruitment o) {
		service.delete(o);
	}

	@Override
	public MemberRecruitment findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<MemberRecruitment> findByNameMatch(String name) {
		return service.findByNameMatch(name);
	}

	@Override
	public MemberRecruitment findByName(String name) {
		return service.findByName(name);
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<MemberRecruitment> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<MemberRecruitment> findByIds(Iterable<Integer> ids) {
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
