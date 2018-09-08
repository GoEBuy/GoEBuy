package com.goebuy.entity.event;

import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.Order;
import com.goebuy.entity.user.User;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户活动表
 * @author Administrator
 */
@Entity
@Table(name = "user_activity", schema = "springdemo", indexes={@Index(name="index_activity_id", columnList="activity_id"),  @Index(name="index_user", columnList="user_id")}, catalog = "")
public class UserActivity extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1144737462440938677L;

	/**活动用户 */
	private User user;
	
	private Activity activity;
	
	/** 审核状态 */
	private String stateVerify;
	
	/** 交易状态 */
	private int exchangeState;
	
	/** 报名活动渠道 */
	private String channel;

	/** 活动售票类型 */
	private int ticketType;
	
	 /** 生成订单 */
    private Order order;

//	/** 序列号 */
//	private String seqNo;
	
	/** 签到状态 */
	private String stateSign;
	
//	/** 分销返现*/
//	private double fxfx;
	
	private String createTime;
	

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL,})
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="activity_id")
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
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
	@Column(name = "exchange_state", nullable = true)
	public int getExchangeState() {
		return exchangeState;
	}

	public void setExchangeState(int state_exchange) {
		this.exchangeState = state_exchange;
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
	public int getTicketType() {
		return ticketType;
	}

	public void setTicketType(int ticket_type) {
		this.ticketType = ticket_type;
	}
//	@Basic
//	@Column(name = "price", nullable = true)
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
//	@Basic
//	@Column(name = "seq_no", 	unique=true,  nullable = true)
//	public String getSeqNo() {
//		return seqNo;
//	}
//
//	public void setSeqNo(String seqNo) {
//		this.seqNo = seqNo;
//	}
	@Basic
	@Column(name = "state_sign", nullable = true)
	public String getStateSign() {
		return stateSign;
	}

	public void setStateSign(String stateSign) {
		this.stateSign = stateSign;
	}

	@Basic
	@Column(name = "create_time", nullable = false)
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
