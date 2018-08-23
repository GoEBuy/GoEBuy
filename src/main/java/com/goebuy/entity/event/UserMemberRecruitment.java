package com.goebuy.entity.event;

import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.user.User;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户会员招募表
 *
 * Created by luodejin on 2018/8/15.
 */
@Entity
@Table(name = "user_member_recruitment", indexes={@Index(name="index_user", columnList="user_id"), @Index(name="index_member_recuritment_id",columnList="member_recuritment_id") }, schema = "springdemo",  catalog = "")
public class UserMemberRecruitment extends BaseEntity<Integer> {

    private static final long serialVersionUID = 2508655292139612838L;
    /** 被招募的用户 */
    private User user;

    private MemberRecruitment memberRecruitment;

    /** 招募入会时间 */
    private String createTime;        

    /** 报名渠道 */
    private String channel;

    /** 票劵类型 */
    private int ticketType;

    /** 金额 */
    private double price;

    /** 交易状态 */
    private String exchangeState;     //1 待支付，2 已成功报名(交易成功)，3 已关闭报名(交易关闭)

    /** 操作 */
    private String operation;

    /** 浏览次数 */
    private int pv;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="member_recuritment_id")
    public MemberRecruitment getMemberRecruitment() {
        return memberRecruitment;
    }

    public void setMemberRecruitment(MemberRecruitment memberRecruitment) {
        this.memberRecruitment = memberRecruitment;
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
    @Column(name = "channel", nullable = true)
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Basic
    @Column(name = "ticket_type", nullable = true)
    public int getTicketType() {
        return ticketType;
    }

    public void setTicketType(int ticketType) {
        this.ticketType = ticketType;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "exchange_state", nullable = true)
    public String getExchangeState() {
        return exchangeState;
    }

    public void setExchangeState(String exchangeState) {
        this.exchangeState = exchangeState;
    }

    @Basic
    @Column(name = "operation", nullable = true)
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Basic
    @Column(name = "pv", nullable = true)
    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
}
