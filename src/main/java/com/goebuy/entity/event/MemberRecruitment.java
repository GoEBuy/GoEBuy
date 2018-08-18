package com.goebuy.entity.event;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 招募表
 *
 * Created by luodejin on 2018/8/15.
 */
@Entity
@Table(name = "member_recruitment",indexes={@Index(name="name_index", columnList="name")},  schema = "springdemo")
public class MemberRecruitment extends BaseActivityEntity<Integer> {

    private static final long serialVersionUID = 6833768588441240453L;

    /**
     * 基本信息
     */
    private String poster;                //项目海报：640＊400
    private String memberPrivilege;       //会员特权
    private String memberFee;             //会费

    
    @Basic
    @Column(name = "poster", nullable = false)
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Basic
    @Column(name = "member_privilege", nullable = false)
    public String getMemberPrivilege() {
        return memberPrivilege;
    }

    public void setMemberPrivilege(String memberPrivilege) {
        this.memberPrivilege = memberPrivilege;
    }

    @Basic
    @Column(name = "member_fee", nullable = false)
    public String getMemberFee() {
        return memberFee;
    }

    public void setMemberFee(String memberFee) {
        this.memberFee = memberFee;
    }

}
