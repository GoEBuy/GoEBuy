package com.goebuy.entity.auth;

import com.goebuy.entity.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "auth_permission", schema = "springdemo", catalog = "")
public class Permission extends BaseEntity<Integer> {

	private static final long serialVersionUID = -5860846395796220265L;

	private String permission;
	
	private String desc;

	public Permission() {
		super();
	}
	public Permission(String permission) {
		super();
		this.permission = permission;
	}

	@Basic
	@Column(name = "permission", nullable = false, length = 45)
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	@Basic
	@Column(name = "description", nullable = true, length = 45)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	  @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Permission that = (Permission) o;

	        if (id != that.id) return false;
	        if (permission != null ? !permission.equals(that.permission) : that.permission != null) return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int result = id;
	        result = 31 * result + (permission != null ? permission.hashCode() : 0);
	        return result;
	    }
	
	
	public static void main(String[] args) {
		Permission p1 = new Permission("p1");
		p1.setDesc("p1");
		System.out.println("p1:"+p1);
		Permission p2 = new Permission("p1");
		p2.setDesc("p2");
		System.out.println("p2:"+p2);
		Permission p3 = new Permission("p2");
		p3.setDesc("p1");
		System.out.println("p3:"+p3);
		Permission p4 = new Permission("p2");
		p3.setDesc("p1");
		System.out.println("p4:"+p4);
		
//		p1:{"desc":"p1","permission":"p1"}
//		p2:{"desc":"p2","permission":"p1"}
//		p3:{"desc":"p1","permission":"p2"}
//		p4:{"permission":"p2"}
		
		System.out.println(p1.equals(p2));//true
		System.out.println(p1.equals(p3));//false
		System.out.println(p1.equals(p4));//false

		System.out.println(p2.equals(p3));//false
		System.out.println(p3.equals(p4));//true
		
		System.out.println(p3.equals(p4));//true
		
		
		
	}
	
	
	
}
