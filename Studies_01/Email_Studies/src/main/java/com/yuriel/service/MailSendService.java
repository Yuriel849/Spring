package com.yuriel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.yuriel.domain.Member;

// A simple successful signup notifier
@Service
public class MailSendService {
	@Autowired
	private MailSender mailSender;
		// DI of the "mailSender" (JavaMailSenderImpl class) bean created in servlet-context.xml
	 
	public void sendMail(Member member, String title, String msg) {
		// 메일 내용 설정
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject(title); // set the title of the email
		message.setText(msg); // set the content of the email
		message.setFrom("test@gmail.com"); // set the sender of the email
					  /* BUT THE GMAIL SERVER FILTERS REQUESTS TO SEND MAIL FROM A GMAIL ACCOUNT,
					   * 	AND THE ACTUAL SENDER (as appears to the recipient) IS THE SENDER SPECIFIED
					   * 	IN THE "mailSender" BEAN IN SERVLET-CONTEXT.XML! */
		message.setTo(member.getEmail()); // set the recipient of the email
		
		// 메일 발송 시도
		try {
			mailSender.send(message);
			/* Can only accept SimpleMailMessage type objects,
			 * 		although the actual object is the JavaMailSenderImpl type,
			 * 		the variable is the MailSender type which only accepts SimpleMailMessage type arguments.
			 */
		} catch (MailException ex) {
			ex.printStackTrace();
		}
	}

	public void sendMail(String memberemail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[Simple] 회원 가입 안내");
		message.setFrom("isisncorp@gmail.com");
		message.setText("회원 가입을 환영합니다.");
		message.setTo(memberemail);
		
		try {
			mailSender.send(message);
		} catch (MailException ex) {
			ex.printStackTrace();
		}
	}
}