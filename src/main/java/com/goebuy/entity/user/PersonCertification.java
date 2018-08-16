package com.goebuy.entity.user;

import com.goebuy.entity.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 个人账号认证
 *
 * Created by luodejin on 2018/8/15.
 */
@Entity
@Table(name = "person_certification", schema = "springdemo", indexes={@Index(name="name_index", columnList="name")}, catalog = "")
public class PersonCertification extends BaseEntity<Integer> {

    private static final long serialVersionUID = 5140177690535157826L;

    private String personNo;              //编号，系统生成
    private String name;                  //真实姓名
    private String idCardNo;              //身份证号码
    private String idCardFrontPic;        //身份证正面照
    private String idCardBackPic;         //身份证反面照
    private String phoneNumber;           //手机号码

    @Basic
    @Column(name = "person_no", nullable = false)
    public String getPersonNo() {
        return personNo;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
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
    @Column(name = "phone_number", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
