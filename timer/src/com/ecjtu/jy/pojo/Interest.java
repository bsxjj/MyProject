package com.ecjtu.jy.pojo;

/**
 * �û���Ȥ��ʵ����
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public class Interest {
	//�û�id
	private Integer userid;
	//��Ȥid
	private Integer interestid;
	private String interstName;
	
	public String getInterstName() {
		return interstName;
	}
	public void setInterstName(String interstName) {
		this.interstName = interstName;
	}
	public Interest(Integer userid, Integer interestid) {
		super();
		this.userid = userid;
		this.interestid = interestid;
	}
	public Interest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getInterestid() {
		return interestid;
	}
	public void setInterestid(Integer interestid) {
		this.interestid = interestid;
	}
	@Override
	public String toString() {
		return "Interest [userid=" + userid + ", interestid=" + interestid + "]";
	}
	
	
	
	
}
