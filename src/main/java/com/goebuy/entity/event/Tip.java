package com.goebuy.entity.event;

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
@Table(name = "tip", indexes={@Index(name="index_merchant", columnList="merchant_id"), @Index(name="index_name", columnList="name")},  schema = "springdemo",  catalog = "")
public class Tip extends BaseActivityEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -467076718741543076L;

	
	private String poster;
	
	/** 文章内容 */
	private String content;
	
	/** 打赏后内容  */
	private String hiddenContent;
	
	/**设置打赏后可见内容*/
	private boolean isAfterShow;
	

	/**打赏金额设置  6等级：1，5，10，50， 100，200 */
	private String feeLevel;
	
	/** 展示自定义打赏金额*/
	private boolean showCustomFee;
	
	/**展示用户打赏排行榜 */
	private boolean showRank;
	
	
	/**后台数据统计时间 打赏发布后无法再修改统计时间， 7天，1个月， 3个月 */
	private int staticsDaySpan=30;

	
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
	@Column(name = "hidden_content", columnDefinition="text COMMENT '打赏后可见内容'", nullable = true)
	public String getHiddenContent() {
		return hiddenContent;
	}

	public void setHiddenContent(String hiddenContent) {
		this.hiddenContent = hiddenContent;
	}
	
	@Basic
	@Column(name = "is_after_show", nullable = true)
	public boolean isAfterShow() {
		return isAfterShow;
	}

	public void setAfterShow(boolean isAfterShow) {
		this.isAfterShow = isAfterShow;
	}

	@Basic
	@Column(name = "fee_level", nullable = true)
	public String getFeeLevel() {
		return feeLevel;
	}

	public void setFeeLevel(String feelevel) {
		this.feeLevel = feelevel;
	}
	

	public void setShowCustomFee(boolean showCustomFee) {
		this.showCustomFee = showCustomFee;
	}

	@Basic
	@Column(name = "show_custom_fee", nullable = true)
	public boolean isShowCustomFee() {
		return showCustomFee;
	}

	@Basic
	@Column(name = "show_rank", nullable = true)
	public boolean isShowRank() {
		return showRank;
	}

	public void setShowRank(boolean showRank) {
		this.showRank = showRank;
	}
	@Basic
	@Column(name = "statics_day_span", nullable = true)
	public int getStaticsDaySpan() {
		return staticsDaySpan;
	}

	public void setStaticsDaySpan(int staticsDaySpan) {
		this.staticsDaySpan = staticsDaySpan;
	}
	
	
	
	
	
	
	
	
	
	
	
}
