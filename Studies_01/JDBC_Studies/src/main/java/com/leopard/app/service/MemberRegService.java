package com.leopard.app.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.leopard.app.dao.MemberDao;
import com.leopard.app.model.Member;

@Service
public class MemberRegService {
	@Inject
 // @Autowired -> "@Inject"를 대신 사용!
	private MemberDao dao;
	
	public int insertMember() {
		return dao.insertMember();
	}
	
	public int insertMemberKey(Member member) {
		return dao.insertMemberKey(member);
	}
}
