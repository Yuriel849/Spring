package com.yuriel.customView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(
				Map<String, Object> model,
				HttpServletRequest request,
				HttpServletResponse response
			) throws Exception {
		File file = (File) model.get("downloadFile");
		
		response.setContentType("application/download; charset=UTF-8");
		response.setContentLength((int) file.length());
		
		String userAgent = request.getHeader("User-Agent");
		boolean ie = (userAgent.indexOf("MSIE") > -1) || (userAgent.indexOf("rv") > -1);
					// 해당 request가 IE(Internet Explorer) 브라우저에서 왔는지 확인한다 -> IE11 이전은 "MSIE", IE11은 "rv"
		String fileName = null;
		
		if(ie) { // MSIE일 때 처리
			fileName = URLEncoder.encode(file.getName(), "UTF-8");
		} else { // MSIE 외 브라우저일 때 처리
			fileName = new String(file.getName().getBytes("UTF-8"), "ISO-8859-1");
						// 만약 UTF-8 사용이 불가하다면 ISO-8859-1으로 대신 사용하도록 지정한다.
		}
		
		response.setHeader("Content-Disposition",
						   "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} finally { // fis를 사용 후 close하기 위해서 try-finally 사용한다.
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {}
			}
		}
	}
}
