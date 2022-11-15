package com.demo.ant.gallery.vo;

public class GalleryFileVO {
	
	private int bdNum;
	private int bdType;
	private String bdTitle;
	private String bdContent;
	private String bdWriter;
	private String bdRegdate;
	private String bdModwriter;
	private String bdModdate;
	private int bdCount;
	private int fileNum;
	private String fileName;
	private String savedFileName;
	private int fileSize;
	public GalleryFileVO() {
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
	public int getFileNum() {
		return fileNum;
	}
	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSavedFileName() {
		return savedFileName;
	}
	public void setSavedFilename(String savedFilename) {
		this.savedFileName = savedFilename;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public GalleryFileVO(int bdNum, int bdType, String bdTitle, String bdContent, String bdWriter, String bdRegdate,
			String bdModwriter, String bdModdate, int bdCount, int fileNum, String fileName, String savedFileName,
			int fileSize) {
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
		this.fileNum = fileNum;
		this.fileName = fileName;
		this.savedFileName = savedFileName;
		this.fileSize = fileSize;
	}

	

	
	
	
}
