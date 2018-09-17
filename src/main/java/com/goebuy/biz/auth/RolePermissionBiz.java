package com.goebuy.biz.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.biz.AbstractBiz;
import com.goebuy.entity.auth.Permission;
import com.goebuy.entity.auth.Role;
import com.goebuy.entity.auth.RolePermission;
import com.goebuy.service.auth.RolePermissionService;


@Service
public class RolePermissionBiz extends AbstractBiz<RolePermission, Integer>{
	
	@Autowired
	private RolePermissionService service;

	
	public void addPermissionToRole(Permission permission , Role role) {
		service.addRolePermission(role.getId(), permission.getId() );
	}
	
	public void addPermissionToRole(int permissionId , int roleId) {
		service.addRolePermission(roleId, permissionId );
	}
	
	public void addPermissionToRole(Role role, Iterable<Permission> permissions  ) {
		if(permissions!= null) {
			for(Permission p : permissions) {
				service.addRolePermission(role.getId(), p.getId() );
			}
		}
	}
	
	public List<RolePermission> findAll(){
		return service.findAll();
	}

	@Override
	public RolePermission save(RolePermission addObj) {
		return service.save(addObj);
	}

	@Override
	public RolePermission saveAndFlush(RolePermission addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<RolePermission> save(Iterable<RolePermission> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<RolePermission> findAll(Sort sort) {
		return service.findAll();
	}

	@Override
	public List<RolePermission> findAll(Pageable pageable) {
		Page<RolePermission> page = service.findAll(pageable);
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
	public void deleteByObj(RolePermission o) {
		service.delete(o);
	}

	@Override
	public RolePermission findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<RolePermission> findByNameMatch(String name) {
//		return service.findByN;
		return null;
	}

	@Override
	public RolePermission findByName(String name) {
		return null;
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<RolePermission> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<RolePermission> findByIds(Iterable<Integer> ids) {
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
