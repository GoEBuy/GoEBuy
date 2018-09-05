package com.goebuy.entity.auth;

import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.user.Merchant;
import com.goebuy.entity.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户-角色  多对多
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "auth_user_role", indexes={@Index(name="index_merchant_id", columnList="merchant_id"), @Index(name="index_role", columnList="role_id")} , schema = "springdemo", catalog = "")
public class UserRole extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4333026409014680730L;

	private Merchant user;

	private Role role;


	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="merchant_id", nullable=false)
	public Merchant getUser() {
		return user;
	}

	public void setUser(Merchant user) {
		this.user = user;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="role_id", nullable=false)
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	
	public UserRole(Merchant user , Role role) {
		this.user= user;
		this.role = role;
	}

}
