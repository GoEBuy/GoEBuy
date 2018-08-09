package com.goebuy.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.alibaba.fastjson.JSON;

@MappedSuperclass
public abstract class BaseActivityEntity<T> extends BaseEntity<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7207739713485965568L;

	protected T id;
	
	protected UserEntity user;
	
	protected String create_time;
	
	/**最后一次更新时间 */
	protected String update_time;
	
	/** 标题 */
	protected String name;
	
	protected String description;

	/**活动开始日期 */
	protected String start_date;
	
	protected String end_date;
	/**活动开始时间 */
	protected String start_time;
	
	protected String end_time;
	
	
	/**填写字段 */
	protected String field_set;
	
	/**标签集合， 最多5个 */
	protected String tag_set;
	
	/**咨询电话 */
	protected String contact_phone;
	
	/** 状态*/
	protected String state;
	
	/** 活动链接地址 */
	protected String url;
	
	/**活动二维码图片 */
	protected String qrcode;
	
	
	
//	private int version;


	/**
	 * 主键id自增长
	 * 
	 * @return
	 */
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator = "generator")
	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	@Basic
	@Column(name = "create_time",updatable = false,  nullable = false)
	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	//columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
	@Basic
	@Column(name = "update_time",  nullable = false)
	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
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
	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	
	@Basic
	@Column(name = "end_date", nullable = true)
	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	@Basic
	@Column(name = "start_time", nullable = true)
	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	@Basic
	@Column(name = "end_time", nullable = true)
	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
	@Basic
	@Column(name = "field_set", nullable = true)
	public String getField_set() {
		return field_set;
	}

	public void setField_set(String field_set) {
		this.field_set = field_set;
	}
	@Basic
	@Column(name = "tag_set", nullable = true)
	public String getTag_set() {
		return tag_set;
	}

	public void setTag_set(String tag_set) {
		this.tag_set = tag_set;
	}
	@Basic
	@Column(name = "contact_phone", nullable = true)
	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
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
