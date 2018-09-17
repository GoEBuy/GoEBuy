package com.goebuy.entity.event;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.Order;
import com.goebuy.entity.user.User;

/**
 * 用户打赏表
 * @author Administrator
 *
 */
@Entity
@Table(name = "user_tip", indexes={@Index(name="index_user", columnList="user_id")}, schema = "springdemo",  catalog = "")
public class UserTip extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8685619633799829922L;

	/** 打赏用户 */
	private User user;
	
	private Tip tip;
	
//	/** 用户打赏金额*/
//	private double userFee;
	
	 /** 生成订单 */
    private Order order;
	
	/** 打赏渠道*/
	private String channel;
	
	/** 打赏时间 */
	private String payTime;
	
	/** 打赏评论*/
	private String remark;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="tip_id", nullable=false)
	public Tip getTip() {
		return tip;
	}
	public void setTip(Tip tip) {
		this.tip = tip;
	}
	
//	@Basic
//	@Column(name = "user_fee", nullable = true)
//	public double getUserFee() {
//		return userFee;
//	}
//	public void setUserFee(double userFee) {
//		this.userFee = userFee;
//	}
	

	@Basic
	@Column(name = "channel", nullable = true)
	public String getChannel() {
		return channel;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	@Basic
	@Column(name = "pay_time", nullable = true)
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	
	@Basic
	@Column(name = "remark",  nullable = true)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
