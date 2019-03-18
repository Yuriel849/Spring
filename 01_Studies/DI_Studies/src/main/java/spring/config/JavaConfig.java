package spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.service.MemberPwChangeService;
import spring.service.MemberRegService;

@Configuration // <context:component-scan>에게 해당 클래스는 빈 만들 내용을 담고 있다고 알리고, 자동으로 읽게 만든다!
public class JavaConfig {
	@Bean(name = "dao")
	@Qualifier("another")
	public MemberDao getDao() {
		return new MemberDao();
	}
	
	@Bean(name = "regService")
	public MemberRegService getMemberRegService() {
		return new MemberRegService(getDao());
		//							의존성 설정
	}
	
	@Bean(name = "changeService")
	public MemberPwChangeService getChangeService() {
		return new MemberPwChangeService();
	}
}
