package com.leopard.mvc;

import org.springframework.web.multipart.MultipartFile;

public class Report {	
	private String sno;
	private MultipartFile report;
	
	@Override
	public String toString() {
		return "Report [sno=" + sno + ", report=" + report.getOriginalFilename() +"("+report.getSize()+")" + "]";
	}
	
	// getters & setters
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public MultipartFile getReport() {
		return report;
	}
	public void setReport(MultipartFile report) {
		this.report = report;
	}
	
	// other methods
	public String getFileName() {
		return report.getOriginalFilename();
	}
}