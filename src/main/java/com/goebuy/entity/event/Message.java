package com.goebuy.entity.event;

import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.user.User;

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
public class Message extends BaseEntity<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8345501396288538950L;

	
	/**
	 * 创建人
	 */
	private User user;
	
	/** 发送时间 */
	private String createTime;
	
	/** 目标用户*/
	private String toUsers;
	
	private String content;
	
	/** 目标人数 */
	private int toCount;

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
	@Column(name = "to_users", nullable = false )
	public String getToUsers() {
		return toUsers;
	}

	public void setToUsers(String toUsers) {
		this.toUsers = toUsers;
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
	public int getToCount() {
		return toCount;
	}

	public void setToCount(int toCount) {
		this.toCount = toCount;
	}	
	
	
	
	
}
