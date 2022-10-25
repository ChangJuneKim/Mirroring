package com.ssafy.ws.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.ws.model.dto.User;

//@SuppressWarnings("deprecation")
//public class ConfirmInterceptor extends HandlerInterceptorAdapter {
// spring 5.3 부터는 HandlerInterceptor implements

@Component
public class SessionInterceptor implements HandlerInterceptor { 

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/index");
			return false; // 컨트롤러에게 요청 정보를 전달하지 않고 끝낸다
		}
		return true; // 컨트롤러에게 요청 정보를 그대로 전달한다
	}
	
}
