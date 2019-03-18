package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // -> 스프링의 빈으로 인식되기 위한 설정
@Aspect    // -> 해당 클래스는 AOP 기능을 하는 클래스라고 지정
public class SampleAdvice {
	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
	
	// "@Before" -> target메서드 (괄호 속 조건에 부합하는 메서드) 실행하기 전에 @Before 메서드를 실행
				// 여기는 "org.zerock.service.MessageService"로 시작하는 모든 클래스의 모든 메서드가 target이다!
	@Before("execution(* org.zerock.service.MessageService*.*(..))") // "execution" -> Pointcut 지정, AspectJ 언어의 문법 사용
	public void startLog(JoinPoint jp) {
		logger.info("---------------------------------------------");
		logger.info("---------------------------------------------");
		logger.info(Arrays.toString(jp.getArgs())); // "JoinPoint getArgs()" -> 전달되는 모든 파라미터들을 Object 배열에 담아 반환
	}
	
	@Around("execution(* org.zerock.service.MessageService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable { // ProceedingJoinPoint의 proceed()는 Exception보다 상위의 Throwable을 예외처리해야!
		// "@Around" 사용 시 리턴타입은 반드시 Object로 지정해야 한다!
		long startTime = System.currentTimeMillis();
		logger.info(Arrays.toString(pjp.getArgs()));
		
		Object result = pjp.proceed(); // "@Around"가 target 메서드를 직접 호출!
		
		long endTime = System.currentTimeMillis();
		logger.info(pjp.getSignature().getName() + " :::: " + (endTime - startTime));
		logger.info("================================================");
		
		return result;
	}
}