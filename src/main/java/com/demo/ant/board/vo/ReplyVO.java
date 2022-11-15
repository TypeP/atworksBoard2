package com.demo.ant.board.vo;

public class ReplyVO {
	public int rpNum;
	public int bdNum;
	public String rpId;
	public String rpContent;
	public String rpDate;
	public int getRpNum() {
		return rpNum;
	}
	public void setRpNum(int rpNum) {
		this.rpNum = rpNum;
	}
	public int getBdNum() {
		return bdNum;
	}
	public void setBdNum(int bdNum) {
		this.bdNum = bdNum;
	}
	public String getRpId() {
		return rpId;
	}
	public void setRpId(String rpId) {
		this.rpId = rpId;
	}
	public String getRpContent() {
		return rpContent;
	}
	public void setRpContent(String rpContent) {
		this.rpContent = rpContent;
	}
	public String getRpDate() {
		return rpDate;
	}
	public void setRpDate(String rpDate) {
		this.rpDate = rpDate;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [rpNum=" + rpNum + ", bdNum=" + bdNum + ", rpId=" + rpId + ", rpContent=" + rpContent
				+ ", rpDate=" + rpDate +",+getRpNum()="+getRpNum()+",getBdNum()="+getBdNum()+",getRpId()="+getRpId()+",getRpContent()="+getRpContent()+
				",getRpDate()="+getRpDate()+",hashCode()="+hashCode()+",toString()="+super.toString() +"]";
	}
	
	
	

}
