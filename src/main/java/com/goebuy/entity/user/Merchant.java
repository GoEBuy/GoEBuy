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
    private String email;                 //邮箱
    private String password;              //密码
    private String name;                  //账号名称：商户名称，商家名称，社群名称
    private String logo;                  //Logo
    private String phoneNo;               //手机号码
    private String administrator;         //管理员姓名
    private String createTime;            //注册时间
    private String updateTime;            //最近更新时间

    /**
     * 认证信息
     */
    private int state;                    //状态：1 未认证，2 审核中，3 认证成功, 4 禁用，5 注销
    private int certificateType;          //认证类型：1 企业账号认证，2 个人账号认证
    private Company companyCertification; //企业账号认证
    private User personCertification;     //个人账号认证
    private String certificateTime;       //认证时间

    /**
     * 收款账户
     */
    private BankAccount bankAccount;      //收款账户

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
    private long vipId;                   //vip卡号
    private int vipType;                  //vip类型
    private String vipStartTime;          //商户付费成为vip的时间
    private String vipEndTime;            //vip到期时间
    private int vipCount;                 //缴费次数

    /**
     * 登录信息
     */
    private String loginTime;             //最后登录时间
    private String loginIp;               //最后登录IP
    private int loginCount;               //登录次数

    private User introducer;              //介绍人
    private String channel;               //渠道

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
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
    public Company getCompanyCertification() {
        return companyCertification;
    }

    public void setCompanyCertification(Company companyCertification) {
        this.companyCertification = companyCertification;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public User getPersonCertification() {
        return personCertification;
    }

    public void setPersonCertification(User personCertification) {
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
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
    public long getVipId() {
        return vipId;
    }

    public void setVipId(long vipId) {
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
    @Column(name = "vip_start_time", nullable = true)
    public String getVipStartTime() {
        return vipStartTime;
    }

    public void setVipStartTime(String vipStartTime) {
        this.vipStartTime = vipStartTime;
    }

    @Basic
    @Column(name = "vip_end_time", nullable = true)
    public String getVipEndTime() {
        return vipEndTime;
    }

    public void setVipEndTime(String vipEndTime) {
        this.vipEndTime = vipEndTime;
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
    @Column(name = "login_time", nullable = true)
    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "login_ip", nullable = true)
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
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
