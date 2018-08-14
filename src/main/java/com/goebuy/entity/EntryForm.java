package com.goebuy.entity;

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
@Table(name = "entryform",indexes={@Index(name="index_name", columnList="name")},  schema = "springdemo",  catalog = "")
public class EntryForm extends BaseActivityEntity<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9010868247836235386L;

	/** 售票类型 */
	private String ticket_type;
	
	/** 报名限制 */
	private String enroll_type;
	
	/**余票显示 */
	private boolean show_leftticket;
	
	/**人数限制 默认不限制 -1*/
	private int maxCnt=-1;
	
	/**是否需要审核*/
	private boolean need_verify=false;
	
	/**	仅限会员*/
	private boolean need_vip;

	
	@Basic
	@Column(name = "ticket_type", nullable = true)
	public String getTicket_type() {
		return ticket_type;
	}

	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}
	@Basic
	@Column(name = "enroll_type", nullable = true)
	public String getEnroll_type() {
		return enroll_type;
	}

	public void setEnroll_type(String enroll_type) {
		this.enroll_type = enroll_type;
	}
	@Basic
	@Column(name = "show_leftticket", nullable = true)
	public boolean isShow_leftticket() {
		return show_leftticket;
	}

	public void setShow_leftticket(boolean show_leftticket) {
		this.show_leftticket = show_leftticket;
	}
	@Basic
	@Column(name = "maxCnt", nullable = true)
	public int getMaxCnt() {
		return maxCnt;
	}

	public void setMaxCnt(int maxCnt) {
		this.maxCnt = maxCnt;
	}
	@Basic
	@Column(name = "need_verify", nullable = true)
	public boolean isNeed_verify() {
		return need_verify;
	}

	public void setNeed_verify(boolean need_verify) {
		this.need_verify = need_verify;
	}
	@Basic
	@Column(name = "need_vip", nullable = true)
	public boolean isNeed_vip() {
		return need_vip;
	}

	public void setNeed_vip(boolean need_vip) {
		this.need_vip = need_vip;
	}
	
	
}
