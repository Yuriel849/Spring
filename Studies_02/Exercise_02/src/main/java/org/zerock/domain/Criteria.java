package org.zerock.domain;

// "Criteria" -> "검색 기준", "분류 기준"
public class Criteria {
	private int page;
	private int perPageNum;
	
	public Criteria() { // 기본값으로 페이비 번호는 1페이지, 페이지당 데이터 수는 10개
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {
		return page;
	}
	
	// method for MyBatis SQL Mapper -> SQL문의 limit에서 1번째 값
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
	
	// method for MyBatis SQL Mapper -> SQL문의 limit에서 2번째 값
	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + "," + "perPageNum=" + perPageNum + "]";
	}
}
