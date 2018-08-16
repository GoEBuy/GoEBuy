package com.goebuy.entity.user;

import com.goebuy.entity.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 注册商户(商家)
 *
 * Created by luodejin on 2018/8/14.
 */
@Entity
@Table(name = "merchant", schema = "springdemo", indexes={@Index(name="nick_name_Index", columnList="nickName")}, catalog = "")
public class Merchant extends BaseEntity<Integer> {

    private static final long serialVersionUID = 4554875451091830646L;

    /**
     * 注册商户基本信息
     */
    private String merchantNo;            //编号，系统生成
    private String email;                 //邮箱
    private String password;              //密码
    private String merchantName;          //账号名称：商户名称，商家名称，社群名称
    private String logo;                  //Logo
    private String phoneNo;               //手机号码
    private String administrator;         //管理员姓名
    private String registerTime;          //注册时间

    /**
     * 认证信息
     */
    private int certificateState;         //认证状态：1 未认证，2 审核中，3 认证成功, 4 禁用，5 注销
    private int certificateType;          //认证类型：1 企业账号认证，2 个人账号认证
    private CompanyCertification companyCertification; //账号类型为企业
    private PersonCertification personCertification;   //账号类型为法人
    private String certificateTime;       //认证时间

    /**
     * 附加信息
     *
     */
    private int merchantLevel;            //商户等级
    private int merchantIntegral;         //商户积分

    /**
     * 会员卡信息
     */
    private boolean isVip;                //是否vip
    private int vipId;                    //会员卡编号_自增id
    private int vipType;                  //会员类型
    private String initiationTime;        //用户付费成为vip的时间
    private String expirationTime;        //vip失效时间
    private int vipCount;                 //缴费次数

    private String latestLoginTime;       //最后登录时间
    private String latestLoginIp;         //最后登录IP
    private String latestModifyTime;      //最后修改信息时间
    private int loginCount;               //登录次数

    private User introducer;              //介绍人
    private String channel;               //渠道

    @Basic
    @Column(name = "merchant_no", nullable = false)
    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    @Basic
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "merchant_name", nullable = false)
    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Basic
    @Column(name = "logo", nullable = true)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Basic
    @Column(name = "phone_no", nullable = false)
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Basic
    @Column(name = "administrator", nullable = false)
    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    @Basic
    @Column(name = "register_time", nullable = false)
    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Basic
    @Column(name = "certificate_state", nullable = false)
    public int getCertificateState() {
        return certificateState;
    }

    public void setCertificateState(int certificateState) {
        this.certificateState = certificateState;
    }

    @Basic
    @Column(name = "certificate_type", nullable = true)
    public int getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(int certificateType) {
        this.certificateType = certificateType;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public CompanyCertification getCompanyCertification() {
        return companyCertification;
    }

    public void setCompanyCertification(CompanyCertification companyCertification) {
        this.companyCertification = companyCertification;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public PersonCertification getPersonCertification() {
        return personCertification;
    }

    public void setPersonCertification(PersonCertification personCertification) {
        this.personCertification = personCertification;
    }

    @Basic
    @Column(name = "certificate_time", nullable = true)
    public String getCertificateTime() {
        return certificateTime;
    }

    public void setCertificateTime(String certificateTime) {
        this.certificateTime = certificateTime;
    }

    @Basic
    @Column(name = "merchant_level", nullable = true)
    public int getMerchantLevel() {
        return merchantLevel;
    }

    public void setMerchantLevel(int merchantLevel) {
        this.merchantLevel = merchantLevel;
    }

    @Basic
    @Column(name = "merchant_integral", nullable = true)
    public int getMerchantIntegral() {
        return merchantIntegral;
    }

    public void setMerchantIntegral(int merchantIntegral) {
        this.merchantIntegral = merchantIntegral;
    }

    @Basic
    @Column(name = "is_vip", nullable = true)
    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    @Basic
    @Column(name = "vip_id", nullable = true)
    public int getVipId() {
        return vipId;
    }

    public void setVipId(int vipId) {
        this.vipId = vipId;
    }

    @Basic
    @Column(name = "vip_type", nullable = true)
    public int getVipType() {
        return vipType;
    }

    public void setVipType(int vipType) {
        this.vipType = vipType;
    }

    @Basic
    @Column(name = "initiation_time", nullable = true)
    public String getInitiationTime() {
        return initiationTime;
    }

    public void setInitiationTime(String initiationTime) {
        this.initiationTime = initiationTime;
    }

    @Basic
    @Column(name = "expiration_time", nullable = true)
    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Basic
    @Column(name = "vip_count", nullable = true)
    public int getVipCount() {
        return vipCount;
    }

    public void setVipCount(int vipCount) {
        this.vipCount = vipCount;
    }

    @Basic
    @Column(name = "latest_login_time", nullable = true)
    public String getLatestLoginTime() {
        return latestLoginTime;
    }

    public void setLatestLoginTime(String latestLoginTime) {
        this.latestLoginTime = latestLoginTime;
    }

    @Basic
    @Column(name = "latest_login_ip", nullable = true)
    public String getLatestLoginIp() {
        return latestLoginIp;
    }

    public void setLatestLoginIp(String latestLoginIp) {
        this.latestLoginIp = latestLoginIp;
    }

    @Basic
    @Column(name = "latest_modify_time", nullable = true)
    public String getLatestModifyTime() {
        return latestModifyTime;
    }

    public void setLatestModifyTime(String latestModifyTime) {
        this.latestModifyTime = latestModifyTime;
    }

    @Basic
    @Column(name = "lonin_count", nullable = true)
    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public User getIntroducer() {
        return introducer;
    }

    public void setIntroducer(User introducer) {
        this.introducer = introducer;
    }

    @Basic
    @Column(name = "channel", nullable = true)
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
