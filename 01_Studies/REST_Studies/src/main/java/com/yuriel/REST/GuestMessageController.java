package com.yuriel.REST;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/guest")
public class GuestMessageController {
	@RequestMapping(value = "/message/list.xml")
	@ResponseBody // 메서드 반환값인 "GuestMessageList" 타입을 응답 데이터로 인식하여 전달한다!
	public GuestMessageList listXml() { // "public @ResponseBody GuestMessageList listXml()" -> also possible!
		return getMessageList();
	}
	
	@RequestMapping(value = "/message/list.json")
	public @ResponseBody GuestMessageList_J listJson() {
		return getMessageList_J();
	}
	
	private GuestMessageList getMessageList() {
		List<GuestMessage> messages = Arrays.asList(
					new GuestMessage(1, "메세지", new Date()),
					new GuestMessage(2, "메세지 02", new Date())
				);
		return new GuestMessageList(messages);
	}
	
	private GuestMessageList_J getMessageList_J() {
		List<GuestMessage> messages = Arrays.asList(
					new GuestMessage(1, "메세지", new Date()),
					new GuestMessage(2, "메세지 02", new Date())
				);
		return new GuestMessageList_J(messages);
	}
	
	@RequestMapping("/form")
	public String getForm() {
		return "form";
	}
}
