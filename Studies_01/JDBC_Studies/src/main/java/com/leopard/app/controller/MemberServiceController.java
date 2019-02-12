package com.leopard.app.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leopard.app.model.Member;
import com.leopard.app.service.MemberSelectService;

@Controller
public class MemberServiceController {
	@Inject
	private MemberSelectService service;
	
	@RequestMapping("/member/view")
	public String getMember(Model model) {
		String email = "home@haven.net";
		Member member = service.selectByEmail(email);
		model.addAttribute("result", member);
		
		return "member/view";
	}
}
