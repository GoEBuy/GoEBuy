package com.goebuy.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 标签库类
 * @author Administrator
 */
@Entity
@Table(name = "tag", indexes={@Index(name="name_Index", columnList="nickname")}, schema = "springdemo",  catalog = "")
public class Tag extends BaseEntity<Integer>{
	
	/**标签名称 */
	private String name; 
	
	private UserEntity user;
	
	private String create_time;
	
	/** 是否是通用标签  */
	private boolean isCommon;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	@Basic
	@Column(name = "create_time", nullable = true)
	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	@Basic
	@Column(name = "is_common", nullable = true)
	public boolean isCommon() {
		return isCommon;
	}

	public void setCommon(boolean isCommon) {
		this.isCommon = isCommon;
	}
	
	
	
	
}
