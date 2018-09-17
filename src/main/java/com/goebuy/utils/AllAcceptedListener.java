package com.goebuy.utils;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AllAcceptedListener implements ApplicationListener<ApplicationEvent> {
   @Override
   public void onApplicationEvent(ApplicationEvent event) {
      System.out.println(">>>>>>>>>>>>>>>>event:" + event);
   }
}