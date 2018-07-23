package com.goebuy.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;

/**
 * 用戶系統通知信息
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "user_sysinfo", schema = "springdemo", catalog = "")
public class UserSysInfoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4333026409014680730L;

	private int id;

	private UserEntity user;

	private SystemInfoEntity sysInfo;

	private boolean hasRead;

	/**
	 * 最近一次讀取時間
	 */
	private String time;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public SystemInfoEntity getSysInfo() {
		return sysInfo;
	}
	
	public void setSysInfo(SystemInfoEntity sysInfo) {
		this.sysInfo = sysInfo;
	}

	@Basic
	@Column(name = "hasRead", nullable = true)
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

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
