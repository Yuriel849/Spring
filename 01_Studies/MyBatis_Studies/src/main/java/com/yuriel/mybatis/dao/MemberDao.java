package com.yuriel.mybatis.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yuriel.mybatis.model.Member;

@Repository
public class MemberDao {
	@Inject
	private SqlSessionTemplate session;
	
	private static String namespace = "com.yuriel.mybatis.mapper.memberMapper";
	
	public int insertMember(Member member) {
		return session.insert(namespace + ".insertOne", member);
	}
	
	public Member selectById(String email) {
		return session.selectOne(namespace + ".selectOne", email);
	}
	
	public List<Member> selectList() {
		return session.selectList(namespace + ".selectList");
	}
}