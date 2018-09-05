package com.goebuy.aspect;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.goebuy.annotation.SystemLogAnnotation;
import com.goebuy.biz.SystemLogBiz;
import com.goebuy.entity.SystemLog;
import com.goebuy.entity.user.User;
import com.goebuy.service.SysLogService;

/**
 * 切面类，记录用户操作日志
 * 
 * @author Administrator
 *
 */
@Aspect
@Component
public class SystemLogAspect {

	/**
	 * 从properties配置文件中获取配置信息
	 */
	@Value("${saveSysLog}")
	private boolean saveSysLog;

	@Autowired
	SystemLogBiz sysLogBiz;

	private String requestPath = null; // 请求地址
	private String loginName = ""; // 用户名
	private Map<?, ?> inputParamMap = null; // 传入参数
	private Map<String, Object> outputParamMap = null; // 存放输出结果
	private long startTimeMillis = 0; // 开始时间
	private long endTimeMillis = 0; // 结束时间
	private User user = null; // 操作用户
	private HttpServletRequest request = null;

	private String startTime = null, endTime = null;
	Object[] method_params = null;
	String methodName = null;
	SystemLogAnnotation sysLogAnnotation = null;
	String packages = null;
	String operationType = "";
	String operationName = "";
	Class targetClass = null;
	String targetName = null;
	Method[] methods = null;

	@Autowired
	private SysLogService systemLogService;

	private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

//	第一个*表示匹配任意的方法返回值，..(两个点)表示零个或多个，上面的第一个..表示service包及其子包,第二个*表示所有类,第三个*表示所有方法，第二个..表示
//	方法的任意参数个数
	@Pointcut("execution(* com.goebuy.controller..*.*(..))")
	public void controllerAspect() {
	}

	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 * 
	 * @param joinPoint 切点
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("==========执行controller-before前置通知===============");
		if (logger.isInfoEnabled()) {
			System.out.println("before " + joinPoint);
			logger.info("before " + joinPoint);
		}

	}

	// 配置controller环绕通知,使用在方法aspect()上注册的切入点
	@Around("controllerAspect()")
	public Object around(JoinPoint joinPoint) {

		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		try {
			ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)requestAttributes; 
			request = servletRequestAttributes.getRequest();
//			System.out.println("class name: " + method_params[0].getClass().getName());
//			request = (HttpServletRequest) method_params[0];
		} catch (Exception e) {
			logger.error("convert to request failed " + e.getMessage());
			System.err.println("convert to request failed " + e.getMessage());
		}
//		for (String fString : requestAttributes.getAttributeNames(RequestAttributes.SCOPE_SESSION)) {
//			System.out.println("session: " + fString);
//		}
//
//		for (String fString : requestAttributes.getAttributeNames(RequestAttributes.SCOPE_REQUEST)) {
//			System.out.println("request: " + fString);
//		}

		try {
			method_params = joinPoint.getArgs();
			methodName = joinPoint.getSignature().getName();
			sysLogAnnotation = getSystemLogAnnonation(joinPoint);
			if (sysLogAnnotation != null) {
				operationType = sysLogAnnotation.operationType();
				operationName = sysLogAnnotation.operationName();
			}
			packages = joinPoint.getThis().getClass().getName();
			if (packages.indexOf("$$EnhancerByCGLIB$$") > -1) { // 如果是CGLIB动态生成的类
				packages = packages.substring(0, packages.indexOf("$$"));
			}
			targetName = joinPoint.getTarget().getClass().getName();
			System.out.println("请求方法:" + targetName + "." + methodName + "()" );
//			System.out.println("方法描述:" + operationName );
			System.out.println("operationName: " + (operationName == null ? "null" : operationName) );
			System.out.println("operationType: " + ( operationType == null ? "null" : operationType ) );
			for (Object method_param : method_params) {
				System.out.println("参数个数:" + method_param);
			}
			System.out.println("请求参数: " + Arrays.toString(method_params));
			Class targetClass = Class.forName(targetName);

		} catch (Exception ex) {
			logger.error("获取方法信息失败");
			System.err.println("获取方法信息失败");
		}

		System.out.println("==========开始执行controller-around环绕通知===============");

		Object obj = null;
		SystemLog log = new SystemLog();

		// 记录方法开始执行的时间
		startTimeMillis = System.currentTimeMillis();
		// 格式化开始时间
		startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTimeMillis);

		log.setCreateDate(startTime);
		log.setLoginName(loginName);
		log.setMethod(methodName);
		log.setParams(Arrays.toString(method_params));
		log.setOperationName(operationName);
		log.setOperationType(operationType);
		
	

		System.out.println("执行切入点: " + joinPoint);
		logger.info("执行切入点 : " + joinPoint);

		if (request != null) {
//			if (request.getSession() != null) {
//				user = (User) request.getSession().getAttribute(SecurityConstant.CURRENT_LOGIN_USER);
//			}
		} else {
			System.out.println("request is null");
		}
		if (user != null) {
			loginName = user.getNickname();
		} else {
			loginName = "anon";
		}
		String ip = getIp(request);
		log.setRequestIp(ip);

		try {
			// 执行方法
			obj = ((ProceedingJoinPoint) joinPoint).proceed();
			if (obj != null) {
				if( obj.toString().length()> 100) {
					log.setResultMsg(obj.toString().substring(0,100));
				}else {
					log.setResultMsg(obj.toString());
				}
			} else {
				log.setResultMsg(null);
			}
			System.out.println("==========结束执行controller-around环绕通知===============");
			endTimeMillis = System.currentTimeMillis();
			// 格式化结束时间
			endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endTimeMillis);
			if (logger.isInfoEnabled()) {
				System.out
						.println("around " + joinPoint + "\tUse time : " + (endTimeMillis - startTimeMillis) + " ms!");
				logger.info("around " + joinPoint + "\tUse time : " + (endTimeMillis - startTimeMillis) + " ms!");
			}
		} catch (Throwable e) {
			System.err.println("执行方法" + methodName + " 失败");
			endTimeMillis = System.currentTimeMillis();
			if (logger.isInfoEnabled()) {
				System.out.println("around " + joinPoint + "\tUse time : " + (endTimeMillis - startTimeMillis)
						+ " ms with exception : " + e.getMessage());
				logger.info("around " + joinPoint + "\tUse time : " + (endTimeMillis - startTimeMillis)
						+ " ms with exception : " + e.getMessage());
			}
			log.setExceptioncode("1");
			log.setExceptionDetail(e.getMessage());
			return obj;
		}

		if (saveSysLog) {
			try {
				System.out.println("save log: "+ log);
				// 保存数据库
				sysLogBiz.saveAndFlush(log);
				System.out.println("save log succ");

			} catch (Exception e) {
				System.err.println("save log error: " + e.getMessage());
				logger.error("save log error: " + e.getMessage());
//				e.printStackTrace();
				return obj;
			}
		}

		return obj;
	}

	/**
	 * 后置通知 用于拦截Controller层记录用户的操作
	 * 
	 * @param joinPoint 切点
	 */
	@After("controllerAspect()")
	public void after(JoinPoint joinPoint) {

		try {
			// *========控制台输出=========*//
			System.out.println("=====controller-after后置通知开始=====");

			System.out.println("=====controller-after后置通知结束=====");
		} catch (Exception e) {
			// 记录本地异常日志
			logger.error("==后置通知异常==");
			logger.error("异常信息:{}", e.getMessage());
		}
	}

	// 配置后置返回通知,使用在方法aspect()上注册的切入点
	@AfterReturning("controllerAspect()")
	public void afterReturn(JoinPoint joinPoint) {
		System.out.println("=====执行controller-after后置返回通知=====");
		if (logger.isInfoEnabled()) {
			System.out.println("afterReturn " + joinPoint);
			logger.info("afterReturn " + joinPoint);
		}
	}

	/**
	 * 异常通知 用于拦截记录异常日志
	 * 
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
		String ip = "127.0.0.1";
		String params = "";
//         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {  
//             for ( int i = 0; i < joinPoint.getArgs().length; i++) {  
//                params += JsonUtil.getJsonStr(joinPoint.getArgs()[i]) + ";";  
//            }  
//        }  
		try {

			System.out.println("=====异常通知开始=====");
			System.out.println("异常代码:" + e.getClass().getName());
			System.out.println("异常信息:" + e.getMessage());
			System.out.println("异常方法:"
					+ (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")
					+ "." + operationType);
//			System.out.println("方法描述:" + operationName);
			/* ==========数据库日志========= */
			System.out.println("=====异常通知结束=====");
		} catch (Exception ex) {
			// 记录本地异常日志
			logger.error("==异常通知异常==");
			logger.error("异常信息:{}", ex.getMessage());
		}
		/* ==========记录本地异常日志========== */
		logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}",
				joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(),
				e.getMessage(), params);

	}

	/**
	 * 获取方法中的中文备注
	 *
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 */
	public static SystemLogAnnotation getSystemLogAnnonation(JoinPoint joinPoint) {

		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();

		Class targetClass = null;
		String methode = "";
		try {
			targetClass = Class.forName(targetName);

			Method[] method = targetClass.getMethods();
			for (Method m : method) {
				if (m.getName().equals(methodName)) {
					Class[] tmpCs = m.getParameterTypes();
					if (tmpCs.length == arguments.length) {
						SystemLogAnnotation methodCache = m.getAnnotation(SystemLogAnnotation.class);
						return methodCache;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取请求ip
	 *
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		String ip = request.getHeader("X-Forwarded-For");
		if (ip != null && !ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip.substring(0, index);
			} else {
				return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (ip != null && !ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr().equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

}