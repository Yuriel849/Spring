package com.leopard.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.leopard.app.model.Member;


@Repository
public class MemberDao {
	@Inject
 // @Autowired -> "@Inject"를 대신 사용!
	private JdbcTemplate template;
	
	public int insertMember() {
		//		 JdbcTemplate.update() -> 반환값은 int형, number of rows affected
		return template.update("insert into test_member (email, password, name, photo) value (?, ?, ?, ?)",
									 "heaven@haven.net", "1234", "somebody", null); // 왼쪽에서 첫번째가 SQL문, 그 이후는 물음표 위치에 채워넣을 내용을 작성한다.
		//		  실제로 처리되는 SQL문 = insert into test_member (email, password, name, phone) value (home@haven.net, 1234, somebody, null)
	}
	
	// using the PreparedStatementCreator
	public int insertMemberKey(Member member) {		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		int resultCnt = template.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
						String sql = "insert into test_member (email, password, name, photo) value (?, ?, ?, ?)";
						
						PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"id"});
						pstmt.setString(1, member.getEmail());
						pstmt.setString(2, member.getPassword());
						pstmt.setString(3, member.getName());
						pstmt.setString(4, member.getPhoto());
						
						return pstmt;
					}
				}, keyHolder);
		
		Number keyValue = keyHolder.getKey();
		System.out.println("keyValue : " + keyValue);
		member.setId(keyValue.intValue());
		
		return resultCnt;
	}

	public Member selectByEmail(String email) {
		String sql = "select * from test_member where email = ?";
	 // List<Member> results = template.query(sql, new MemberRowMapper(), email);
	 // List<Member> results = template.query(sql, new Object[] {email}, new MemberRowMapper()); // another way of using JdbcTemplate.query()
		
		// 결과로 행 하나만 받는다.
		Member member = template.queryForObject(sql, new MemberRowMapper(), email);
		
		
	 // return results.isEmpty() ? null : results.get(0); // email은 "unique" constraint가 있기 때문에 중복 불가! -> query 결과 있거나 없거나!
		return member; // 만약 query 결과 반환값이 없으면 (0이면) EmptyResultDataAccessException 발생!
	}
}
