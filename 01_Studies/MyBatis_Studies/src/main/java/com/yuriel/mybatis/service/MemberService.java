package com.yuriel.mybatis.service;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.yuriel.mybatis.dao.MemDao;
import com.yuriel.mybatis.model.Member;

@Service
public class MemberService {
	/*
	 * @Autowired private MemberDao dao;
	 * 
	 * public int memberReg(Member member) { return dao.insertMember(member); }
	 * 
	 * public Member selectById(String email) { return dao.selectById(email); }
	 * 
	 * public List<Member> selectList() { return dao.selectList(); }
	 */
	
	@Inject
	private SqlSessionTemplate template;
	
	// 인터페이스 사용하기
	private MemDao dao;
	
	public int memberReg(Member member) {
		dao = template.getMapper(MemDao.class);
		return dao.insertMember(member);
	}
	
	public Member selectById(String email) {
		dao = template.getMapper(MemDao.class);
		return dao.selectById(email);
	}
	
	public List<Member> selectList() {
		dao = template.getMapper(MemDao.class);
		return dao.selectList();
	}
}
