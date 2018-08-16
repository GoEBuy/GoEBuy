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
 * 会员招募表
 *
 * Created by luodejin on 2018/8/15.
 */
@Entity
@Table(name = "user_member_recruitment", schema = "springdemo",  catalog = "")
public class UserMemberRecruitment extends BaseEntity<Integer> {

    private static final long serialVersionUID = 2508655292139612838L;

    private User user;

    private MemberRecruitment memberRecruitment;

    private String initiationTime;        //招募入会时间

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public MemberRecruitment getMemberRecruitment() {
        return memberRecruitment;
    }

    public void setMemberRecruitment(MemberRecruitment memberRecruitment) {
        this.memberRecruitment = memberRecruitment;
    }

    @Basic
    @Column(name = "initiation_time", nullable = false)
    public String getInitiationTime() {
        return initiationTime;
    }

    public void setInitiationTime(String initiationTime) {
        this.initiationTime = initiationTime;
    }
}
