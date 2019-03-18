package com.leopard.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/memberReg")
public class RegisterController {
	// 브라우저에 "localhost/member/memberReg" 입력하여 직접 접근할 때
	@RequestMapping(method = RequestMethod.GET)
	public String getForm(Model model, @RequestParam(value="no", required=false) Integer num) {
		// "@RequestParam("no") -> URL에서 GET방식으로 "no"라는 파라미터를 무조건 넣어야 한다!
		// "@RequestParam(value="no", required=false) int num" -> required=false이니까 없어도 되지만, 기본형은 null값으로 변환하지 못하니까 에러!
		// "@RequestParam(value="no", required=false) Integer num" -> 기본형 대신 wrapper타입 사용하면 문제 없다!
		
		System.out.println("@RequestParam('no') : " + num);
		
		// forwarding하기 때문에 브라우저에는 "member/memberReg" URI가 표시되지만 실제 페이지 내용물은 "member/regForm"이 출력된다.
		return "member/regForm"; 
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public ModelAndView memberReg(HttpServletRequest request) {
//		String uid = request.getParameter("uid");
//		String upw = request.getParameter("upw");
//		String uname = request.getParameter("uname");
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("member/memberReg");
//		mav.addObject("result", uid + " : " + upw + " : " + uname);
//		
//		return mav;
//	}
	
	// "localhost/member/memberReg"에서 regForm을 작성하여  POST방식으로 submit할 때
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView memberReg(
			HttpServletRequest request,
			@RequestParam(value = "uid", defaultValue="defaultUserID") String id,
			@RequestParam("upw") String pw,
			@RequestParam("uname") String name,
			Member member
		 // @ModelAttribute("mem") Member member -> 이렇게 사용하면 view 페이지에서는 "mem"이라는 이름으로 member 빈을 찾아야 한다!
			) {
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String uname = request.getParameter("uname");
		
		// 아래 3개의 프린트문은 모두 동일하다!
		System.out.println("From request : " + uid + " : " + upw + " : " + uname);
		System.out.println("From @RequestParam : " + id + " : " + pw + " : " + name);
		System.out.println("From Member : " + member);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/memberReg");
		mav.addObject("result", uid + " : " + upw + " : " + uname);
		mav.addObject("obj", id + " : " + pw + " : " + name);
	 // mav.addObject("member", member);
			/* 빈(bean, 객체)인 Member는 ModelAndView에 더하지 않아도, @ModelAttribute 사용하지 않아도 된다
			 * 		-> 매개변수로 받은 빈은 아무런 처리를 하지 않아도 view까지 전달된다!
			 */
		
		member.setUpic("사진없음"); // <- 이것은 view에서 볼 수 있다 == 여기서 사용하는 Member 빈은 view에서 참조하는 빈과 동일하다!
		
		return mav;
	}
}