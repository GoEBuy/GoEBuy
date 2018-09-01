package com.goebuy.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.goebuy.entity.user.Merchant;

/**
 * 用戶系統通知信息
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "user_sysinfo", indexes={@Index(name="index_merchant_id", columnList="merchant_id"),@Index(name="index_has_read", columnList="has_read")} , schema = "springdemo", catalog = "")
public class UserSysInfoEntity extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4333026409014680730L;

	private Merchant user;

	private SystemInfo sysInfo;

	private boolean hasRead;

	/**
	 * 最近一次讀取時間
	 */
	private String time;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL} )
	@JoinColumn(name="merchant_id", nullable=false)
	public Merchant getUser() {
		return user;
	}

	public void setUser(Merchant user) {
		this.user = user;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="sys_info_id", nullable=false)
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
