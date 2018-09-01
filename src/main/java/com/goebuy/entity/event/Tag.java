package com.goebuy.entity.event;

import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.user.User;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 标签库类, 用户标签与活动标签统一
 * @author Administrator
 */
@Entity
@Table(name = "tag", indexes={@Index(name="name_index", columnList="name")}, schema = "springdemo",  catalog = "")
public class Tag extends BaseEntity<Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -498561889458454959L;

	/**标签名称 */
	private String name; 
	/** 创建人 */
	private User user;
	
	private String createTime;
	
	/** 是否是通用标签 , 默认为否 */
	private boolean isCommon = false;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Basic
	@Column(name = "create_time", nullable = true)
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
