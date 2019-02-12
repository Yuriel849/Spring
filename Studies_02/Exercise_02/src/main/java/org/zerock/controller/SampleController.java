package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

@RestController // "@RestController" -> JSP 뷰를 만들지 않고 데이터(문자열, JSON, XML 등)를 반환한다.
@RequestMapping("/sample")
public class SampleController {
	@RequestMapping("/hello") // 단순 문자열 반환하기
	public String sayHello() {
		return "Hello World ";
	}
	
	@RequestMapping("/sendVO") // JSON으로 반환하기
	public SampleVO sendVO() {
		SampleVO vo = new SampleVO();
		vo.setFirstName("길동");
		vo.setLastName("홍");
		vo.setMno(123);
		
		return vo;
	}
	
	@RequestMapping("/sendList") // 컬렉션 타입 객체 List를 JSON으로 반환하기
	public List<SampleVO> sendList() {
		List<SampleVO> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			list.add(vo);
		}
		return list;
	}
	
	@RequestMapping("/sendMap") // 컬렉션 타입 객체 Map을 JSON으로 반환하기
	public Map<Integer, SampleVO> sendMap() {
		Map<Integer, SampleVO> map = new HashMap<>();
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			map.put(i, vo);
		}
		return map;
	}
	
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth() { // "ResponseEntity" class -> 개발자가 직접 결과 데이터 + HTTP상태코드(ex) 404)를 제어할 수 있는 클래스
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
							// HTTP 상태고드 400(bad request) 반환
	}
	
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendListNot() {
		List<SampleVO> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			list.add(vo);
		}
		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
						 // list와 함께 HTTP 상태코드 404(not found) 반환 -> 이런 사용법은 주로 에러의 원인 메시지를 전송할 때 사용!
	}
}
