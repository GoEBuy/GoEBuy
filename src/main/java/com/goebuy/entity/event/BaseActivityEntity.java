package com.goebuy.entity.event;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.alibaba.fastjson.JSON;
import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.user.Merchant;

@MappedSuperclass
public abstract class BaseActivityEntity<T> extends BaseEntity<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7207739713485965568L;

	/** 创建人, 对应会员用户表 */
	protected Merchant creator;
	
	protected String createTime;
	
	/**最后一次更新时间 */
	protected String updateTime;
	
	/** 标题 , 最长64个字符  */
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
	
	
	/** 活动状态 0:未开始 1:进行中 2:已结束*/
	protected int state;
	
	/** 活动链接地址 */
	protected String url;
	
	/**活动二维码图片 */
	protected String qrcode;
	
	
	/**
     * 分享信息
     */
	/**分享标题*/
	private String shareTitle;
	/**分享描述*/
	private String shareDesc;
	/**分享图片*/
	private String shareImg;
	
	/** 客服qq  已开启QQ通讯组件的QQ号码 */
	private String qq;
	
	/**公众号二维码 */ 
	private String gzQrcode;

	
//	private int version;


	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH,CascadeType.PERSIST} )
	@JoinColumn(name="merchant_id" )
	public Merchant getCreator() {
		return creator;
	}

	public void setCreator(Merchant merchant) {
		this.creator = merchant;
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
	@Column(name = "update_time",  nullable = false)
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String update_time) {
		this.updateTime = update_time;
	}

	@Basic
	@Column(name = "name", length=64, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "description",  nullable = true)
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
	@Column(name = "start_time", length=30, columnDefinition="varchar(30) default '2009-01-01 00:00:00'", nullable = true)
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String start_time) {
		this.startTime = start_time;
	}
	@Basic
	@Column(name = "end_time", length=30, columnDefinition="varchar(30) default '2009-01-01 00:00:00'", nullable = true)
	public String getEndTime() {
		return endTime;
	}
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(columnDefinition="TIMESTAMPTZ   default '2009-01-01 00:00:00'",nullable=false,insertable=false,updatable=false)
//	Date enMenuVerTime;//英文菜品校验时间

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
	@Column(name = "tag_set", columnDefinition = "varchar(120) COMMENT '活动标签集合'", nullable = true)
	public String getTagSet() {
		return tagSet;
	}

	public void setTagSet(String tagSet) {
		this.tagSet = tagSet;
	}
	@Basic
	@Column(name = "contact_phone", length=15, nullable = true)
	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	@Basic
	@Column(name = "state", nullable = true)
	public int getState() {
		return state;
	}

	public void setState(int state) {
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

	@Basic
	@Column(name = "qq", length=15, nullable = true)
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	
	@Basic
	@Column(name = "share_title", length=64, nullable = true)
	public String getShareTitle() {
		return shareTitle;
	}

	public void setShareTitle(String share_title) {
		this.shareTitle = share_title;
	}
	@Basic
	@Column(name = "share_desc", nullable = true)
	public String getShareDesc() {
		return shareDesc;
	}

	public void setShareDesc(String share_desc) {
		this.shareDesc = share_desc;
	}
	@Basic
	@Column(name = "share_img", nullable = true)
	public String getShareImg() {
		return shareImg;
	}

	public void setShareImg(String share_img) {
		this.shareImg = share_img;
	}
	@Basic
	@Column(name = "gz_qrcode", nullable = true)
	public String getGzQrcode() {
		return gzQrcode;
	}

	public void setGzQrcode(String gz_qrcode) {
		this.gzQrcode = gz_qrcode;
	}
	
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
