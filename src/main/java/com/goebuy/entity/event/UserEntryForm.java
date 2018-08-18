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
 * 用户报名表
 * @author Administrator
 */
@Entity
@Table(name = "user_entryform", schema = "springdemo",  catalog = "")
public class UserEntryForm extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1144737462440938677L;

	
	private User user;
	
	private EntryForm entryForm;
	
	/** 审核状态 */
	private String state_verify;
	
	/** 交易状态 */
	private String state_exchange;
	
	/**报名渠道 */
	private String channel;

	/** 售票类型 */
	private String ticket_type;
	
	/** 金额 */
	private double price;
	/** 序列号 */
	private String seqno;
	
	/** 签到状态 */
	private String state_sign;

	
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL,})
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public EntryForm getEntryForm() {
		return entryForm;
	}

	public void setEntryForm(EntryForm entryForm) {
		this.entryForm = entryForm;
	}
	
	@Basic
	@Column(name = "state_verify", nullable = true)
	public String getState_verify() {
		return state_verify;
	}

	public void setState_verify(String state_verify) {
		this.state_verify = state_verify;
	}

	@Basic
	@Column(name = "state_exchange", nullable = true)
	public String getState_exchange() {
		return state_exchange;
	}

	public void setState_exchange(String state_exchange) {
		this.state_exchange = state_exchange;
	}
	@Basic
	@Column(name = "channel", nullable = true)
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	@Basic
	@Column(name = "ticket_type", nullable = true)
	public String getTicket_type() {
		return ticket_type;
	}

	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}
	@Basic
	@Column(name = "price", nullable = true)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Basic
	@Column(name = "seqno", nullable = true)
	public String getSeqno() {
//		unique=true, 
		return seqno;
	}

	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	@Basic
	@Column(name = "state_sign", nullable = true)
	public String getState_sign() {
		return state_sign;
	}

	public void setState_sign(String state_sign) {
		this.state_sign = state_sign;
	}
	
	
	
	
	
}
