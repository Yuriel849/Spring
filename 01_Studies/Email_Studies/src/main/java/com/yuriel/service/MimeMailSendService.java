package com.yuriel.service;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

// A message sending html code
@Service
public class MimeMailSendService {
	@Inject
	private JavaMailSender javaMailSender;
		// DI of the "mailSender" (JavaMailSenderImpl class) bean created in servlet-context.xml
	
	public void sendMimeMail(String recipient) {
		// 메일 내용 설정
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			// 제목 설정
			message.setSubject("[공지] 회원 가입 안내", "UTF-8"); // encode the message with the specified charset (UTF-8)

			// 내용 설정
			String htmlContent = "<h1>\r\n Hello world!\r\n </h1>\r\n" +
					"<ul>\r\n <li><a href=\"https://www.nytimes.com\">Visit the NY Times</a></li>\r\n" + 
					"<li><a href=\"http://localhost/email\">See your mail</a></li>\r\n</ul>";
			message.setText(htmlContent, "UTF-8", "html");
				// encode the message with the specified charset (UTF-8), the message is also declared to be html code
			
			// 받는 이메일 설정
			message.addRecipient(RecipientType.TO, new InternetAddress(recipient));
							  /* RecipientType
							   * 	TO (primary)
							   * 	CC (carbon copy)
							   * 	BCC (blind carbon copy)
							   */
			
			// 이메일 보내기
			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendFileMail(String recipient, String name) {
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					message, // 메일 메시지를 구성하는데 사용할 MimeMessage 객체
					true, // MultiPart 여부 설정
					"UTF-8"); // 사용할 encoding 설정
			
			// 메일의 이름 설정
			messageHelper.setSubject("[공지] 선물용 파일 발송");
			// 메일의 내용 설정
			messageHelper.setText("<h1>선물</h1><hr><br>받아가세요~", true); // use HTML? == true 설정
			// 메일의 수신자 설정
			messageHelper.setTo(new InternetAddress(recipient, name, "UTF-8"));
			// 파일을 메일에 첨부
			DataSource dataSource = new FileDataSource("c:\\MIME mail test.txt");
			messageHelper.addAttachment(MimeUtility.encodeText("첨부파일 테스트용 파일.txt", "UTF-8", "B"), dataSource);
					   // addAttachment(attachment name as it will appear, source of actual file)
			// 메일 발송
			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}