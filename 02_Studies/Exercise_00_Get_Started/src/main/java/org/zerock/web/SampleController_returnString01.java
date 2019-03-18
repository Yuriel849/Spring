package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // "@Controller" -> 이 클래스를 컨트롤러로 지정한다.
public class SampleController_returnString01 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController_returnString01.class);
	
	@RequestMapping("doC") // "@RequestMapping("X") -> "X"라는 특정 URI에 매칭되는 클래스나 메서드로 지정한다.
	// 리턴값이 String이기 때문에 Spring은 반환되는 String + ".jsp" 파일을 실행한다.
	public String doC(@ModelAttribute("msg") String msg) {
		// @ModelAttribute("X") String 'Y' -> 메서드 호출 (요청) 시 'Y' 문자열 매개변수로 값을 받는다.
										   // 그리고 매개변수의 값을 "X"라는 이름의 파라미터로 model 객체에 저장해, 뷰에 전달하도록 지정한다.
		logger.info("doC called...............");
		return "result";
	}
}
