package com.goebuy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 授权拦截器，判断用户是否具有访问资源的权限
 * @author Administrator
 *
 */
public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String url = request.getRequestURI();

//		// 校验是否是公开资源地址
//		List<String> open_urls = ResourcesUtil.gekeyList("anonymousURL");

//		for (String open_url : open_urls) {
//			if (url.indexOf(open_url) >= 0) {
//				// 公开地址放行
//				return true;
//			}
//		}

//		//判断是否是公共访问地址
//		List<String> common_urls = ResourcesUtil.gekeyList("commonURL");

//		for (String common_url : common_urls) {
//			if (url.indexOf(common_url) >= 0) {
//				//公共地址放行
//				return true;
//			}
//		}

		HttpSession session = request.getSession();
//		ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
		// 获取用户权限列表
//		List<SysPermission> permission_list = activeUser.getPermissions();
		// 校验用户访问地址是否在用户权限范围内
//		for (SysPermission sysPermission : permission_list) {
//			String permission_url = sysPermission.getUrl();
//			if (url.contains(permission_url)) {
//				return true;
//			}
//		}

		// 跳转到拒绝访问的页面
//		request.getRequestDispatcher("/refuse.jsp").forward(
//				request, response);
//		return false;

		return true;

	}

	@Override

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

}
