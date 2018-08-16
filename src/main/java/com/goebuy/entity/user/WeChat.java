package com.goebuy.entity.user;

import com.goebuy.entity.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 微信表
 *
 * Created by luodejin on 2018/8/15.
 */
@Entity
@Table(name = "wechat", schema = "springdemo", indexes={@Index(name="nick_name_Index", columnList="nickName"),
        @Index(name="phone_number_Index", columnList="phoneNumber")}, catalog = "")
public class WeChat extends BaseEntity<Integer> {

    private static final long serialVersionUID = 5041676927291989777L;

    private String wechatNo;              //微信号
    private String phoneNumber;           //手机号码
    private String password;              //密码
    private String nickName;              //微信昵称
    private String headPicture;           //微信头像
    private String qrCode;                //二维码
    private int gender;                   //性别
    private String district;              //地区
    private String address;               //地址

    @Basic
    @Column(name = "wechat_no", nullable = false)
    public String getWechatNo() {
        return wechatNo;
    }

    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo;
    }

    @Basic
    @Column(name = "phone_number", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "password", nullable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nick_name", nullable = false)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "head_picture", nullable = true)
    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    @Basic
    @Column(name = "qr_code", nullable = true)
    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "district", nullable = true)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "address", nullable = true)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
