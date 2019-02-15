package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 현재 테스트 코드가 Spring을 실행할 것을 알림
@ContextConfiguration(classes = { RootConfig.class }) // 지정된 클래스나 문자열을 이용해서 Spring bean을 등록
@Log4j // Lombok을 이용해서 로그를 기록하는 Logger 변수 생성 (별도의 Logger 객체 선언 불필요)
public class SampleTests {

	@Setter(onMethod_ = { @Autowired } )
	private Restaurant restaurant;
	
	@Test // JUnit 테스트 대상을 지정
	public void testExist() {
		assertNotNull(restaurant); // 지정된 객체가 널이면 예외 발생
		
		log.info(restaurant);
		log.info("----------------------------------------");
		log.info(restaurant.getChef());
	}
}
