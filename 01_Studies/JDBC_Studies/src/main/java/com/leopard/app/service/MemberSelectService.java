package com.leopard.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leopard.app.dao.MemberDao;
import com.leopard.app.model.Member;

@Service
public class MemberSelectService {
	@Autowired
	private MemberDao dao;
	
	public Member selectByEmail(String email) {
		return dao.selectByEmail(email);
	}
}
