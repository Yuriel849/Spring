package org.zerock.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("post handle............");
		
		// 컨트롤러로부터 오는 ModelAndView에서 Model을 꺼내고, 거기서 "result"라는 이름의 변수 값을 찾는다.
		Object result = modelAndView.getModel().get("result");
		
		if(result != null) {
			request.getSession().setAttribute("result", result);
			response.sendRedirect("/doA");
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//																			  "Object handler" -> 지금 실행하려는 메서드 그 자체를 지칭!
		System.out.println("pre handle............");
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		System.out.println("Bean : " + method.getBean()); // 지금 실행하려는 빈 반환 받아 출력 -> InterceptorTestController
		System.out.println("Method : " + methodObj); // 지금 실행하려는 메서드 반환 받아 출력 -> InterceptorTestController의 doB()
		
		return true;
	}
}
