package com.leopard.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {
	@RequestMapping("search/searchForm")
	public String searchForm(Model model) {		
		return "search/form";		
	}
	
	@ModelAttribute("pkeyword")
	public String[] searchType() {		
		return new String[] {"java", "javascript", "Mysql", "Spring"};
	}
	
	@ModelAttribute("searchType")
	public List<SearchType> getSearchType(){
		List<SearchType> list = new ArrayList<SearchType>();
		list.add(new SearchType("제목", "title"));
		list.add(new SearchType("작성자", "writer"));
		list.add(new SearchType("내용", "content"));
		list.add(new SearchType("제목+내용", "all"));
		
		return list;		
	}	
}