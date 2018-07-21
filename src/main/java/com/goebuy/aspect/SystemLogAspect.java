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

import com.goebuy.annotation.SystemLog;
import com.goebuy.entity.UserEntity;

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
//	@Value("${socket.time.out}")
//	private boolean saveSysLog;

	private String requestPath = null; // 请求地址
	private String loginName = ""; // 用户名
	private Map<?, ?> inputParamMap = null; // 传入参数
	private Map<String, Object> outputParamMap = null; // 存放输出结果
	private long startTimeMillis = 0; // 开始时间
	private long endTimeMillis = 0; // 结束时间
	private UserEntity user = null; // 操作用户
	private HttpServletRequest request = null;

	Object[] method_params = null;
	String methodName = null;
	String methodRemark = null;
	String packages = null;
	String operationType = "";
	String operationName = "";
	Class targetClass = null;
	String targetName = null;
	Method[] methods = null;
	// 注入Service用于把日志保存数据库
	@Autowired // 这里我用resource注解，一般用的是@Autowired，他们的区别如有时间我会在后面的博客中来写
//    private SystemLogService systemLogService;  

	private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

	// Controller层切点
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

		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();// .getAttribute(nae);
		for (String fString : requestAttributes.getAttributeNames(RequestAttributes.SCOPE_SESSION)) {
			System.out.println("session: " + fString);
		}

		for (String fString : requestAttributes.getAttributeNames(RequestAttributes.SCOPE_REQUEST)) {
			System.out.println("request: " + fString);
		}

		try {
			method_params = joinPoint.getArgs();
			methodName = joinPoint.getSignature().getName();
			methodRemark = getMthodRemark(joinPoint);
			packages = joinPoint.getThis().getClass().getName();
			if (packages.indexOf("$$EnhancerByCGLIB$$") > -1) { // 如果是CGLIB动态生成的类
				packages = packages.substring(0, packages.indexOf("$$"));
			}
			targetName = joinPoint.getTarget().getClass().getName();
			for (Object method_param : method_params) {
				System.out.println("parm:" + method_param);
			}
			Class targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();

			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					Class[] clazzs = method.getParameterTypes();
					if (clazzs!=null && clazzs.length == method_params.length) {
						SystemLog anno = method.getAnnotation(SystemLog.class);
						if(anno!=null) {
							operationType = anno.operationType();
							operationName = anno.operationName();
						}
						break;
					}
				}
			}
			System.out.println("请求方法:" + targetName + "." + methodName + "()" + "." + operationType);
			System.out.println("方法描述:" + operationName);
		} catch (Exception ex) {
			logger.error("获取方法信息失败");
			System.out.println("获取方法信息失败");
			ex.printStackTrace();
		}

		System.out.println("==========开始执行controller-around环绕通知===============");

		Object obj = null;

		try {
//			Request
//			System.out.println("method 0:" + method_params[0].getClass().getName());
//			HttpServletRequest request = (HttpServletRequest) method_params[0];
			// 记录方法开始执行的时间
			startTimeMillis = System.currentTimeMillis();
//			SystemLogEntity log = new SystemLogEntity();

			System.out.println("proceed " + joinPoint);
			logger.info("proceed " + joinPoint);

//			user = (UserEntity) request.getSession().getAttribute(SecurityConstant.CURRENT_LOGIN_USER);
//			if (user != null) {
//				loginName = user.getNickname();
//			} else {
//				loginName = "anon";
//			}
			String ip = getIp(request);

			System.out.println("args: " + Arrays.toString(method_params));

			// 执行方法
			obj = ((ProceedingJoinPoint) joinPoint).proceed();
//			if (obj != null) {
//				log.setResultMsg(obj.toString());
//			} else {
//				log.setResultMsg(null);
//			}
			endTimeMillis = System.currentTimeMillis();
			// 格式化开始时间
			String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTimeMillis);
			// 格式化结束时间
			String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endTimeMillis);

			if (logger.isInfoEnabled()) {
				System.out
						.println("around " + joinPoint + "\tUse time : " + (endTimeMillis - startTimeMillis) + " ms!");
				logger.info("around " + joinPoint + "\tUse time : " + (endTimeMillis - startTimeMillis) + " ms!");
			}

//			  /**
//			   * 用户操作
//	         */
//	        if("新增用户".equals(methodRemark)){
//	            HttpServletRequest req = (HttpServletRequest) method_params[0];
//	            log.setDescription("新增用户: 用户名为 " + req.getParameter("userName"));
//
//	        }else if("删除用户".equals(methodRemark)){
//	            String loginId = (String) method_params[1];
//	            log.setDescription("删除用户: 用户id为 " + loginId);
//	        }else if("修改用户".equals(methodRemark)){
//	            HttpServletRequest req = (HttpServletRequest) method_params[0];
//	            log.setDescription("修改用户: 用户名为 " + req.getParameter("loginName"));
//	        }

			System.out.println("==========结束执行controller-around环绕通知===============");

		} catch (Throwable e) {
			endTimeMillis = System.currentTimeMillis();
			if (logger.isInfoEnabled()) {
				System.out.println("around " + joinPoint + "\tUse time : " + (endTimeMillis - startTimeMillis)
						+ " ms with exception : " + e.getMessage());
				logger.info("around " + joinPoint + "\tUse time : " + (endTimeMillis - startTimeMillis)
						+ " ms with exception : " + e.getMessage());
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
//			System.out.println("请求方法:" + targetName + "." + methodName + "()" + "." + operationType);
//			System.out.println("方法描述:" + operationName);

//            System.out.println("请求人:" + user.getName());  
//            System.out.println("请求IP:" + ip);  
			// *========数据库日志=========*//
//            SystemLog log = new SystemLog();  
//            log.setId(UUID.randomUUID().toString());
//            log.setDescription(operationName);  
//            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
//            log.setLogType((long)0);  
//            log.setRequestIp(ip);  
//            log.setExceptioncode( null);  
//            log.setExceptionDetail( null);  
//            log.setParams( null);  
//            log.setCreateBy(user.getName());  
//            log.setCreateDate(new Date());  
//			if(saveSysLog) {
////            //保存数据库  
////            systemLogService.insert(log);  
//			}
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
			System.out.println("方法描述:" + operationName);
//            System.out.println("请求人:" + user.getName());  
//			System.out.println("请求IP:" + ip);
//			System.out.println("请求参数:" + params);
			/* ==========数据库日志========= */
//            SystemLog log = new SystemLog();
//            log.setId(UUID.randomUUID().toString());
//            log.setDescription(operationName);  
//            log.setExceptioncode(e.getClass().getName());  
//            log.setLogType((long)1);  
//            log.setExceptionDetail(e.getMessage());  
//            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));  
//            log.setParams(params);  
//            log.setCreateBy(user.getName());  
//            log.setCreateDate(new Date());  
//            log.setRequestIp(ip);  
//			if(saveSysLog) {
////            //保存数据库  
////            systemLogService.insert(log);  
//			}
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
	public static String getMthodRemark(JoinPoint joinPoint) {

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
						SystemLog methodCache = m.getAnnotation(SystemLog.class);
						if (methodCache != null) {
							methode = methodCache.operationName();
						}
						break;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return methode;
	}

	/**
	 * 获取请求ip
	 *
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		if (request == null) {
			return "none";
		}
		String ip = request.getHeader("X-Forwarded-For");
		if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip.substring(0, index);
			} else {
				return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr().equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

}