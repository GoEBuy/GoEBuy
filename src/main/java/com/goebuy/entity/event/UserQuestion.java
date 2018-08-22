package com.goebuy.entity.event;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.user.Merchant;
import com.goebuy.entity.user.User;

/**
 * 用户问卷表
 * @author Administrator
 */
@Entity
@Table(name = "user_question", indexes={@Index(name="index_user", columnList="user_id")}, schema = "springdemo",  catalog = "")
public class UserQuestion extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4867590336448602514L;

	/** 问卷填写人 */
	private User user;
	
	private Question question;
	
	/** 问卷填写姓名*/
	private String username;

	/** 问卷填写 手机号 */
	private String phone;
	
	private String fieldSet;
	
	/** 创建人 */
	private Merchant creator;
	
	private String createTime;

	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	@Basic
	@Column(name = "username", nullable = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Basic
	@Column(name = "phone", nullable = true)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Basic
	@Column(name = "field_set", nullable = true)
	public String getFieldSet() {
		return fieldSet;
	}

	public void setFieldSet(String fieldSet) {
		this.fieldSet = fieldSet;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Merchant getCreator() {
		return creator;
	}

	public void setCreator(Merchant creator) {
		this.creator = creator;
	}
	@Basic
	@Column(name = "create_time", nullable = true)
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
