package com.yuriel.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuriel.service.Aes256;
import com.yuriel.service.Sha256;

@Controller
@RequestMapping("/security")
public class SecurityTestController {
	@Inject
	private Sha256 sha256;
	
	@Autowired
	private Aes256 aes256;
	
	@GetMapping // Supported in Spring ver. 4 or above -> automatically mapped to GET type requests
	public String form() {
		return "member/form";
	}
	
	@PostMapping // Supported in Spring ver. 4 or above -> automatically mapped to POST type requests
	public String login(
				@RequestParam("uid") String id,
				@RequestParam("upw") String pw
			) {
		System.out.println("Prior to encryption : " + id + " & " + pw);
		
		System.out.println("==============================================");
		System.out.println("ID after encryption : " + sha256.encrypt(id));
		System.out.println("PW after encryption : " + sha256.encrypt(pw));
		System.out.println("==============================================");
		
		try {
			String encid = aes256.encrypt(id);
			String encpw = aes256.encrypt(pw);

			System.out.println("AES-256 encrypted ID : " + encid);
			System.out.println("AES-256 encrypted PW : " + encpw);
			System.out.println("==============================================");

			System.out.println("AES-256 decrypted ID : " + aes256.decrypt(encid));
			System.out.println("AES-256 decrypted PW : " + aes256.decrypt(encpw));
			System.out.println("==============================================");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		
		return "member/login";
	}
	
	
}
