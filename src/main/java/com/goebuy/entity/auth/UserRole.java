package com.goebuy.entity.auth;

import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户-角色  多对多
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "auth_user_role", indexes={@Index(name="user_id_Index", columnList="user_id")} , schema = "springdemo", catalog = "")
public class UserRole extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4333026409014680730L;

	private User user;

	private Role role;


	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}


}
