package com.goebuy.entity.user;

import com.goebuy.entity.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 银行账户表
 * Created by luodejin on 2018/8/15.
 */
@Entity
@Table(name = "bank_account", schema = "springdemo", indexes={@Index(name="bank_card_number_Index", columnList="card_no")}, catalog = "")
public class BankAccount extends BaseEntity<Integer> {

    

	private static final long serialVersionUID = 208075760882253739L;

    private String type;                  //账号类型：1 企业, 2 个人
    private String name;                  //银行名称
    private String cityName;              //开户银行所在城市
    private String branchName;            //开户银行支行名称
    private String cardNo;                //银行卡号
    private String phoneNo;               //银行预留手机号
    private User cardholder;              //持卡人

    private String createTime;            //创建时间
    private String updateTime;            //最近更新时间

    @Basic
    @Column(name = "type", nullable = false)
    public String getType() {
		return type;
	}
    
    public void setType(String accountType) {
        this.type = accountType;
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
    @Column(name = "city_name", nullable = false)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "branch_name", nullable = false)
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Basic
    @Column(name = "card_no",length = 30, unique = true, nullable = false)
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
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
    @JoinColumn(name="cardholder_id")
    public User getCardholder() {
        return cardholder;
    }

    public void setCardholder(User cardholder) {
        this.cardholder = cardholder;
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
