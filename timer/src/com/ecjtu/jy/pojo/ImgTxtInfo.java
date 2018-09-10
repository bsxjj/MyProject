package com.ecjtu.jy.pojo;

import java.sql.Timestamp;
import java.util.List;

/**
 * 图文信息表实体类
 * @author 建伟
 * @date 20180724
 * @version 3.0 新增点赞数 是否点赞的属性及get set方法
 *
 */
public class ImgTxtInfo {

	private Integer imgTxtId;		    //图文ID
	private String imgUrl;			    //图片路径
	private String text;			    //文本内容
	private Integer sendId;			    //发表人ID，
	private Timestamp ImgTxtSendTime;   //发表时间
	private String sendPlace;			//发表地点
	private Integer ImgTxtPowerStatus;  //权限状态
	private Integer laudNum;			//点赞个数
	private boolean isLaud;				//是否已经点赞
	private List<Laud>lauds;			//点赞的人
	private Integer collectionNum;		//收藏人数
	private Boolean isCollection;		//是否被收藏
	private Integer commNum;			//评论数
	
	private String username;
	private String userImg;
	
	
	public ImgTxtInfo() {
		super();
	
	}
	public ImgTxtInfo(Integer imgTxtId, String imgUrl, String text, Integer sendId, Timestamp imgTxtSendTime,
			String sendPlace, Integer imgTxtPowerStatus) {
		super();
		this.imgTxtId = imgTxtId;
		this.imgUrl = imgUrl;
		this.text = text;
		this.sendId = sendId;
		ImgTxtSendTime = imgTxtSendTime;
		this.sendPlace = sendPlace;
		ImgTxtPowerStatus = imgTxtPowerStatus;
	}
	
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public Integer getCommNum() {
		return commNum;
	}
	public void setCommNum(Integer commNum) {
		this.commNum = commNum;
	}
	public Boolean getIsCollection() {
		return isCollection;
	}
	public void setIsCollection(Boolean isCollection) {
		this.isCollection = isCollection;
	}
	public Integer getCollectionNum() {
		return collectionNum;
	}
	public void setCollectionNum(Integer collectionNum) {
		this.collectionNum = collectionNum;
	}
	public List<Laud> getLauds() {
		return lauds;
	}
	public void setLauds(List<Laud> lauds) {
		this.lauds = lauds;
	}
	public boolean isLaud() {
		return isLaud;
	}
	public void setLaud(boolean isLaud) {
		this.isLaud = isLaud;
	}
	public Integer getLaudNum() {
		return laudNum;
	}
	public void setLaudNum(Integer laudNum) {
		this.laudNum = laudNum;
	}
	public Integer getImgTxtId() {
		return imgTxtId;
	}
	public void setImgTxtId(Integer imgTxtId) {
		this.imgTxtId = imgTxtId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getSendId() {
		return sendId;
	}
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	public Timestamp getImgTxtSendTime() {
		return ImgTxtSendTime;
	}
	public void setImgTxtSendTime(Timestamp imgTxtSendTime) {
		ImgTxtSendTime = imgTxtSendTime;
	}
	public String getSendPlace() {
		return sendPlace;
	}
	public void setSendPlace(String sendPlace) {
		this.sendPlace = sendPlace;
	}
	public Integer getImgTxtPowerStatus() {
		return ImgTxtPowerStatus;
	}
	public void setImgTxtPowerStatus(Integer imgTxtPowerStatus) {
		ImgTxtPowerStatus = imgTxtPowerStatus;
	}
	@Override
	public String toString() {
		return "ImgTxtInfo [imgTxtId=" + imgTxtId + ", imgUrl=" + imgUrl + ", text=" + text + ", sendId=" + sendId
				+ ", ImgTxtSendTime=" + ImgTxtSendTime + ", sendPlace=" + sendPlace + ", ImgTxtPowerStatus="
				+ ImgTxtPowerStatus + "]";
	}
	
	
	
	
	
}
