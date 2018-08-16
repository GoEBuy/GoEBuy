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
 * 银行账户表
 * Created by luodejin on 2018/8/15.
 */
@Entity
@Table(name = "bank_account", schema = "springdemo", indexes={@Index(name="bank_card_number_Index", columnList="bankCardNo")}, catalog = "")
public class BankAccount extends BaseEntity<Integer> {

    private static final long serialVersionUID = 208075760882253739L;

    private String accountType;           //账号类型：企业或法人
    private String bankName;              //银行名称
    private String cityName;              //开户银行所在城市
    private String bankBranchName;        //开户银行支行名称
    private String bankCardNo;            //银行卡号
    private String phoneNumber;           //银行预留手机号
    private CompanyCertification companyCertification; //账号类型为企业
    private PersonCertification personCertification;   //账号类型为法人

    @Basic
    @Column(name = "account_type", nullable = false)
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "bank_name", nullable = false)
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "city_name", nullable = false)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "bank_branch_name", nullable = false)
    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    @Basic
    @Column(name = "bank_card_name", nullable = false)
    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    @Basic
    @Column(name = "phone_number", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    public CompanyCertification getCompanyCertification() {
        return companyCertification;
    }


    public void setCompanyCertification(CompanyCertification companyCertification) {
        this.companyCertification = companyCertification;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    public PersonCertification getPersonCertification() {
        return personCertification;
    }

    public void setPersonCertification(PersonCertification personCertification) {
        this.personCertification = personCertification;
    }
}
