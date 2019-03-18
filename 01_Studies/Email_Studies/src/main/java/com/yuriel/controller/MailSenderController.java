package com.yuriel.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuriel.domain.Member;
import com.yuriel.service.MailSendService;
import com.yuriel.service.MimeMailSendService;

@Controller
public class MailSenderController {
	@Inject
	public MailSendService simpService;
	
	@Inject
	public MimeMailSendService mimeService;
	
	@RequestMapping("/mail/simpleMailSend")
	public String simpleMailSend() {
		Member m = new Member();
		m.setEmail("valkyria1@naver.com");
		
		simpService.sendMail(m, "[Simple] 회원 가입 안내", "회원 가입을 환영합니다. 이 메일은 테스트용으로 발송했습니다. 좋은 하루 보내세요.");
		
		return "mail/mail";
	}
	
	@RequestMapping("/mail/mimeMailSend")
	public String mimeMailSend() {
		mimeService.sendMimeMail("valkyria1@naver.com");

		return "mail/mail";
	}
	
	@RequestMapping("/mail/mimeAttachment")
	public String mimeFileSend() {
		mimeService.sendFileMail("valkyria1@naver.com", "발큐리");

		return "mail/mail";
	}
}
