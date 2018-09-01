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
import com.goebuy.entity.user.Merchant;

/**
 * 活动分类库
 * @author Administrator
 *
 */
@Entity
@Table(name = "activity_cate",  indexes={@Index(name="cate_name_Index", columnList="cate_name"), @Index(name="pcate_id_Index", columnList="pcate_id")} , schema = "springdemo",  catalog = "")
public class ActivityCategory extends BaseEntity<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 711037462787375173L;

	/** 父类活动分类id */
	private int pcateId = -1;
	
	/** 活动分类名称 */
	private String cateName;
	
	/** 创建用户  */
	private Merchant createUser;
	
	/** 创建时间 */
	private String createTime;
	
	/** 是否是通用标签库  */
	private boolean isCommon=false;

	@Basic
	@Column(name = "pcate_id", nullable = true)
	public int getPcateId() {
		return pcateId;
	}

	public void setPcateId(int pcateId) {
		this.pcateId = pcateId;
	}

	@Basic
	@Column(name = "cate_name", nullable = false, unique= true )
	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="merchant_id")
	public Merchant getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Merchant createUser) {
		this.createUser = createUser;
	}

	@Basic
	@Column(name = "create_time", nullable = true )
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Basic
	@Column(name = "is_common", nullable = true )
	public boolean isCommon() {
		return isCommon;
	}

	public void setCommon(boolean isCommon) {
		this.isCommon = isCommon;
	}
	
	
	
	
}
