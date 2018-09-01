package com.goebuy.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.goebuy.entity.user.User;

/**
 * 用戶系統通知信息
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "user_sysinfo", indexes={@Index(name="user_id_Index", columnList="user_id")} , schema = "springdemo", catalog = "")
public class UserSysInfoEntity extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4333026409014680730L;

	private User user;

	private SystemInfo sysInfo;

	private boolean hasRead;

	/**
	 * 最近一次讀取時間
	 */
	private String time;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public SystemInfo getSysInfo() {
		return sysInfo;
	}
	
	public void setSysInfo(SystemInfo sysInfo) {
		this.sysInfo = sysInfo;
	}

	@Basic
	@Column(name = "has_read", nullable = true)
	public boolean isHasRead() {
		return hasRead;
	}

	public void setHasRead(boolean hasRead) {
		this.hasRead = hasRead;
	}

	@Basic
	@Column(name = "time", nullable = true, length = 20)
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
