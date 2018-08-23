package com.goebuy.entity.event;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 会员招募表
 *
 * Created by luodejin on 2018/8/15.
 */
@Entity
@Table(name = "member_recruitment",indexes={@Index(name="index_merchant", columnList="merchant_id"), @Index(name="index_name", columnList="name")} ,  schema = "springdemo")
public class MemberRecruitment extends BaseActivityEntity<Integer> {

    private static final long serialVersionUID = 6833768588441240453L;

    /**
     * 基本信息
     */
    private String poster;                //项目海报：640＊400
    private String privilege;             //会员特权
    private String fee;                   //会费


    @Basic
    @Column(name = "poster", nullable = false)
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
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
    @Column(name = "fee", nullable = false)
    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

}
