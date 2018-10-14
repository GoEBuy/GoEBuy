package com.goebuy.controller;

import com.goebuy.biz.event.ActivityBiz;
import com.goebuy.entity.event.Activity;
import com.goebuy.params.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by luodejin on 2018/9/28.
 */
@RestController
@RequestMapping("/activity")
@Api(value = "活动接口", description="活动相关操作")
public class ActivityController {

    @Autowired
    private ActivityBiz activityBiz;

    @PostMapping("/submit")
    @ApiOperation(value = "发布活动", notes = "发布活动", tags = {})
    public Response save(@RequestBody Activity activity, HttpServletRequest request) throws Exception {
        return activityBiz.save(activity, request);
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除活动", notes = "删除活动", tags = {})
    public Response delete(HttpServletRequest request) throws Exception {
        return activityBiz.delete(request);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "获取活动详情", notes = "获取活动详情", tags = {})
    public Response<Activity> detail(HttpServletRequest request) throws Exception {
        return activityBiz.detail(request);
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取活动列表", notes = "获取活动列表", tags = {})
    public Response<List<Activity>> list(HttpServletRequest request) throws Exception {
        return activityBiz.list(request);
    }

}
