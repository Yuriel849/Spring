package spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.config.JavaConfig;
import spring.service.MemberPwChangeService;
import spring.service.MemberRegService;

public class SpringClassMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		MemberRegService regService = ctx.getBean("regService", MemberRegService.class);
		System.out.println("메인 메서드에서 입력 처리");
		regService.regMember();
		
		MemberPwChangeService changeService = ctx.getBean("changeService", MemberPwChangeService.class);
		System.out.println("메인 메서드에서 수정 처리");
		changeService.change();
		
	}
}
