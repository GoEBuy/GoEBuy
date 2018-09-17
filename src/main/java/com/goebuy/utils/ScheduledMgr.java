//package com.goebuy.utils;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.goebuy.controller.UserController;
//
///**
// * @title ScheduledTasks
// * @description 使用@Scheduler注解调度任务范例
// */
//@Component
//public class ScheduledMgr {
//	
//	private static final  Logger logger = LoggerFactory.getLogger(UserController.class);
//
//	
//    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    public ScheduledMgr() {
//        logger.info("ScheduledMgr Current time: {}", dateFormat.format(new Date()));
//    }
//
//    /**
//     * fixedDelay属性定义调度间隔时间。调度需要等待上一次调度执行完成。
//     */
//    @Scheduled(fixedDelay = 5000)
//    public void testFixedDelay() throws Exception {
//        Thread.sleep(6000);
//        logger.info("testFixedDelay Current time: {}", dateFormat.format(new Date()));
//    }
//
//    /**
//     * fixedRate属性定义调度间隔时间。调度不等待上一次调度执行完成。
//     */
//    @Scheduled(fixedRate = 5000)
//    public void testFixedRate() throws Exception {
//        Thread.sleep(6000);
//        logger.info("testFixedRate Current time: {}", dateFormat.format(new Date()));
//    }
//
//    /**
//     * initialDelay属性定义初始化后的启动延迟时间
//     */
//    @Scheduled(initialDelay = 1000, fixedRate = 5000)
//    public void testInitialDelay() throws Exception {
//        Thread.sleep(6000);
//        logger.info("testInitialDelay Current time: {}", dateFormat.format(new Date()));
//    }
//
//    /**
//     * cron属性支持使用cron表达式定义触发条件
//     */
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void testCron() throws Exception {
//        Thread.sleep(6000);
//        logger.info("testCron Current time: {}", dateFormat.format(new Date()));
//    }
//}