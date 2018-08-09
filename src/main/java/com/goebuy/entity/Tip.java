package com.goebuy.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 打赏
 * @author Administrator
 *
 */
@Entity
@Table(name = "tip", indexes={@Index(name="index_name", columnList="name")},  schema = "springdemo",  catalog = "")
public class Tip extends BaseActivityEntity<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -467076718741543076L;

	
	private String poster;
	
	/** 文章内容 */
	private String content;
	
	/** 打赏后内容  */
	private String hidden_content;
	
	/**设置打赏后可见内容*/
	private String after_show;
	
	/**打赏金额 */
	private double fee;
	
	/**打赏金额设置  6等级：1，5，10，50， 100，200 */
	private String feelevel;
	
	/** 展示自定义打赏金额*/
	private boolean iscustomfee;
	
	/**展示用户打赏排行榜 */
	private boolean show_rank;
	
	/**后台数据统计时间 打赏发布后无法再修改统计时间， 7天，1个月， 3个月 */
	private int statics_day_span=30;

	
	@Basic
	@Column(name = "poster", nullable = true)
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	@Basic
	@Column(name = "content", length=10000, nullable = true)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Basic
	@Column(name = "hidden_content", length=10000, nullable = true)
	public String getHidden_content() {
		return hidden_content;
	}

	public void setHidden_content(String hidden_content) {
		this.hidden_content = hidden_content;
	}
	@Basic
	@Column(name = "after_show", nullable = true)
	public String getAfter_show() {
		return after_show;
	}

	public void setAfter_show(String after_show) {
		this.after_show = after_show;
	}
	@Basic
	@Column(name = "fee", nullable = true)
	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	@Basic
	@Column(name = "feelevel", nullable = true)
	public String getFeelevel() {
		return feelevel;
	}

	public void setFeelevel(String feelevel) {
		this.feelevel = feelevel;
	}
	@Basic
	@Column(name = "iscustomfee", nullable = true)
	public boolean isIscustomfee() {
		return iscustomfee;
	}

	public void setIscustomfee(boolean iscustomfee) {
		this.iscustomfee = iscustomfee;
	}
	@Basic
	@Column(name = "show_rank", nullable = true)
	public boolean isShow_rank() {
		return show_rank;
	}

	public void setShow_rank(boolean show_rank) {
		this.show_rank = show_rank;
	}
	@Basic
	@Column(name = "statics_day_span", nullable = true)
	public int getStatics_day_span() {
		return statics_day_span;
	}

	public void setStatics_day_span(int statics_day_span) {
		this.statics_day_span = statics_day_span;
	}
	
	
	
	
	
	
	
	
	
	
	
}
