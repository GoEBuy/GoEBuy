package com.goebuy.biz.event;

import java.util.List;

import com.goebuy.params.Response;
import com.goebuy.utils.Numbers;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goebuy.entity.event.Activity;
import com.goebuy.service.event.ActivityService;

import javax.servlet.http.HttpServletRequest;

@Service
public class ActivityBiz {
	private static final Logger LOGGER = LoggerFactory.getLogger(ActivityBiz.class);

	@Autowired
	private ActivityService service;
	

	public Response save(Activity activity, HttpServletRequest request) {
//		Activity activity = new Activity();
//
//		/**
//		 * 基本信息
//		 */
//		//标题
//		activity.setName(request.getParameter("name"));
//		//所属商家
//		Merchant creator = new Merchant();
//		creator.setId(Numbers.safeParseInt(request.getParameter("merchantId")));
//		activity.setCreator(creator);
//		//活动分类
//		ActivityCategory cate = new ActivityCategory();
//		cate.setId(Numbers.safeParseInt(request.getParameter("activityCateId")));
//		activity.setActivityCate(cate);
//		//活动时间
//		activity.setStartDate(request.getParameter("startDate"));
//		activity.setStartTime(request.getParameter("startTime"));
//		activity.setEndDate(request.getParameter("endDate"));
//		activity.setEndTime(request.getParameter("endTime"));
//		//报名时间
//		activity.setEnrollStartDate(request.getParameter("enrollStartDate"));
//		activity.setEnrollStartTime(request.getParameter("enrollEndTime"));
//		activity.setEnrollEndDate(request.getParameter("enrollEndDate"));
//		activity.setEnrollEndTime(request.getParameter("enrollEndTime"));
//        //活动地点
//		activity.setLocationType(Numbers.safeParseInt(request.getParameter("locationType")));
//		activity.setLocation(request.getParameter("location"));
//		//活动标签
//		activity.setTagSet(request.getParameter("tagSet"));
//		//上传海报
//		activity.setPoster(request.getParameter("poster"));
//		//活动简介
//		activity.setDescription(request.getParameter("description"));
//		//报名展示类型
//		activity.setEnrollShowType(Numbers.safeParseInt(request.getParameter("showType")));
//		//报名后跳转到
//		activity.setGotoPageType(Numbers.safeParseInt(request.getParameter("gotoPageType")));
//		activity.setGotoPage(request.getParameter("gotoPageUrl"));
//		//社群信息
//		activity.setQq(request.getParameter("qq"));
//		activity.setPhoneNo(request.getParameter("phoneNo"));
//		activity.setGzQrcode(request.getParameter("gzQrcode"));//公众号二维码url
//
//		/**
//		 * 售票信息
//		 */
//		//售票类型
//		activity.setTicketType(Numbers.safeParseInt(request.getParameter("ticketType")));
//		//报名人数限制 默认不限制
//		activity.setEnrollCnt(Numbers.safeParseInt(request.getParameter("enrollCnt"), 0));
//		//余票显示
//		activity.setShowLeftTicket(Boolean.parseBoolean(request.getParameter("showLeftTicket")));
//		//是否需要审核
//		activity.setNeedVerify(Boolean.parseBoolean(request.getParameter("needVerify")));
//		//仅限会员
//		activity.setNeedVip(Boolean.parseBoolean(request.getParameter("needVip")));
//
//		/**
//		 * 表单信息
//		 */
//		activity.setFieldSet(request.getParameter("fieldSet"));
//
//		/**
//		 * 分享信息
//		 */
//		activity.setShareTitle(request.getParameter("shareTitle"));
//		activity.setShareDesc(request.getParameter("shareDesc"));
//		activity.setShareImg(request.getParameter("shareImg"));
//
//		//活动链接
//		activity.setUrl(request.getParameter("url"));
//		//活动二维码
//		activity.setQrcode(request.getParameter("qrcode"));
//
//		//发布人id
//		Merchant creator  = new Merchant();
//		creator.setId(Numbers.safeParseInt(request.getParameter("creatorId")));
//		activity.setCreator(creator);
//		//发布时间
//		activity.setCreateTime(request.getParameter("createTime"));

		service.save(activity);
		return Response.SUCCESS;
	}

	public Response delete(HttpServletRequest request) {
		if (Strings.isNullOrEmpty(request.getParameter("activityId"))) {
			return Response.BAD_PARAMETER;
		}
		service.deleteById(Numbers.safeParseInt(request.getParameter("activityId")));
		return Response.SUCCESS;
	}

	public Response detail(HttpServletRequest request) {
		if (Strings.isNullOrEmpty(request.getParameter("activityId"))) {
			return Response.BAD_PARAMETER;
		}
		Activity activity = service.findOne(Numbers.safeParseInt(request.getParameter("activityId")));
		return new Response(activity);
	}

	public Response list(HttpServletRequest request) {
		if (Strings.isNullOrEmpty(request.getParameter("merchantId"))) {
			return Response.BAD_PARAMETER;
		}
		int merchantId = Numbers.safeParseInt(request.getParameter("merchantId"));
		boolean deleted = Numbers.safeParseInt(request.getParameter("type")) == 1 ? true : false;
		List<Activity> activitys = service.findByCreatorAndDeleted(merchantId, deleted);
		return new Response(activitys);
	}

}
