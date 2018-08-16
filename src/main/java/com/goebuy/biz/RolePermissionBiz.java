package com.goebuy.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goebuy.entity.auth.Permission;
import com.goebuy.entity.auth.Role;
import com.goebuy.entity.auth.RolePermission;
import com.goebuy.service.RolePermissionService;


@Service
public class RolePermissionBiz {
	
	@Autowired
	private RolePermissionService rolePermissionService;

	
	public void addPermissionToRole(Permission permission , Role role) {
		rolePermissionService.addRolePermission(role.getId(), permission.getId() );
	}
	
	public void addPermissionToRole(int permissionId , int roleId) {
		rolePermissionService.addRolePermission(roleId, permissionId );
	}
	
	public void addPermissionToRole(Iterable<Permission> permissions , Role role) {
		for(Permission p : permissions) {
			rolePermissionService.addRolePermission(role.getId(), p.getId() );
		}
	}
	
	public List<RolePermission> findAll(){
		return rolePermissionService.findAll();
	}
	
	
	
}
