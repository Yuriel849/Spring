package com.leopard.mvc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	@RequestMapping("/cookie/makeCookie")
	public String makeCookie(HttpServletResponse response) {
		Cookie c = new Cookie("Auth", "1");
		response.addCookie(c);
		
		return "cookie/make";
	}
	
	@RequestMapping("/cookie/viewCookie")
	public String viewCookie(
			@CookieValue("Auth") String cookie,  // "Auth"라는 이름의 쿠키(가 있다면) 가져와 "cookie" 매개변수에 담는다.
			@CookieValue(value = "userid", defaultValue = "noID") String userid,
			Model model
		) {
		
		System.out.println(cookie);
		System.out.println(userid);
		
		model.addAttribute("result", "서버에서 받은 쿠키 정보 : " + cookie);
		
		return "cookie/view";
	}
}
