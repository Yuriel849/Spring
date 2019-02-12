package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	// GET -> 항상 사용자가 직접 브라우저에서 접근 가능한 경우 사용한다.
	@RequestMapping(value ="/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
		logger.info("register get ............");
	}
	
	// POST -> 외부에서 많은 정보를 입력해야 하는 경우, 브라우저 주소창에 보여져서는 안 되는 정보를 전송할 때 사용한다.
	@RequestMapping(value = "/register", method = RequestMethod.POST)
				  // 매개변수 -> 입력하는 데이터를 BoardVO에서 수집하고, view까지 데이터를 보내야할 수도 있으니까 Model을 사용한다.
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("regist post ............");
		logger.info(board.toString());
		
		service.regist(board);
		
//		model.addAttribute("result", "success");
		rttr.addFlashAttribute("msg", "success");
		// RedirectAttributes 객체의 addFlashAttribute() 메서드는,
						  // 리디아렉트 시점에 한 번만 사용되는 데이터를 전송하는데 사용하며 URI에는 보이지 않는 숨겨진 데이터의 형태로 전달된다.
		
//		return "/board/success";
		return "redirect:/board/listAll"; // 사용자를 success 페이지로 보내는 대신 바로 목록 페이지로 redirect한다.
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list...............");
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
					// "@RequestParam("X")" -> request.getParameter("X")와 유사하게 작동한다.
										   // 외부(요청)에서 전달되는 매개변수라는 의미, 외부에서 전달되는 parameter의 이름은 "bno"로 지정
		model.addAttribute(service.read(bno));
			// model.addAttribute(value) -> 이름(name)을 지정하지 않았기에 해당 객체의 클래스명 첫글자를 소문자로 바꾼 후 이름으로 사용한다.
										// 여기서는 BoardVO 객체니까 "boardVO"라는 속성명을 사용한다.
	}
	
	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception {
		service.remove(bno);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(BoardVO board, Criteria cri, RedirectAttributes rttr) throws Exception {
		service.modify(board);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception {
		logger.info("show list page with criteria...............");
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
//		pageMaker.setTotalCount(10031);
		
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
}