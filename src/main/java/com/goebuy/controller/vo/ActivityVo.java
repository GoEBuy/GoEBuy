package com.goebuy.controller.vo;

import com.goebuy.entity.event.ActivityCategory;
import com.goebuy.entity.user.Merchant;

/**
 * Created by luodejin on 2018/10/13.
 */
public class ActivityVo {

    /**
     * 基本信息
     */
    //活动id
    private int id;
    //活动标题
    private String name;
    //活动分类
    private ActivityCategory activityCate;
    //活动状态 ：0 未开始，1 进行中，2 已结束
    private int state;
    //活动时间
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    //报名时间
    private String enrollStartDate;
    private String enrollStartTime;
    private String enrollEndDate;
    private String enrollEndTime;
    //活动地点
    private int locationType;//活动地点类型：0 线下，1 自定义
    private String location;//活动地点
    //标签集合， 最多5个
    private String tagSet;
    //活动海报
    private String poster;
    //活动简介
    private String description;
    //展示报名类型: 0 展示报名用户影响力排行榜，1 展示报名用户，不显示报名用户
    private int enrollShowType;
    //报名后跳转到
    private int gotoPageType;//报名后跳转页面：0 邀请函页面，1 自定义页面，2 订单详情页面
    private String gotoPage; //报名后跳转页面
    //社群信息
    private String qq;//客服qq，已开启QQ通讯组件的QQ号码
    protected String phoneNo;//咨询电话
    private String gzQrcode;//公众号二维码

    /**
     * 售票信息
     */
    //售票类型：0 免费，1 收费（可设置多种票）
    private int ticketType;
    //报名限制 : 0 不限制， 1 每人限报一次
    private int enrollCnt;
    //余票显示
    private boolean showLeftTicket = true;
    //是否需要审核
    private boolean needVerify=false;
    //仅限会员
    private boolean needVip =false;

    /**
     * 表单信息
     */
    //填写字段
    private String fieldSet;


    /**
     * 分享信息
     */
    //分享标题
    private String shareTitle;
    //分享描述
    private String shareDesc;
    //分享图片
    private String shareImg;


    //活动链接地址
    private String url;
    //活动二维码图片
    protected String qrcode;


    //创建人
    private Merchant creator;
    //创建时间
    private String createTime;
    //最后一次更新时间
    private String updateTime;

}
