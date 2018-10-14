package com.goebuy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goebuy.utils.DemoTask;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {
    
    @Autowired
    TaskScheduler scheduler;
    
    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public void start() {
        scheduler.schedule(new DemoTask(), new CronTrigger("0/5 * * * * *"));
    }

}