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

@Entity
@Table(name = "user", schema = "springdemo", indexes={@Index(name="name_Index", columnList="name")}, catalog = "")
public class User extends BaseEntity<Integer> {
	
	private static final long serialVersionUID = -752197205289331832L;

    /**
     * 基本信息
     */
    private String nickname;              //昵称
    private String password;              //密码
    private String name;                  //真实姓名
    private String email;                 //邮箱
    private String phoneNo;               //手机号码
    private int gender;                   //性别
    private String address;               //地址
    private String birthday;              //生日

    /**
     * 附加信息
     */
    private String education;             //学历
    private String institution;           //就职单位或就读学校名称
    private String job;                   //担任职务或就读专业

//    private boolean isMerchant;           //是否是商户
    private Merchant merchant;            //关联的商户账号

    /**
     * 个人账号认证信息，非必须
     */
    private String idCardNo;              //身份证号码
    private String idCardFrontPic;        //身份证正面照
    private String idCardBackPic;         //身份证反面照

    /**
     * 微信信息
     */
    private String wechatNo;              //微信号
    private String wechatNickname;        //微信昵称
    private String wechatHeadPic;         //微信头像

    private String createTime;            //创建时间
    private String updateTime;            //最近更新时间

    private String ext;                   //扩展信息

    @Basic
    @Column(name = "nickname", nullable = true)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

//    @Basic
//    @Column(name = "is_merchant", nullable = true)
//    public boolean isMerchant() {
//        return isMerchant;
//    }
//
//    public void setMerchant(boolean merchant) {
//        isMerchant = merchant;
//    }

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @Basic
    @Column(name = "id_card_no", nullable = false)
    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    @Basic
    @Column(name = "id_card_front_pic", nullable = false)
    public String getIdCardFrontPic() {
        return idCardFrontPic;
    }

    public void setIdCardFrontPic(String idCardFrontPic) {
        this.idCardFrontPic = idCardFrontPic;
    }

    @Basic
    @Column(name = "id_card_back_pic", nullable = false)
    public String getIdCardBackPic() {
        return idCardBackPic;
    }

    public void setIdCardBackPic(String idCardBackPic) {
        this.idCardBackPic = idCardBackPic;
    }

    @Basic
    @Column(name = "wechat_no", nullable = false)
    public String getWechatNo() {
        return wechatNo;
    }

    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo;
    }

    @Basic
    @Column(name = "wechat_nickname", nullable = false)
    public String getWechatNickname() {
        return wechatNickname;
    }

    public void setWechatNickname(String wechatNickname) {
        this.wechatNickname = wechatNickname;
    }

    @Basic
    @Column(name = "wechat_head_pic", nullable = true)
    public String getWechatHeadPic() {
        return wechatHeadPic;
    }

    public void setWechatHeadPic(String wechatHeadPic) {
        this.wechatHeadPic = wechatHeadPic;
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
    @Column(name = "ext", nullable = true)
    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
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
