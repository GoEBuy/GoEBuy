package com.goebuy.entity.user;

import com.goebuy.entity.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * VIP表
 *
 * Created by luodejin on 2018/8/16.
 */
@Entity
@Table(name = "vip", schema = "springdemo", indexes={@Index(name="bank_card_number_Index", columnList="bankCardNo")}, catalog = "")
public class VIP extends BaseEntity<Integer> {

    private static final long serialVersionUID = -1177028922840848586L;

    private int vipType;                  //会员卡类型
    private int vipName;                  //会员卡名称
    private int fee;                      //费用
    private int privilege;                //特权
    private int description;              //描述信息


    private int duration;                 //使用期限
    private int start_time;               //会员卡有效期开始时间
    private int end_time;                 //会员卡有效期结束时间


    @Basic
    @Column(name = "vip_type", nullable = false)
    public int getVipType() {
        return vipType;
    }

    public void setVipType(int vipType) {
        this.vipType = vipType;
    }

    @Basic
    @Column(name = "vip_name", nullable = false)
    public int getVipName() {
        return vipName;
    }

    public void setVipName(int vipName) {
        this.vipName = vipName;
    }

    @Basic
    @Column(name = "fee", nullable = false)
    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Basic
    @Column(name = "privilege", nullable = false)
    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    @Basic
    @Column(name = "description", nullable = false)
    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    @Basic
    @Column(name = "duration", nullable = false)
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "start_time", nullable = false)
    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    @Basic
    @Column(name = "end_time", nullable = false)
    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }
}
