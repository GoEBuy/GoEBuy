package com.goebuy.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.goebuy.entity.user.Merchant;
import com.goebuy.entity.user.User;

/**
 * 订单表
 *
 * Created by luodejin on 2018/9/6.
 */
@Entity
@Table(name = "`order`", indexes={@Index(name="index_user", columnList="user_id"), @Index(name="index_order_id", columnList="order_id"), @Index(name="index_state", columnList="state"), @Index(name="index_event_id", columnList="event_id") }, schema = "springdemo",  catalog = "")
public class Order extends BaseEntity<Integer> {

    private static final long serialVersionUID = -4722104061011986099L;


    /**
     * 订单号：固定长度20
     */
    private String orderId;

    /**
     * 支付渠道：0 现金，1 支付宝，2 微信，3 储蓄卡，4 信用卡
     */
    private Integer channel;

    /**
     * 订单创建时间
     */
    private String createTime;

    /**
     * 订单支付时间
     */
    private String payTime;

    /**
     * 订单关闭时间：超过此时间未支付订单失效，自动关闭
     */
    private String closeTime;

    /**
     * 金额
     */
    private Double price;

    /**
     * 支付用户id
     */
    private User user;

    /**
     * 交易状态：0 待支付，1 交易成功，2 交易关闭
     */
    private Integer state;

    /**
     * 商品(事件)类型：0 活动，1 报名表，2 拼团，3 众筹，4 打赏，5 会员招募
     */
    private Integer type;

    /**
     * 事件(商品)id：与type联合使用，代表活动、报名表等id
     */
    private int eventId;

    /**
     * 审核人
     */
    private Merchant audit;

    /**
     * 描述信息
     */
    private String description;

    @Basic
    @Column(name = "order_id", unique=true, length=20, nullable = false)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "channel", nullable = true)
    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "pay_time")
    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "close_time")
    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @OneToOne(fetch = FetchType.EAGER,  cascade = {CascadeType.ALL})
    @JoinColumn(name="user_id", nullable=true )
    public User getUser() {	
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "event_id", nullable = false)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="merchant_id")
    public Merchant getAudit() {
        return audit;
    }

    public void setAudit(Merchant audit) {
        this.audit = audit;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
