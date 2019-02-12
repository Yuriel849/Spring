package com.leopard.app.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leopard.app.model.Member;
import com.leopard.app.service.MemberRegService;

@Controller
public class MemberRegController {
	@Inject
 // @Autowired -> "@Inject"를 대신 사용!
	private MemberRegService service;
	
	@RequestMapping("/member/insert")
	public String insert() {
		int rcnt = service.insertMember(); // "MemberRegController" calls "MemberService" calls "MemberDao" goes to the DB and works its magic
		System.out.println(rcnt);
		
		return "member/insert";
	}
	
	@RequestMapping("/member/insertKey")
	public String insertMemberKey() {
		Member member = new Member();
		member.setEmail("dragon@heavenOrhell.com");
		member.setPassword("~!@!$%");
		member.setName("용");
		
		System.out.println(member);
		
		int rcnt = service.insertMemberKey(member); // "MemberRegController" calls "MemberService" calls "MemberDao" goes to the DB and works its magic
		
		System.out.println(rcnt);
		
		return "member/insert";
	}
}
