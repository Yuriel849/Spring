package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice // "@ControllerAdvice" -> 해당 클래스의 객체를 controller에서 발생하는 exception 처리 전문 클래스로 지정!
public class CommonExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	// "@ExceptionHandler(Exception.class)" -> 해당 메서드는 Exception 타입의 모든 예외를 처리
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception e) {
		// "ModelAndView" -> 하나의 객체로 Model & View를 동시에 처리할 수 있는 객체
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception", e);
		
		return modelAndView;
	}
	
	
}
