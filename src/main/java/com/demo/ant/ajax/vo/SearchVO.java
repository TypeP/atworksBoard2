package com.demo.ant.ajax.vo;

public class SearchVO {

	private int curPage;
	private int pagePerCnt;
	private String keyword;
	private String searchType;
	
	public SearchVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public SearchVO(int curPage, int pagePerCnt, String keyword, String searchType) {
		super();
		this.curPage=curPage;
		this.pagePerCnt=pagePerCnt;
		this.keyword=keyword;
		this.searchType=searchType;
	}

	public int getCurPage() {
		return curPage;
	}




	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}




	public int getPagePerCnt() {
		return pagePerCnt;
	}




	public void setPagePerCnt(int pagePerCnt) {
		this.pagePerCnt = pagePerCnt;
	}




	public String getKeyword() {
		return keyword;
	}




	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}




	public String getSearchType() {
		return searchType;
	}




	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}



 
	
	
	
	
}
