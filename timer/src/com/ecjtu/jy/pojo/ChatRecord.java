package com.ecjtu.jy.pojo;

import java.util.List;

/**
 * 聊天记录类
 * @author 建伟
 *
 */
public class ChatRecord {

	private Integer crid;			//聊天记录id
	private Integer sendid;			//发送者id
	private Integer receiveid;		//接收者id
	private String othername;
	private String otherhead;
	private boolean isSend = false;
	
	private List<PrivateLetter>letters;
	
	
	public List<PrivateLetter> getLetters() {
		return letters;
	}
	public void setLetters(List<PrivateLetter> letters) {
		this.letters = letters;
	}
	
	
	public boolean isSend() {
		return isSend;
	}
	public void setSend(boolean isSend) {
		this.isSend = isSend;
	}
	public String getOthername() {
		return othername;
	}
	public void setOthername(String othername) {
		this.othername = othername;
	}
	public String getOtherhead() {
		return otherhead;
	}
	public void setOtherhead(String otherhead) {
		this.otherhead = otherhead;
	}
	public Integer getCrid() {
		return crid;
	}
	public void setCrid(Integer crid) {
		this.crid = crid;
	}
	public Integer getSendid() {
		return sendid;
	}
	public void setSendid(Integer sendid) {
		this.sendid = sendid;
	}
	public Integer getReceiveid() {
		return receiveid;
	}
	public void setReceiveid(Integer receiveid) {
		this.receiveid = receiveid;
	}
	@Override
	public String toString() {
		return "ChatRecord [crid=" + crid + ", sendid=" + sendid + ", receiveid=" + receiveid + "]";
	}
	
	
	
	
}
