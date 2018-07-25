package com.goebuy.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.alibaba.fastjson.JSON;

/**
 * 系统通知信息
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "sys_info", indexes={@Index(name="title_index", columnList="title")}, schema = "springdemo", catalog = "")
public class SystemInfoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6984553767438778711L;

	private int id;

	/* varchar */
	private String title;

	/* varchar */
	private String content;

	/**
	 * many2one
	 */
	private UserEntity userByUserId;

	private String pubDate;

	private String updateDate;

	/**
	 * 简述
	 */
	private String desc;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "title", nullable = false, length = 100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Basic
	@Column(name = "content", nullable = true, length = 250)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
	public UserEntity getUserByUserId() {
		return userByUserId;
	}

	public void setUserByUserId(UserEntity userByUserId) {
		this.userByUserId = userByUserId;
	}

	@Basic
	@Column(name = "pub_date", nullable = false, length=20 )
	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	@Basic
	@Column(name = "update_date", nullable = false, length=20)
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Basic
	@Column(name = "desc", columnDefinition = "内容简介", nullable = true, length=120)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SystemInfoEntity that = (SystemInfoEntity) o;

		if (id != that.id)
			return false;
		if (title != null ? !title.equals(that.title) : that.title != null)
			return false;
		if (content != null ? !content.equals(that.content) : that.content != null)
			return false;
		if (pubDate != null ? !pubDate.equals(that.pubDate) : that.pubDate != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (content != null ? content.hashCode() : 0);
		result = 31 * result + (pubDate != null ? pubDate.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
