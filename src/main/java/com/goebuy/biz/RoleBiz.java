package com.goebuy.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goebuy.entity.Role;
import com.goebuy.service.RoleService;

@Service
public class RoleBiz {
	
	@Autowired
	private RoleService roleService;

	public void addRole(String roleName, String roleDesc) {
		Role role = new Role(roleName);
		if(roleDesc!=null && !roleDesc.isEmpty() ) {
			role.setDescription(roleDesc);
		}
		roleService.save(role);
	}
	
	public void updateRole(int id, String roleName, String roleDesc) {
		roleService.updateRole(roleName, roleDesc, id);
	}
	
	public void deleteRole(int id) {
		roleService.delete(id);
	}
	
	public List<Role>  findRoleByRoleNameMatch(String roleName) {
		List<Role> roleList = roleService.findByRoleNameMatch(roleName);
		return roleList;
	}
	
	public Role  findRoleByRoleName(String roleName) {
		Role role = roleService.findByRoleName(roleName);
		return role;
	}
	
//	public void addRoleToUser(int userId, )
	
	
	
	
	
}
