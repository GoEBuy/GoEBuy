package com.goebuy.biz.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.user.Merchant;
import com.goebuy.service.user.MerchantService;

@Service
public class MerchantBiz extends AbstractBiz<Merchant, Integer>{

	@Autowired
	private MerchantService service;
	

	@Override
	public List<Merchant> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<Merchant> findAll(Pageable pageable) {
		Page<Merchant> page= service.findAll(pageable);
		if(page!=null) return page.getContent();
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		service.delete(id);
	}

	@Override
	public void deleteByObj(Merchant o) {
		service.delete(o);
	}

	@Override
	public Merchant findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<Merchant> findByNameMatch(String name) {
		return service.findByNameMatch(name);
	}

	@Override
	public Merchant findByName(String name) {
		return service.findByName(name);
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<Merchant> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<Merchant> findByIds(Iterable<Integer> ids) {
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
	public Merchant save(Merchant addObj) {
		return service.save(addObj);
	}

	@Override
	public Merchant saveAndFlush(Merchant addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<Merchant> save(Iterable<Merchant> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<Merchant> findAll() {
		return service.findAll();
	}
	
	public Merchant loginByEmail(String email, String password) {
		return service.loginByEmail(email, password);
	}
	
	public Merchant loginByPhone(String phone, String password) {
		return service.loginByPhone(phone, password);
	}
	

}
