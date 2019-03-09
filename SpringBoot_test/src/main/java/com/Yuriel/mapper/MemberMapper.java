package com.Yuriel.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.Yuriel.domain.MemberVO;

public interface MemberMapper {
	
	@Insert("insert into tbl_member (userid, userpw, username, email) "
			+ "values (#{userid}, #{userpw}, #{username}, #{email}) ")
	public void create(MemberVO vo) throws Exception;
	
	@Select("select * from tbl_member where userid = #{userid}")
	public MemberVO read(String userid) throws Exception;
	
	@Update("update tbl_member set "
			+ "userpw = #{userpw}, username = #{username}, email = #{email} "
			+ "where userid = #{userid}")
	public void update(MemberVO vo) throws Exception;
	
	@Delete("delete from tbl_member where userid = #{userid}")
	public void delete(String userid) throws Exception;
	
	// Binds with XML mapper file (src/main/resources/mapper/memberMapper.xml)
	public MemberVO login(@Param("userid") String userid, @Param("userpw") String userpw) throws Exception;
}
