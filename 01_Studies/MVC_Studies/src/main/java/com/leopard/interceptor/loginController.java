package com.leopard.interceptor;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {
	@RequestMapping("/member/login")
	public String login(HttpSession session) {
		session.setAttribute("loginInfo", "");
		
		return "member/login";
	}
}
