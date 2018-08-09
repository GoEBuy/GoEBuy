package com.goebuy.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户打赏表
 * @author Administrator
 *
 */
@Entity
@Table(name = "user_tip", schema = "springdemo",  catalog = "")
public class UserTip extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8685619633799829922L;

	private UserEntity user;
	
	private Tip tip;
	
	/** 用户打赏金额*/
	private double userfee;
	
	/** 打赏渠道*/
	private String channel;
	
	/** 打赏时间 */
	private String pay_time;
	
	/** 打赏评论*/
	private String remark;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Tip getTip() {
		return tip;
	}
	public void setTip(Tip tip) {
		this.tip = tip;
	}
	
	@Basic
	@Column(name = "userfee", nullable = true)
	public double getUserfee() {
		return userfee;
	}
	public void setUserfee(double userfee) {
		this.userfee = userfee;
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
	@Column(name = "pay_time", nullable = true)
	public String getPay_time() {
		return pay_time;
	}
	public void setPay_time(String pay_time) {
		this.pay_time = pay_time;
	}
	
	@Basic
	@Column(name = "remark", length=200, nullable = true)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
