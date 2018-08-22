package com.goebuy.entity.user;

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

/**
 * 会员卡表
 *
 * Created by luodejin on 2018/8/16.
 */
@Entity
@Table(name = "vip", schema = "springdemo", indexes={@Index(name="index_merchant_id", columnList="user_id")}, catalog = "")
public class VIP extends BaseEntity<Integer> {

    private static final long serialVersionUID = -1177028922840848586L;

    private int type;                     //vip类型
    private String name;                  //vip名称
    private String fee;                   //购买费用
    private String privilege;             //特权
    private String description;           //描述信息

    private String duration;              //有效期
    private int state;                    //状态：1 在售，2 未在售

    private Merchant creator;                 //创建人
    private String createTime;            //该种会员卡创建时间
    private String updateTime;            //该种会员卡最近更新时间

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "fee", nullable = false)
    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Basic
    @Column(name = "privilege", nullable = false)
    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Basic
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "duration", nullable = false)
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name="user_id")
    public Merchant getCreator() {
        return creator;
    }

    public void setCreator(Merchant creator) {
        this.creator = creator;
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
    @Column(name = "update_time", nullable = false)
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
