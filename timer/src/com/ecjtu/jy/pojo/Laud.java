package com.ecjtu.jy.pojo;


/**
 * 用户点赞表实体类
 * @author 建伟
 * @date 20180724
 * @version 1.0
 */
public class Laud {

	private Integer laudId; 		//点赞Id
	private Integer laudImgTxtId;	//图文Id 
	private Integer beLaudId;		//用户id 
	private String  beLaudName;		//用户名
	public Laud(Integer laudId, Integer laudImgTxtId, Integer beLaudId, String beLaudName) {
		super();
		this.laudId = laudId;
		this.laudImgTxtId = laudImgTxtId;
		this.beLaudId = beLaudId;
		this.beLaudName = beLaudName;
	}
	public Laud() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getLaudId() {
		return laudId;
	}
	public void setLaudId(Integer laudId) {
		this.laudId = laudId;
	}
	public Integer getLaudImgTxtId() {
		return laudImgTxtId;
	}
	public void setLaudImgTxtId(Integer laudImgTxtId) {
		this.laudImgTxtId = laudImgTxtId;
	}
	public Integer getBeLaudId() {
		return beLaudId;
	}
	public void setBeLaudId(Integer beLaudId) {
		this.beLaudId = beLaudId;
	}
	public String getBeLaudName() {
		return beLaudName;
	}
	public void setBeLaudName(String beLaudName) {
		this.beLaudName = beLaudName;
	}
	@Override
	public String toString() {
		return "Laud [laudId=" + laudId + ", laudImgTxtId=" + laudImgTxtId + ", beLaudId=" + beLaudId + ", beLaudName="
				+ beLaudName + "]";
	}
	
	
	
}
