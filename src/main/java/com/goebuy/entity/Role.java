package com.goebuy.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "auth_role", schema = "springdemo", catalog = "")
public class Role extends BaseEntity<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6432523097687057907L;
	
	private String role;
	private String description;
	
	public Role() {
		super();
	}
	
	public Role(String role) {
		super();
		this.role = role;
	}
	
	public Role(String role, String desc) {
		super();
		this.role = role;
		this.description = desc;
	}

	@Basic
	@Column(name = "role", unique=true, nullable = false, length = 45)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Basic
	@Column(name = "description", nullable = true, length = 45)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Role that = (Role) o;

	        if (id != that.id) return false;
	        if (role != null ? !role.equals(that.role) : that.role != null) return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int result = id;
	        result = 31 * result + (role != null ? role.hashCode() : 0);
	        return result;
	    }
	
	
}
