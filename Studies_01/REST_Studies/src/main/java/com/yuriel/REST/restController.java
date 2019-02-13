package com.yuriel.REST;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class restController {
	@GetMapping("/msgs/{id}")
	public String sayHello(@PathVariable("id") String id) {
		return "Hello World, " + id; // @RestController annotation 때문에 반환하는 문자열을 view 이름이 아닌 단순 문자열로 취급한다.
	}
	
	@GetMapping("/msgs/id/{num}")
	public GuestMessage getMessage(@PathVariable("num") Integer num) {
		return new GuestMessage(num, "안녕~ 뭐해~?", new Date());
	}

	@GetMapping("/msgs")
	public GuestMessageList_J getMessageList() {
		List<GuestMessage> messages = Arrays.asList(
				new GuestMessage(1, "메세지", new Date()),
				new GuestMessage(2, "메세지 02", new Date())
			);
		return new GuestMessageList_J(messages);
	}
	
	@PostMapping("/msgs")
	public GuestMessage postMessage(@RequestBody GuestMessage message) { // @RequestBody -> 
		message.setMessage(message.getMessage() + " - append data");
		System.out.println(message);
		message.setCreationTime(new Date());
		return message;
	}
}
