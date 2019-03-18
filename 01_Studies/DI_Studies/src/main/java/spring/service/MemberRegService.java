package spring.service;

import spring.dao.MemberDao;

public class MemberRegService {
	// DI 패턴
//	MemberDao mdao = new MemberDao();
	MemberDao mdao;
	
	public MemberRegService() {}
	
	public MemberRegService(MemberDao dao) {
		this.mdao = dao;
	}
	
	public void setDao(MemberDao mdao) {
		this.mdao = mdao;
	}
	
	public void regMember() {
		System.out.println("RegService : regMember ");
		mdao.insert();
	}
}