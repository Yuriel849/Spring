package com.leopard.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageController {
	@RequestMapping("/interceptor/mypage1")
	public String getMypage1() {
		return "interceptor/view";
	}
	
	@RequestMapping("/interceptor/mypage2")
	public String getMypage2() {
		return "interceptor/view";
	}
}
