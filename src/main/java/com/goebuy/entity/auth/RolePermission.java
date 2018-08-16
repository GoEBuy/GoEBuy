package com.goebuy.entity.auth;

import com.goebuy.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 角色权限表
 * @author Administrator
 *
 */
@Entity
@Table(name = "auth_rolepermission", schema = "springdemo", catalog = "")
public class RolePermission extends BaseEntity<Integer> {

	/**
	 * 	
	 */
	private static final long serialVersionUID = -6432523097687057907L;
	
	private Role role;
	private Permission permission;
	
	
	public RolePermission(Role role) {
		super();
		this.role = role;
	}
	
	public RolePermission(Role role, Permission permission) {
		super();
		this.role = role;
		this.permission = permission;
	}


	@OneToOne(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
//	https://www.cnblogs.com/xiluhua/p/4386045.html
	
	 //@JoinTable(name = "auth_permission", 
	 //joinColumns = { @JoinColumn(name = "CAT_ID") },
	 // inverseJoinColumns = { @JoinColumn(name = "HOBBY_ID") })
	@OneToOne(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
	
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        RolePermission that = (RolePermission) o;

	        if (id != that.id) return false;
	        if (role != null ? !role.equals(that.role) : that.role != null) return false;
	        if (permission != null ? !permission.equals(that.permission) : that.permission != null) return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int result = id;
	        result = 31 * result + (role != null ? role.hashCode() : 0);
	        result = 31 * result + (permission != null ? permission.hashCode() : 0);
	        return result;
	    }
	
	
}
