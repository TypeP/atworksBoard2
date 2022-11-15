package com.demo.ant.board.vo;

public class BoardVO {

	private int bdNum;
	private int bdType;
	private String bdTitle;
	private String bdContent;
	private String bdWriter;
	private String bdRegdate;
	private String bdModwriter;
	private String bdModdate;
	private int bdCount;
	
	

	public int getBdNum() {
		return bdNum;
	}



	public void setBdNum(int bdNum) {
		this.bdNum = bdNum;
	}
	
	public int getBdType() {
		return bdNum;
	}



	public void setBdType(int bdType) {
		this.bdType = bdType;
	}




	public String getBdTitle() {
		return bdTitle;
	}



	public void setBdTitle(String bdTitle) {
		this.bdTitle = bdTitle;
	}



	public String getBdContent() {
		return bdContent;
	}



	public void setBdContent(String bdContent) {
		this.bdContent = bdContent;
	}



	public String getBdWriter() {
		return bdWriter;
	}



	public void setBdWriter(String bdWriter) {
		this.bdWriter = bdWriter;
	}



	public String getBdRegdate() {
		return bdRegdate;
	}



	public void setBdRegdate(String bdRegdate) {
		this.bdRegdate = bdRegdate;
	}



	public String getBdModwriter() {
		return bdModwriter;
	}



	public void setBdModwriter(String bdModwriter) {
		this.bdModwriter = bdModwriter;
	}



	public String getBdModdate() {
		return bdModdate;
	}



	public void setBdModdate(String bdModdate) {
		this.bdModdate = bdModdate;
	}



	public int getBdCount() {
		return bdCount;
	}



	public void setBdCount(int bdCount) {
		this.bdCount = bdCount;
	}



	@Override
	public String toString() {
		return "BoardVO [bdNum=" + bdNum + ",bdType="+bdType+", bdTitle=" + bdTitle + ", bdContent=" + bdContent + ", bdWriter=" + bdWriter
				+ ", bdRegdate=" + bdRegdate + ", bdModwriter=" + bdModwriter + ", bdModdate=" + bdModdate + ", bdCount="
				+ bdCount + ", + getBdNum() = "+getBdNum()+",getBdType()="+getBdType()+", getBdTitle()="+ getBdTitle() + ", getBdContent()=" + getBdContent() 
				+ ", getBdWriter()=" + getBdWriter() + ", getBdRegdate()="+ getBdRegdate() + ", getBdModwriter()=" + getBdModwriter() 
				+ ", getBdModdate()=" + getBdModdate() + ", getBdCount()=" + getBdCount() + ", hashCode()="+ hashCode() + ", toString()=" 
				+ super.toString() + "]";
	}
	
	
	
	
	
}
