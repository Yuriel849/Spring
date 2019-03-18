package com.yuriel.mybatis.dao;

import java.util.List;

import com.yuriel.mybatis.model.Member;

public interface MemDao {
	// namespace 설정 -> namespace는 인터페이스의 full name
	String namespace = "com.yuriel.mybatis.dao.MemDAO";
	
	// Mapper ID -> 메서드의 이름 -> insertMember
	public int insertMember(Member member);
	
	// Mapper ID -> 메서드의 이름 -> selectById
	public Member selectById(String email);
	
	// Mapper ID -> 메서드의 이름 -> selectList
	public List<Member> selectList();
}
