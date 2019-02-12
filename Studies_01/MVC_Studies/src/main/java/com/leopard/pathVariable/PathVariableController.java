package com.leopard.pathVariable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableController {
// URL to match : https://localhost/mvc/guest/10
	@RequestMapping("/guest/{id}")
	public String getGuestMessage(@PathVariable("id") int guestID, Model model) {
		// 제대로 작동하는지 테스트
		System.out.println(guestID);
		
		model.addAttribute("id", guestID);
		
		return "guest/view";
	}
	
}
