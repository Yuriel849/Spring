package com.yuriel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.yuriel.domain.PageRanks;

@Controller
@RequestMapping("/download/*")
public class DownloadController implements ApplicationContextAware {
	private WebApplicationContext context;
	
	@RequestMapping("/file")
	public ModelAndView download() throws Exception {
		File file = getFile();
		
		// ModelAndView(view 커스텀 뷰 이름, modelName 뷰로 전달할 데이터 이름, modelObject 실제로 뷰로 전달할 데이터)
		return new ModelAndView("download", "downloadFile", file);
	}
	
	private File getFile() {
		String path = context.getServletContext().getRealPath("/WEB-INF/downloadNotice.txt");
		return new File(path);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}
	
	@RequestMapping("/excel")
	public ModelAndView getRanksXls() {
		List<PageRanks> pageRanks = new ArrayList<PageRanks>();
		pageRanks.add(new PageRanks(1,  "https://www.naver.com"));
		pageRanks.add(new PageRanks(2,  "https://www.daum.com"));
		pageRanks.add(new PageRanks(3,  "https://www.nate.com"));
		
		return new ModelAndView("pageRanks", "pageRanks", pageRanks);
	}
	
	@RequestMapping("/pdf")
	public ModelAndView getRanksPdf() {
		List<PageRanks> pageRanks = new ArrayList<PageRanks>();
		pageRanks.add(new PageRanks(1,  "https://www.naver.com"));
		pageRanks.add(new PageRanks(2,  "https://www.daum.com"));
		pageRanks.add(new PageRanks(3,  "https://www.nate.com"));
		
		return new ModelAndView("pageRanksPdf", "pageRanks", pageRanks);
	}
}