package com.goebuy.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.goebuy.entity.auth.Role;
import com.goebuy.service.RoleService;

@Service
public class RoleBiz extends AbstractBiz<Role, Integer>{
	
	@Autowired
	private RoleService service;

	public void addRole(String roleName, String roleDesc) {
		Role role = new Role(roleName);
		if(roleDesc!=null && !roleDesc.isEmpty() ) {
			role.setDescription(roleDesc);
		}
		service.save(role);
	}
	
	public void updateRole(int id, String roleName, String roleDesc) {
		service.updateRole(roleName, roleDesc, id);
	}
	
	public void deleteRole(int id) {
		service.delete(id);
	}
	
	public List<Role>  findRoleByRoleNameMatch(String roleName) {
		List<Role> roleList = service.findByRoleNameMatch(roleName);
		return roleList;
	}
	
	public Role  findRoleByRoleName(String roleName) {
		Role role = service.findByRoleName(roleName);
		return role;
	}

	@Override
	public Role save(Role addObj) {
		return service.save(addObj);
	}

	@Override
	public Role saveAndFlush(Role addObj) {
		return service.saveAndFlush(addObj);
	}

	@Override
	public List<Role> save(Iterable<Role> addObjs) {
		return service.save(addObjs);
	}

	@Override
	public List<Role> findAll(Sort sort) {
		return service.findAll(sort);
	}

	@Override
	public List<Role> findAll(Pageable pageable) {
		Page<Role> page = service.findAll(pageable);
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
	public void deleteByObj(Role o) {
		service.delete(o);
	}

	@Override
	public Role findById(Integer id) {
		return service.findOne(id);
	}

	@Override
	public List<Role> findByNameMatch(String name) {
		return service.findByRoleNameMatch(name);
	}

	@Override
	public Role findByName(String name) {
		return service.findByRoleName(name);
	}

	@Override
	public void deleteAllInBatch() {
		service.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<Role> delObjs) {
		service.deleteInBatch(delObjs);
	}

	@Override
	public List<Role> findByIds(Iterable<Integer> ids) {
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
	public List<Role> findAll() {
		return service.findAll();
	}

	
	
	
	
	
}
