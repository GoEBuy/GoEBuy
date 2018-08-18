package com.goebuy.biz;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public abstract class AbstractBiz<O, T extends Serializable> {
	
	public abstract O save(O addObj);
	
	public abstract O saveAndFlush(O addObj);
	
	public abstract List<O> save(Iterable<O> addObjs);
	
	public abstract List<O> findAll();
	
	public abstract List<O> findAll(Sort sort);
	
	public abstract List<O> findAll(Pageable pageable);
	
	public abstract void deleteById(T id);
	
	public abstract void deleteByObj(O o);
	
	public abstract O findById(T id);
	
	public abstract List<O> findByNameMatch(String name);
	
	public abstract O findByName(String name);
	
	public abstract void deleteAllInBatch();
	
	public abstract void deleteInBatch(Iterable<O> delObjs);
	
	public abstract List<O> findByIds(Iterable<Integer> ids);
	
	
	public abstract void flush();
	
	public abstract long count();
	
	public abstract boolean exists(int id);
	

}
