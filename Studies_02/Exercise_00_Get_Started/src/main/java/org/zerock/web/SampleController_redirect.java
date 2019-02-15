package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController_redirect {
	private static final Logger logger = LoggerFactory.getLogger(SampleController_redirect.class);
	
	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr) { // RedirectAttributes 클래스 사용 시 URI에는 보이지 않게 데이터 전달 가능
		logger.info("doE called but redirected to /doF.........");
		
		rttr.addFlashAttribute("msg", "This is the message(msg)!! There has been a redirect!!");
		
		return "redirect:/doF";
	}
	
	@RequestMapping("/doF")
	public void doF(@ModelAttribute String msg) {
		logger.info("doF called............" + msg);
	}
}
