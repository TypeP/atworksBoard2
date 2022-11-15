package com.demo.ant.gallery.vo;

import java.util.List;

public class GalleryVO {

	private int bdNum;
	private int bdType;
	private String bdTitle;
	private String bdContent;
	private String bdWriter;
	private String bdRegdate;
	private String bdModwriter;
	private String bdModdate;
	private int bdCount;
	private List<FileListVO> fileList;
	
	public GalleryVO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getBdNum() {
		return bdNum;
	}
	public void setBdNum(int bdNum) {
		this.bdNum = bdNum;
	}
	public int getBdType() {
		return bdType;
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
	public List<FileListVO> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileListVO> fileList) {
		this.fileList = fileList;
	}
	

	public GalleryVO(int bdNum, int bdType, String bdTitle, String bdContent, String bdWriter,
			String bdRegdate, String bdModwriter, String bdModdate, int bdCount, List<FileListVO> fileList) {
		super();
		this.bdNum = bdNum;
		this.bdType = bdType;
		this.bdTitle = bdTitle;
		this.bdContent = bdContent;
		this.bdWriter = bdWriter;
		this.bdRegdate = bdRegdate;
		this.bdModwriter = bdModwriter;
		this.bdModdate = bdModdate;
		this.bdCount = bdCount;
		this.fileList = fileList;
	}


	
	




	/*
	 * @Override public String toString() { return "BoardVO [bdNum=" + bdNum +
	 * ",bdType="+bdType+", bdTitle=" + bdTitle + ", bdContent=" + bdContent +
	 * ", bdWriter=" + bdWriter + ", bdRegdate=" + bdRegdate + ", bdModwriter=" +
	 * bdModwriter + ", bdModdate=" + bdModdate + ", bdCount=" + bdCount +
	 * ", + getBdNum() = "+getBdNum()+",getBdType()="+getBdType()+", getBdTitle()="+
	 * getBdTitle() + ", getBdContent()=" + getBdContent() + ", getBdWriter()=" +
	 * getBdWriter() + ", getBdRegdate()="+ getBdRegdate() + ", getBdModwriter()=" +
	 * getBdModwriter() + ", getBdModdate()=" + getBdModdate() + ", getBdCount()=" +
	 * getBdCount() + ", hashCode()="+ hashCode() + ", toString()=" +
	 * super.toString() + "]"; }
	 */
	
	
	
	
}
