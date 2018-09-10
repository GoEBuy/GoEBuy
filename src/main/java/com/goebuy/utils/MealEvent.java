package com.goebuy.utils;

import org.springframework.context.ApplicationEvent;

public class MealEvent extends ApplicationEvent {

	   private String mealEnum;

	   /**
	    * @param mealContent
	    *        吃什么
	    * @param mealEnum
	    *        早餐还是午餐？
	    */
	   public MealEvent(String mealContent, String mealEnum) {
	      super(mealContent);
	      this.mealEnum = mealEnum;
	   }

	   public String getMealEnum() {
	      return mealEnum;
	   }
	}