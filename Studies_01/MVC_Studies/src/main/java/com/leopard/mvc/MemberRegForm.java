package com.leopard.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberRegForm {
	@RequestMapping("/member/regForm")
	public String getRegForm(Model model) { // Dispatcher Servlet creates and sends the Model object
		model.addAttribute("title", "일반회원 가입하기");
		
		return "member/regForm"; // View Resolver에 의해 "/WEB-INF/views/member/regForm.jsp"로 변경된다!
	}
}
