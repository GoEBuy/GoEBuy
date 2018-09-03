package com.goebuy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 处理biz层的异常
 * @author Administrator
 *
 */
@Aspect
@Component
public class BizExceptionAspect {
	
	
    private static final Logger logger = LoggerFactory.getLogger(BizExceptionAspect.class);

    /**
     * @within(org.springframework.stereotype.Service)，拦截带有 @Service 注解的类的所有方法
     * @annotation(org.springframework.web.bind.annotation.RequestMapping)，拦截带有@RquestMapping的注解方法
     */
//    @Pointcut("@within(org.springframework.stereotype.Service) && execution(public * *(..)) && execution(* com.goebuy.biz..*.*(..))")
    @Pointcut("execution(* com.goebuy.biz..*.*(..))")
    private void servicePointcut() {}

    /**
     * 拦截service层异常，记录异常日志，并设置对应的异常信息
     * 目前只拦截Exception，是否要拦截Error需再做考虑
     *
     * @param e 异常对象
     */
    @AfterThrowing(pointcut = "servicePointcut()", throwing = "e")
    public void AfterThrowing(JoinPoint point, Exception e) {
    	System.out.println("==========执行biz-before前置通知===============");
//        LOGGER.error(ExceptionUtils.getExcTrace(e));
    	System.out.println("异常信息: " + e.getMessage());
        String signature = point.getSignature().toString();
        String errorMsg = getMessage(signature) == null ? (StringUtils.isEmpty(e.getMessage()) ? "服务异常" : e.getMessage()) : getMessage(signature);
//        throw new ServiceException(errorMsg, e);
        throw new RuntimeException(e);
    }
    
    @Before("servicePointcut()")
	public void doBefore(JoinPoint joinPoint) {
    	System.out.println("==========执行biz-before前置通知===============");
		if (logger.isInfoEnabled()) {
			System.out.println("before " + joinPoint);
			logger.info("before " + joinPoint);
		}
    }
    
    /**
	 * 后置通知 用于拦截Controller层记录用户的操作
	 * 
	 * @param joinPoint 切点
	 */
	@After("servicePointcut()")
	public void after(JoinPoint joinPoint) {

		try {
			// *========控制台输出=========*//
			System.out.println("=====biz-after后置通知开始=====");

			System.out.println("=====biz-after后置通知结束=====");
		} catch (Exception e) {
			// 记录本地异常日志
			logger.error("==后置通知异常==");
			logger.error("异常信息:{}", e.getMessage());
		}
	}
	
	// 配置后置返回通知,使用在方法aspect()上注册的切入点
		@AfterReturning("servicePointcut()")
		public void afterReturn(JoinPoint joinPoint) {
			System.out.println("=====执行biz-after后置返回通知=====");
			if (logger.isInfoEnabled()) {
				System.out.println("afterReturn " + joinPoint);
				logger.info("afterReturn " + joinPoint);
			}
		}
		
		// 配置controller环绕通知,使用在方法aspect()上注册的切入点
		@Around("servicePointcut()")
		public Object around(JoinPoint joinPoint) throws Throwable {
			System.out.println("执行切入点: " + joinPoint);
			logger.info("执行切入点 : " + joinPoint);
			return  ((ProceedingJoinPoint) joinPoint).proceed();
		}

    /**
     * 获取方法签名对应的提示消息
     *
     * @param signature 方法签名
     * @return 提示消息
     */
    private String getMessage(String signature) {
        return null;
    }
}