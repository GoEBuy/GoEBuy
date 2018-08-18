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
@Table(name = "user_entry_form", schema = "springdemo",  catalog = "")
public class UserEntryForm extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1144737462440938677L;

	
	private User user;
	
	private EntryForm entryForm;
	
	/** 审核状态 */
	private String stateVerify;
	
	/** 交易状态 */
	private String stateExchange;
	
	/**报名渠道 */
	private String channel;

	/** 售票类型 */
	private String ticketType;
	
	/** 金额 */
	private double price;
	/** 序列号 */
	private String seqNo;
	
	/** 签到状态 */
	private String stateSign;

	
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
	public String getStateVerify() {
		return stateVerify;
	}

	public void setStateVerify(String state_verify) {
		this.stateVerify = state_verify;
	}

	@Basic
	@Column(name = "state_exchange", nullable = true)
	public String getStateExchange() {
		return stateExchange;
	}

	public void setStateExchange(String state_exchange) {
		this.stateExchange = state_exchange;
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
	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticket_type) {
		this.ticketType = ticket_type;
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
	@Column(name = "seq_no", 	unique=true,  nullable = true)
	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	@Basic
	@Column(name = "state_sign", nullable = true)
	public String getStateSign() {
		return stateSign;
	}

	public void setStateSign(String stateSign) {
		this.stateSign = stateSign;
	}
	
	
	
	
	
}
