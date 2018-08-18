package com.goebuy.entity.user;

import com.goebuy.entity.BaseEntity;
import com.goebuy.entity.event.BlogEntity;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "springdemo", indexes={@Index(name="name_Index", columnList="name")}, catalog = "")
public class User extends BaseEntity<Integer> {
	
	private static final long serialVersionUID = -752197205289331832L;

    /**
     * 基本信息
     */
    private String userId;                //用户id
    private String name;                  //姓名
    private String email;                 //邮箱
    private String phoneNo;               //手机号码
    private WeChat weChat;                //微信
    private int gender;                   //性别
    private String address;               //地址
    private String birthday;              //生日

    /**
     * 附加信息
     */
    private String education;             //学历
    private String institution;           //就职单位或就读学校名称
    private String job;                   //担任职务或就读专业
    private String ext;                   //扩展信息

    /**
     * 认证信息，非必须
     */
    private PersonCertification personCertification;   //认证信息

    @Basic
    @Column(name = "user_id", nullable = false)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name", nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone_no", nullable = true)
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Basic
    @Column(name = "wechat", nullable = true)
    public WeChat getWeChat() {
        return weChat;
    }

    public void setWeChat(WeChat weChat) {
        this.weChat = weChat;
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
    @Column(name = "address", nullable = true)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "education", nullable = true)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "institution", nullable = true)
    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Basic
    @Column(name = "job", nullable = true)
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Basic
    @Column(name = "ext", nullable = true)
    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public PersonCertification getPersonCertification() {
        return personCertification;
    }

    public void setPersonCertification(PersonCertification personCertification) {
        this.personCertification = personCertification;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User that = (User) o;
//
//        if (id != that.id) return false;
//        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
//        if (password != null ? !password.equals(that.password) : that.password != null) return false;
//        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
//        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
//        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//        return result;
//    }

}
