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
 * 组织/企业表
 *
 * Created by luodejin on 2018/8/15.
 */
@Entity
@Table(name = "company_certification", schema = "springdemo", indexes={@Index(name="name_Index", columnList="name"), @Index(name="full_name_Index", columnList="full_name")}, catalog = "")
public class Company extends BaseEntity<Integer> {

    private static final long serialVersionUID = 53757879384651050L;

    private String name;                  //名称

    /**
     * 企业账号认证信息，非必须
     */
    private String fullName;              //组织/企业全称
    private String businessLicense;       //三证合一营业执照
    private String industry;              //所属行业
    private String address;               //所在地
    private String phoneNo;               //客服电话
    private User legalRepresentative;     //法定代表人

    private boolean isMerchant;           //是否是商户
    private Merchant user;                //关联的商户账号

    private String createTime;            //创建时间
    private String updateTime;            //最近更新时间

    @Basic
    @Column(name = "name", length=64, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "full_name", length=64, nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "business_license", length=50, nullable = false)
    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    @Basic
    @Column(name = "industry", nullable = false)
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Basic
    @Column(name = "address", length=125, nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone_no", length=15, nullable = false)
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    public User getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(User legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    @Basic
    @Column(name = "is_merchant", nullable = true)
    public boolean isMerchant() {
        return isMerchant;
    }

    public void setMerchant(boolean merchant) {
    	isMerchant = merchant;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name="merchant_id")
    public Merchant getUser() {
        return user;
    }

    public void setUser(Merchant merchant) {
        this.user = merchant;
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
