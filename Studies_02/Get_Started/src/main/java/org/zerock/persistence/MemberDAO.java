package org.zerock.persistence;

import org.zerock.domain.MemberVO;

public interface MemberDAO {
	public String getTime(); // DB의 현재 시간을 확인한다.
	
	public void insertMember(MemberVO vo); // DB의 tbl_member 테이블에 데이터를 추가한다.
	
	public MemberVO readMember(String userid) throws Exception;
	
	public MemberVO readWithPW(String userid, String userpw) throws Exception;
}
