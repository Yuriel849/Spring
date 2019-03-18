package com.leopard.mvc;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello") // 확장자 없이 "localhost/mvc/hello"하면 바로 여기로 연결되도록 설정!
	public ModelAndView hello() {
		// ModelAndView는 컨트롤러의 처리결과를 보여줄 뷰(View)와 뷰에서 처리할 모델(Model)을 설정!
		ModelAndView mav = new ModelAndView();
		
		// view name 지정하기
		mav.setViewName("hi/hello"); // View Resolver에 의해 "/WEB-INF/views/hi/hello.jsp"로 변경된다!
			// mav.setView(View view) -> custom view 설정용!

		// view에서 보여줄 model 설정하기
		mav.addObject("id", "witch");
		mav.addObject("greeting", getGreeting());
		return mav;
	}
	
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(hour >= 6 && hour <= 10) {
			return "좋은 아침입니다.";
		} else if (hour >= 12 && hour <= 15) {
			return "점심 식사는 하셨나요?";
		} else if (hour >= 18 && hour <= 22) {
			return "좋은 밤 되세요.";
		}
		return "안녕하세요.";
	}
}
