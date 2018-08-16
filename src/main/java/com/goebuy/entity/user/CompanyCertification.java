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
 * 企业账号认证
 *
 * Created by luodejin on 2018/8/15.
 */
@Entity
@Table(name = "company_certification", schema = "springdemo", indexes={@Index(name="company_name_Index", columnList="companyName")}, catalog = "")
public class CompanyCertification extends BaseEntity<Integer> {

    private static final long serialVersionUID = 53757879384651050L;

    private String companyNo;             //编号，系统生成
    private String companyName;           //组织/企业全称
    private String businessLicense;       //三证合一营业执照
    private String industry;              //所属行业
    private String address;               //所在地
    private String customerPhoneNumber;   //客服电话
    private PersonCertification legalPerson;  //法定代表人

    @Basic
    @Column(name = "company_no", nullable = false)
    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    @Basic
    @Column(name = "company_name", nullable = false)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "business_license", nullable = false)
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
    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "customer_phone_number", nullable = false)
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    public PersonCertification getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(PersonCertification legalPerson) {
        this.legalPerson = legalPerson;
    }
}
