package com.goebuy.biz;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.goebuy.entity.SystemLog;
import com.goebuy.service.SysLogService;

@Service
public class SystemLogBiz extends AbstractBiz<SystemLog, Integer>{
	
	@Autowired
	private SysLogService service;
	
	public List<SystemLog>  findByNameMatch(String name) {
		return null;
//		List<SystemLog> pList = service.findByNameMatch(name);
//		return pList;
	}
	
	public SystemLog  findByName(String name) {
		return null;
	}
//	
//	public List<SystemLog>  findByDescMatch(String desc) {
//		List<SystemLog> pList = service.findByDescMatch(desc);
//		return pList;
//	}

	@Override
	public SystemLog save(SystemLog addObj) {
		return service.save(addObj);
	}
	
	@Override
	public SystemLog saveAndFlush(SystemLog addObj) {
		return service.saveAndFlush(addObj);
	}
	
	@Override
	public List<SystemLog> save(Iterable<SystemLog> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public void deleteById(Integer id) {
		service.delete(id);
	}

	@Override
	public SystemLog findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<SystemLog> findByIds(Iterable<Integer> ids) {
		return service.findAll(ids);
	}

	@Override
	public void deleteByObj(SystemLog o) {
		service.delete(o);
	}

	@Override
	public void deleteInBatch(Iterable<SystemLog> delObjs) {
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
	public List<SystemLog> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemLog> findAll(Pageable pageable) {
		Page<SystemLog> objs= service.findAll(pageable);
		if(objs!=null) {
			return objs.getContent();
		}else {
			return null;
		}
	}

	@Override
	public List<SystemLog> findAll() {
		return service.findAll();
	}

	@Override
	public boolean exists(int id) {
		return service.exists(id);
	}




	
}
