package spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.service.MemberPwChangeService;
import spring.service.MemberRegService;

public class SpringMain {
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) {
		// 컨테이너 생성 (설정파일은 appCtx.xml로 지정)
//		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		// 두 개 이상의 설정파일 사용하기
		String[] path = {"classpath:appCtx.xml", "classpath:appCtx2.xml"};
		ctx = new GenericXmlApplicationContext(path);
		
		MemberRegService regService = ctx.getBean("regService", MemberRegService.class);
		System.out.println("메인 메서드에서 입력 처리");
		regService.regMember();
		
		MemberPwChangeService changeService = ctx.getBean("changeService", MemberPwChangeService.class);
		System.out.println("메인 메서드에서 수정 처리");
		changeService.change();
		
		
		// !! SCOPE !!
		// scope="singleton" (default value of scope) 확인
		MemberRegService regService1 = ctx.getBean("regService", MemberRegService.class);
		MemberRegService regService2 = ctx.getBean("regService", MemberRegService.class);
		
		System.out.println("==========================================================");
		System.out.println("regService1 == regService2 :::: " + (regService1 == regService2 ? true : false));
		
		// scope="prototype" 확인
		MemberPwChangeService changeService3 = ctx.getBean("changeService", MemberPwChangeService.class);
		MemberPwChangeService changeService4 = ctx.getBean("changeService01", MemberPwChangeService.class);
		
		System.out.println("==========================================================");
		System.out.println("changeService3 == changeService4 :::: " + (changeService3 == changeService4 ? true : false));

	}
}
