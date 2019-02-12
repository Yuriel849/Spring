package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // "@Controller" -> 이 클래스를 컨트롤러로 지정한다.
public class SampleController_returnVoid {
	private static final Logger logger = LoggerFactory.getLogger(SampleController_returnVoid.class);
	
	@RequestMapping("doA") // "@RequestMapping("X") -> "X"라는 특정 URI에 매칭되는 클래스나 메서드로 지정한다.
	public void doA() {
		logger.info("doA called...............");
	}
	
	@RequestMapping("doB")
	public void doB() { // 리턴값이 void이기 때문에 Spring은 현재 경로에 해당하는 JSP 파일을 실행한다.
		logger.info("doB called...............");
	}
}