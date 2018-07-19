package com.goebuy.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
//ElementType.CONSTRUCTOR 可以给构造方法进行注解
//ElementType.FIELD 可以给属性进行注解
//ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
//ElementType.METHOD 可以给方法进行注解
//ElementType.PACKAGE 可以给一个包进行注解
//ElementType.PARAMETER 可以给一个方法内的参数进行注解
//ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举

@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface SystemLog {


    /** 要执行的操作类型比如：add, update, get, find, delete, list 操作 **/  
    public String operationType() default "";  

    /** 要执行的具体操作比如：添加用户 **/  
    public String operationName() default ""; 
    
}