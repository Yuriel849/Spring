package com.yuriel.domain;

public class PageRanks {
	private int rank;
	private String page;
	
	// constructor
	public PageRanks(int rank, String page) {
		super();
		this.rank = rank;
		this.page = page;
	}

	@Override
	public String toString() {
		return "PageRanks [rank=" + rank + ", page=" + page + "]";
	}

	// getters & setters
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
}