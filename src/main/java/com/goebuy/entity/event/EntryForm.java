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

	/** 售票类型 */
	private String ticketType;
	
	/** 报名限制 */
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
	@Column(name = "ticket_type", nullable = true)
	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
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
