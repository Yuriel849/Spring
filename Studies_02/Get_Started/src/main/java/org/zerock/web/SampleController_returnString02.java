package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController_returnString02 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController_returnString02.class);
	
	@RequestMapping("/doD")
	public String doD(Model model) { // "Model"은 Spring에서 제공하는 기본 클래스, view로 원하는 데이터를 전달할 때 사용하는 컨테이너 역할
		// 샘플 데이터 생성
		ProductVO product = new ProductVO("SampleProduct", 10000.55);
		
		logger.info("doD");
		
		model.addAttribute(product);
			// addAttribute(Object) -> 이름을 지정하지 않았다 -> 객체의 클래스명에서 첫글자를 소문자로 바꿔서 속성명으로 사용한다.
									  				// -> 여기서 속성명은 "productVO"
		
		return "productDetail"; // Spring은 "productDetail.jsp" 페이지를 찾아간다.
	}
}
