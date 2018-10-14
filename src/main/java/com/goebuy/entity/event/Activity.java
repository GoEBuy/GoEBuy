package com.goebuy.entity.event;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
 * 活动类
 * @author Administrator
 * indexes={@Index(name="name_Index", columnList="nickname")}
 */
@Entity
@Table(name = "activity", indexes={@Index(name="index_merchant", columnList="merchant_id"), @Index(name="index_name", columnList="name")} ,  schema = "springdemo",  catalog = "")
@ApiModel(description = "活动表")
public class Activity extends BaseActivityEntity<Integer> {

	private static final long serialVersionUID = -2912999476359178126L;

	/** 活动分类id， 唯一 */
	@ApiModelProperty(value = " 活动分类id", example = "null", position = 1)
	private ActivityCategory activityCate;


	/** 报名开始日期 */
	private String enrollStartDate;
	/** 报名开始时间 */
	private String enrollStartTime;
	/** 报名结束日期 */
	private String enrollEndDate;
	/** 报名结束时间 */
	private String enrollEndTime;


	/** 活动地点类型：0 线下，1 自定义 */
	private int locationType;
	/** 活动地点 */
	private String location;


	/** 活动海报 */
	private String poster;


	/** 展示报名类型: 0 展示报名用户影响力排行榜，1 展示报名用户，不显示报名用户 */
	private int enrollShowType;


	/** 报名后跳转页面类型：0 邀请函页面，1 自定义页面，2 订单详情页面 */
	private int gotoPageType;
	/** 报名后跳转页面 */
	private String gotoPage;


	/**
	 * 售票信息
	 */
	/** 售票类型：0 免费，1 收费（可设置多种票）*/
	private int ticketType;
	/** 报名限制 : 0 不限制， 1 每人限报一次 */
	private int enrollCnt;
	/** 余票显示 */
	private boolean showLeftTicket = true;
	/** 是否需要审核*/
	private boolean needVerify=false;
	/**	仅限会员 */
	private boolean needVip =false;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="activity_category_id")
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
	@Column(name = "location_type", columnDefinition="UNSIGNED TINYINT DEFAULT 0 COMMENT '活动地点类型：0 线下，1 自定义'" )
	public int getLocationType() {
		return locationType;
	}

	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}

	@Basic
	@Column(name = "location", length=120, nullable = true)
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
	@Column(name = "enroll_show_type")
	public int getEnrollShowType() {
		return enrollShowType;
	}

	public void setEnrollShowType(int enrollShowType) {
		this.enrollShowType = enrollShowType;
	}

	@Basic
	@Column(name = "goto_page_type")
	public int getGotoPageType() {
		return gotoPageType;
	}

	public void setGotoPageType(int gotoPageType) {
		this.gotoPageType = gotoPageType;
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
	public int getTicketType() {
		return ticketType;
	}

	public void setTicketType(int ticket_type) {
		this.ticketType = ticket_type;
	}
	@Basic
	@Column(name = "enroll_cnt", nullable = true)
	public int getEnrollCnt() {
		return enrollCnt;
	}

	public void setEnrollCnt(int enroll_type) {
		this.enrollCnt = enroll_type;
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
	
	public Activity() {
		
	}
	
	public Activity(String name, String create_time) {
		this.name = name;
		this.createTime = create_time;
	}

}
