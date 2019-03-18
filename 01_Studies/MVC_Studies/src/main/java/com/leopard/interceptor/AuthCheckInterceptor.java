package com.leopard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		System.out.println("AuthCheckInterceptor called...............");
		
		if(session != null) { // 세션이 없을 경우를 대비한 null check
			Object authInfo = session.getAttribute("loginInfo");
			if(authInfo != null) { // 로그인정보가 세션에 없을 경우를 대비한 null check
				System.out.println("logged in status confirmed; proceeding...............");
				return true; // 해당 interceptor 실행 종료 -> 다음 interceptor OR controller 호출하여 실행!
			}
		}
		
		System.out.println("not logged in; proceeding to login...............");
		response.sendRedirect(request.getContextPath() + "/member/regForm"); // 로그인정보가 없으니까 로그인 페이지로 redirect
		
		return false; // 비정상 처리가 일어날 경우 "return false;"로 작업을 중단한다 (다른 interceptor OR controller 실행 안한다!)
	}
}
