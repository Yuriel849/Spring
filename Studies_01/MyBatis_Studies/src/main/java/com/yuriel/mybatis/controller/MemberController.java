package com.yuriel.mybatis.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuriel.mybatis.model.Member;
import com.yuriel.mybatis.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Inject
	private MemberService service;
	
	@RequestMapping("/reg")
	public String memberReg() {
		Member member = new Member();
		member.setEmail("black@white.org");
		member.setPassword("흑과 백");
		member.setName("qwerty");
		member.setPhoto("test-alt-011");
		System.out.println(member);
		
		int result = service.memberReg(member);
		System.out.println("result of operation is " + result);
		
		System.out.println("==============================");
		
		System.out.println(member);
		
		return "member/insert";
	}
	
	@RequestMapping("/view")
	public void selectById(Model model) {
		String email = "man@animal.org";
		
		Member member = service.selectById(email);
		System.out.println(member);
		
		model.addAttribute("result", member);
	}
	
	@RequestMapping("/list")
	public void selectList(Model model) {
		List<Member> members = service.selectList();
		model.addAttribute("result", members);
	}
}
