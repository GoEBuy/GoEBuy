package com.goebuy.entity;

import com.goebuy.entity.user.User;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 系统通知信息
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "sys_sysinfo", indexes={@Index(name="title_index", columnList="title")}, schema = "springdemo", catalog = "")
public class SystemInfo extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6984553767438778711L;

	/* varchar */
	private String title;

	/* varchar */
	private String content;

	/**
	 * many2one
	 */
	private User user;

	private String pubDate;

	private String updateDate;

	/**
	 * 简述
	 */
	private String desc;

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
	public User getUser() {
		return user;
	}

	public void setUser(User userByUserId) {
		this.user = userByUserId;
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

		SystemInfo that = (SystemInfo) o;

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

}
