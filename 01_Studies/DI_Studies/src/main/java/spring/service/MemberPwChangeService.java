package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.dao.MemberDao;

public class MemberPwChangeService {
	@Autowired
	@Qualifier("another")
	MemberDao mdao;
	
	/*
	 * public MemberPwChangeService() {}
	 * 
	 * public MemberPwChangeService(MemberDao dao) { this.mdao = dao; }
	 * 
	 * public void setDao(MemberDao mdao) { this.mdao = mdao; }
	 */
	
	public void change() {
		System.out.println("PwChangeService : change ");
		mdao.change();
	}
}
