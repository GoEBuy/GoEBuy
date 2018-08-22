package com.goebuy.entity.event;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 报名表
 * @author Administrator
 *
 */
@Entity
@Table(name = "entry_form",indexes={@Index(name="index_name", columnList="name")},  schema = "springdemo",  catalog = "")
public class EntryForm extends BaseActivityEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9010868247836235386L;

	/** 售票类型 : 免费，收费 */
	private int ticketType;
	
	/** 报名开始日期 */
	private String enrollStartDate;
	
	private String enrollEndDate;
	
	/** 报名开始时间 */
	private String enrollStartTime;
	
	private String enrollEndTime;
	
	/** 报名限制 : 不限制， 没人限报一次 */
	private String enrollType;
	
	
	
	/**余票显示 */
	private boolean showLeftTicket;
	
	/**人数限制 默认不限制 -1*/
	private int maxCnt=-1;
	
	/**是否需要审核*/
	private boolean needVerify=false;
	
	/**	仅限会员*/
	private boolean needVip=false;

	
	
	@Basic
	@Column(name = "enroll_start_date", nullable = true)
	public String getEnrollStartDate() {
		return enrollStartDate;
	}

	public void setEnrollStartDate(String enroll_start_date) {
		this.enrollStartDate = enroll_start_date;
	}
	@Basic
	@Column(name = "enroll_end_date", nullable = true)
	public String getEnrollEndDate() {
		return enrollEndDate;
	}

	public void setEnrollEndDate(String enroll_end_date) {
		this.enrollEndDate = enroll_end_date;
	}
	@Basic
	@Column(name = "enroll_start_time", nullable = true)
	public String getEnrollStartTime() {
		return enrollStartTime;
	}

	public void setEnrollStartTime(String enroll_start_time) {
		this.enrollStartTime = enroll_start_time;
	}
	
	@Basic
	@Column(name = "enroll_end_time", nullable = true)
	public String getEnrollEndTime() {
		return enrollEndTime;
	}

	public void setEnrollEndTime(String enroll_end_time) {
		this.enrollEndTime = enroll_end_time;
	}
	
	@Basic
	@Column(name = "ticket_type", nullable = true)
	public int getTicketType() {
		return ticketType;
	}

	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	@Basic
	@Column(name = "enroll_type", nullable = true)
	public String getEnrollType() {
		return enrollType;
	}

	public void setEnrollType(String enrollType) {
		this.enrollType = enrollType;
	}
	@Basic
	@Column(name = "show_left_ticket", nullable = true)
	public boolean isShowLeftTicket() {
		return showLeftTicket;
	}

	public void setShowLeftTicket(boolean showLeftTicket) {
		this.showLeftTicket = showLeftTicket;
	}
	@Basic
	@Column(name = "max_cnt", nullable = true)
	public int getMaxCnt() {
		return maxCnt;
	}

	public void setMaxCnt(int maxCnt) {
		this.maxCnt = maxCnt;
	}
	@Basic
	@Column(name = "need_verify", nullable = true)
	public boolean isNeedVerify() {
		return needVerify;
	}

	public void setNeedVerify(boolean needVerify) {
		this.needVerify = needVerify;
	}
	@Basic
	@Column(name = "need_vip", nullable = true)
	public boolean isNeedVip() {
		return needVip;
	}

	public void setNeedVip(boolean needVip) {
		this.needVip = needVip;
	}
	
	
}
