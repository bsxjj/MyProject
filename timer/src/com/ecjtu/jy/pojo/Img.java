package com.ecjtu.jy.pojo;

/**
 * ͼƬ��ʵ����
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public class Img {

	private Integer imgId;	 //ͼƬId
	private Integer belongId;//�������Id
	private String imgUrl;	 //ͼƬURL
	public Img(Integer imgId, Integer belongId, String imgUrl) {
		super();
		this.imgId = imgId;
		this.belongId = belongId;
		this.imgUrl = imgUrl;
	}
	public Img() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getImgId() {
		return imgId;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	public Integer getBelongId() {
		return belongId;
	}
	public void setBelongId(Integer belongId) {
		this.belongId = belongId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "Img [imgId=" + imgId + ", belongId=" + belongId + ", imgUrl=" + imgUrl + "]";
	}
	
	
	
	
	
}
