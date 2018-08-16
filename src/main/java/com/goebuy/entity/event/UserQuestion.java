package com.goebuy.entity.event;

import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.user.User;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户问卷表
 * @author Administrator
 */
@Entity
@Table(name = "user_question", schema = "springdemo",  catalog = "")
public class UserQuestion extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4867590336448602514L;

	/** 问卷填写人 */
	private User user;
	
	private Question question;
	
	/** 姓名*/
	private String username;

	/** 手机号 */
	private String phone;
	
	private String field_set;
	
	/** 创建人 */
	private User creator;
	
	private String create_time;

	
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
	public String getField_set() {
		return field_set;
	}

	public void setField_set(String field_set) {
		this.field_set = field_set;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	@Basic
	@Column(name = "create_time", nullable = true)
	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

}