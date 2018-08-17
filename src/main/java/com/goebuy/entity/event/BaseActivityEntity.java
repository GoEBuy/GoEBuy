package com.goebuy.entity.event;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.alibaba.fastjson.JSON;
import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.user.User;

@MappedSuperclass
public abstract class BaseActivityEntity<T> extends BaseEntity<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7207739713485965568L;

	/** 创建人 */
	protected User creator;
	
	protected String createTime;
	
	/**最后一次更新时间 */
	protected String updateTime;
	
	/** 标题 */
	protected String name;
	
	protected String description;

	/**活动开始日期 */
	protected String startDate;
	
	protected String endDate;
	/**活动开始时间 */
	protected String startTime;
	
	protected String endTime;
	
	
	/**填写字段 */
	protected String fieldSet;
	
	/**标签集合， 最多5个 */
	protected String tagSet;
	
	/**咨询电话 */
	protected String contactPhone;
	
	
	/** 活动状态*/
	protected String state;
	
	/** 活动链接地址 */
	protected String url;
	
	/**活动二维码图片 */
	protected String qrcode;
	
//	private int version;


	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public User getCreator() {
		return creator;
	}

	public void setCreator(User user) {
		this.creator = user;
	}
	
	@Basic
	@Column(name = "create_time",updatable = false,  nullable = false)
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String create_time) {
		this.createTime = create_time;
	}
	//columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
	@Basic
	@Column(name = "updateTime",  nullable = false)
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String update_time) {
		this.updateTime = update_time;
	}

	@Basic
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "description", nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic
	@Column(name = "start_date", nullable = true)
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String start_date) {
		this.startDate = start_date;
	}
	
	@Basic
	@Column(name = "end_date", nullable = true)
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String end_date) {
		this.endDate = end_date;
	}
	@Basic
	@Column(name = "start_time", nullable = true)
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String start_time) {
		this.startTime = start_time;
	}
	@Basic
	@Column(name = "end_time", nullable = true)
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String end_time) {
		this.endTime = end_time;
	}
	
	@Basic
	@Column(name = "field_set", nullable = true)
	public String getFieldSet() {
		return fieldSet;
	}

	public void setFieldSet(String field_set) {
		this.fieldSet = field_set;
	}
	@Basic
	@Column(name = "tag_set", nullable = true)
	public String getTagSet() {
		return tagSet;
	}

	public void setTagSet(String tagSet) {
		this.tagSet = tagSet;
	}
	@Basic
	@Column(name = "contact_phone", nullable = true)
	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	@Basic
	@Column(name = "state", nullable = true)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@Basic
	@Column(name = "url", nullable = true)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@Basic
	@Column(name = "qrcode", nullable = true)
	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
