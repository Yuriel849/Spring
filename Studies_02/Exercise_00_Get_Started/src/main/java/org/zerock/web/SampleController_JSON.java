package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController_JSON {
	@RequestMapping("/doJSON")
	// 리턴타입 앞에 "@ResponseBody" 애너테이션을 추가하는 것만으로 반환된 객체는 JSON 데이터로 생성된다.
	public @ResponseBody ProductVO doJSON() {
		ProductVO vo = new ProductVO("샘플상품", 30000);
		return vo;
	}
}
