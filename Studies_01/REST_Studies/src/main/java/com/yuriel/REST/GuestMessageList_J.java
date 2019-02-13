package com.yuriel.REST;

import java.util.List;

public class GuestMessageList_J {
	private List<GuestMessage> messages; // 반환되는 JSON의 키, 값은 messages의 실제 값인 list
	
	// constructors
	public GuestMessageList_J() {}
	
	public GuestMessageList_J(List<GuestMessage> messages) {
		this.messages = messages;
	}

	// getter
	public List<GuestMessage> getMessages() {
		return messages;
	}
}