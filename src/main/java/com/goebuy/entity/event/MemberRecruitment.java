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
@Table(name = "member_recruitment",indexes={@Index(name="name_index", columnList="name")},  schema = "springdemo")
public class MemberRecruitment extends BaseActivityEntity<Integer> {

    private static final long serialVersionUID = 6833768588441240453L;

    /**
     * 基本信息
     */
    private String poster;                //项目海报：640＊400
    private String memberPrivilege;       //会员特权
    private String memberFee;             //会费
    private String qq;                    //已开启QQ通讯组件的QQ号码
    private String gzQrcode;              //微信公众号二维码

    /**
     * 分享信息
     */
    private String shareTitle;            //分享标题
    private String shareDesc;             //分享描述
    private String shareImg;              //分享图片

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

    @Basic
    @Column(name = "qq", nullable = true)
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "gz_qrcode", nullable = true)
    public String getGzQrcode() {
        return gzQrcode;
    }

    public void setGzQrcode(String gzQrcode) {
        this.gzQrcode = gzQrcode;
    }

    @Basic
    @Column(name = "share_title", nullable = false)
    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    @Basic
    @Column(name = "share_desc", nullable = false)
    public String getShareDesc() {
        return shareDesc;
    }

    public void setShareDesc(String shareDesc) {
        this.shareDesc = shareDesc;
    }

    @Basic
    @Column(name = "share_img", nullable = false)
    public String getShareImg() {
        return shareImg;
    }

    public void setShareImg(String shareImg) {
        this.shareImg = shareImg;
    }
}
