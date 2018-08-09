package com.goebuy.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 活动类
 * @author Administrator
 * indexes={@Index(name="name_Index", columnList="nickname")}
 */
@Entity
@Table(name = "activity", schema = "springdemo",  catalog = "")
public class Activity extends BaseActivityEntity<Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2912999476359178126L;

	/** 报名开始日期 */
	private String enroll_start_date;
	
	private String enroll_end_date;
	
	/** 报名开始时间 */
	private String enroll_start_time;
	
	private String enroll_end_time;
	
	/** 活动地点*/
	private String location;

	/** 活动海报 */
	private String poster;
	
	/**是否展示报名用户 */
	private boolean isShow;
	/**报名后跳转页面 */
	private String gotopage;
	
	/**客服qq */
	private String qq;
	
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
	
	private String share_title;
	
	private String share_desc;
	
	private String share_img;
	
	/**公众号二维码 */ 
	private String gz_qrcode;

	
	@Basic
	@Column(name = "enroll_start_date", nullable = true)
	public String getEnroll_start_date() {
		return enroll_start_date;
	}

	public void setEnroll_start_date(String enroll_start_date) {
		this.enroll_start_date = enroll_start_date;
	}
	@Basic
	@Column(name = "enroll_end_date", nullable = true)
	public String getEnroll_end_date() {
		return enroll_end_date;
	}

	public void setEnroll_end_date(String enroll_end_date) {
		this.enroll_end_date = enroll_end_date;
	}
	@Basic
	@Column(name = "enroll_start_time", nullable = true)
	public String getEnroll_start_time() {
		return enroll_start_time;
	}

	public void setEnroll_start_time(String enroll_start_time) {
		this.enroll_start_time = enroll_start_time;
	}
	
	@Basic
	@Column(name = "enroll_end_time", nullable = true)
	public String getEnroll_end_time() {
		return enroll_end_time;
	}

	public void setEnroll_end_time(String enroll_end_time) {
		this.enroll_end_time = enroll_end_time;
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
	@Column(name = "isShow", nullable = true)
	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	@Basic
	@Column(name = "gotopage", nullable = true)
	public String getGotopage() {
		return gotopage;
	}

	public void setGotopage(String gotopage) {
		this.gotopage = gotopage;
	}
	@Basic
	@Column(name = "qq", nullable = true)
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
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
	@Column(name = "maxCnt", columnDefinition="tinyint default -1", nullable = true)
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
	@Basic
	@Column(name = "share_title", nullable = true)
	public String getShare_title() {
		return share_title;
	}

	public void setShare_title(String share_title) {
		this.share_title = share_title;
	}
	@Basic
	@Column(name = "share_desc", nullable = true)
	public String getShare_desc() {
		return share_desc;
	}

	public void setShare_desc(String share_desc) {
		this.share_desc = share_desc;
	}
	@Basic
	@Column(name = "share_img", nullable = true)
	public String getShare_img() {
		return share_img;
	}

	public void setShare_img(String share_img) {
		this.share_img = share_img;
	}
	@Basic
	@Column(name = "gz_qrcode", nullable = true)
	public String getGz_qrcode() {
		return gz_qrcode;
	}

	public void setGz_qrcode(String gz_qrcode) {
		this.gz_qrcode = gz_qrcode;
	}
	
	
	
	
}
