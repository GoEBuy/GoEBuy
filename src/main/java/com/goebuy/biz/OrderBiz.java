package com.goebuy.biz;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.goebuy.entity.Order;
import com.goebuy.service.OrderService;

@Service
public class OrderBiz extends AbstractBiz<Order, Integer>{
	
	@Autowired
	private OrderService service;
	
	public List<Order>  findByNameMatch(String name) {
		return null;
//		List<Order> pList = service.findByNameMatch(name);
//		return pList;
	}
	
	public Order  findByName(String name) {
		return null;
	}
//	
//	public List<Order>  findByDescMatch(String desc) {
//		List<Order> pList = service.findByDescMatch(desc);
//		return pList;
//	}

	@Override
	public Order save(Order addObj) {
		return service.save(addObj);
	}
	
	@Override
	public Order saveAndFlush(Order addObj) {
		return service.saveAndFlush(addObj);
	}
	
	@Override
	public List<Order> save(Iterable<Order> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public void deleteById(Integer id) {
		service.delete(id);
	}

	@Override
	public Order findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<Order> findByIds(Iterable<Integer> ids) {
		return service.findAll(ids);
	}

	@Override
	public void deleteByObj(Order o) {
		service.delete(o);
	}

	@Override
	public void deleteInBatch(Iterable<Order> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public void flush() {
		service.flush();
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public long count() {
		return service.count();
	}

	@Override
	public List<Order> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAll(Pageable pageable) {
		Page<Order> objs= service.findAll(pageable);
		if(objs!=null) {
			return objs.getContent();
		}else {
			return null;
		}
	}

	@Override
	public List<Order> findAll() {
		return service.findAll();
	}

	@Override
	public boolean exists(int id) {
		return service.exists(id);
	}




	
}
