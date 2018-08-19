package com.goebuy.entity.event;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 活动类
 * @author Administrator
 * indexes={@Index(name="name_Index", columnList="nickname")}
 */
@Entity
@Table(name = "activity", schema = "springdemo",  catalog = "")
public class Activity extends BaseActivityEntity<Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2912999476359178126L;

	/**活动分类id， 唯一  */
	private ActivityCategory activityCate;
	
	/** 报名开始日期 */
	private String enrollStartDate;
	
	private String enrollEndDate;
	
	/** 报名开始时间 */
	private String enrollStartTime;
	
	private String enrollEndTime;
	
	/** 活动地点*/
	private String location;

	/** 活动海报 */
	private String poster;
	
	/**是否展示报名用户 */
	private boolean isShow;

	/**报名后跳转页面 */
	private String gotoPage;
	
	
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
	private boolean needVip;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="ActivityCategory_id")
	public ActivityCategory getActivityCate() {
		return activityCate;
	}

	public void setActivityCate(ActivityCategory activityCate) {
		this.activityCate = activityCate;
	}

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
	@Column(name = "location", nullable = true)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	@Basic
	@Column(name = "poster", nullable = true)
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	@Basic
	@Column(name = "is_show", nullable = true)
	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	@Basic
	@Column(name = "goto_page", nullable = true)
	public String getGotoPage() {
		return gotoPage;
	}

	public void setGotoPage(String gotopage) {
		this.gotoPage = gotopage;
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
	@Column(name = "enroll_type", nullable = true)
	public String getEnrollType() {
		return enrollType;
	}

	public void setEnrollType(String enroll_type) {
		this.enrollType = enroll_type;
	}
	@Basic
	@Column(name = "show_left_ticket", nullable = true)
	public boolean isShowLeftTicket() {
		return showLeftTicket;
	}

	public void setShowLeftTicket(boolean show_leftticket) {
		this.showLeftTicket = show_leftticket;
	}
	
	@Basic
	@Column(name = "max_cnt", columnDefinition="tinyint default -1", nullable = true)
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

	public void setNeedVerify(boolean need_verify) {
		this.needVerify = need_verify;
	}
	@Basic
	@Column(name = "need_vip", nullable = true)
	public boolean isNeedVip() {
		return needVip;
	}

	public void setNeedVip(boolean need_vip) {
		this.needVip = need_vip;
	}
	
	
	
	
}
