package com.goebuy.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class CustomizePublisher implements ApplicationEventPublisherAware {

	@Autowired
   private ApplicationEventPublisher applicationEventPublisher;

   public void publish(MealEvent event) {
      applicationEventPublisher.publishEvent(event);
   }

   @Override
   public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
      this.applicationEventPublisher = applicationEventPublisher;
   }
}
