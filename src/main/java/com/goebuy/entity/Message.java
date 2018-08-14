package com.goebuy.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "message", schema = "springdemo",  catalog = "")
public class Message extends BaseEntity<Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8345501396288538950L;

	
	/**
	 * 创建人
	 */
	private UserEntity user;
	
	/** 发送时间 */
	private String create_time;
	
	/** 目标用户*/
	private String tousers;
	
	private String content;
	
	/** 目标人数 */
	private int to_count;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity userEntity) {
		this.user = userEntity;
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
	@Column(name = "tousers", nullable = false )
	public String getTousers() {
		return tousers;
	}

	public void setTousers(String tousers) {
		this.tousers = tousers;
	}
	@Basic
	@Column(name = "content", nullable = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Basic
	@Column(name = "to_count", nullable = true)
	public int getTo_count() {
		return to_count;
	}

	public void setTo_count(int to_count) {
		this.to_count = to_count;
	}	
	
	
	
	
}
