package com.goebuy.entity.user;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * VIP表
 *
 * Created by luodejin on 2018/8/16.
 */
@Entity
@Table(name = "vip", schema = "springdemo", indexes={@Index(name="bank_card_number_Index", columnList="bankCardNo")}, catalog = "")
public class VIP {

    private String vipNo;                 //会员卡编号
    private int vipType;                  //会员卡类型
    private int vipName;                  //会员卡名称
    private int fee;                      //费用
    private int privilege;                //特权
    private int description;              //描述信息


    private int duration;                 //使用期限
    private int start_time;               //会员卡有效期开始时间
    private int end_time;                 //会员卡有效期结束时间

}
