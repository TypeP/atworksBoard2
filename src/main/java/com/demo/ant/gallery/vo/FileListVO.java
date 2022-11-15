package com.demo.ant.gallery.vo;

public class FileListVO {
	private int fileNum;
	private int bdNum;
	private String fileName;
	private String savedFileName;
	private int fileSize;
	
	public FileListVO() {
		// TODO Auto-generated constructor stub
	}
	public int getFileNum() {
		return fileNum;
	}
	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}
	public int getBdNum() {
		return bdNum;
	}
	public void setBdNum(int bdNum) {
		this.bdNum = bdNum;
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
	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public FileListVO(int fileNum, int bdNum, String fileName, String savedFileName, int fileSize) {
		super();
		this.fileNum = fileNum;
		this.bdNum = bdNum;
		this.fileName = fileName;
		this.savedFileName = savedFileName;
		this.fileSize = fileSize;
	}

	
}
