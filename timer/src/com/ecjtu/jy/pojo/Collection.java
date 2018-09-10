package com.ecjtu.jy.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * �ղ�ʵ����
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public class Collection {

	private Integer collectionId;		//�ղ�Id
	private Integer collectorId; 		//�ղ���Id
	private Integer collectionImgTxtId; //ͼ��Id
	private Timestamp collectionCreatTime;	//�ղ�ʱ��
	public Collection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collection(Integer collectionId, Integer collectorId, Integer collectionImgTxtId, Timestamp collectionCreatTime) {
		super();
		this.collectionId = collectionId;
		this.collectorId = collectorId;
		this.collectionImgTxtId = collectionImgTxtId;
		this.collectionCreatTime = collectionCreatTime;
	}
	public Integer getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}
	public Integer getCollectorId() {
		return collectorId;
	}
	public void setCollectorId(Integer collectorId) {
		this.collectorId = collectorId;
	}
	public Integer getCollectionImgTxtId() {
		return collectionImgTxtId;
	}
	public void setCollectionImgTxtId(Integer collectionImgTxtId) {
		this.collectionImgTxtId = collectionImgTxtId;
	}
	public Timestamp getCollectionCreatTime() {
		return collectionCreatTime;
	}
	public void setCollectionCreatTime(Timestamp collectionCreatTime) {
		this.collectionCreatTime = collectionCreatTime;
	}
	@Override
	public String toString() {
		return "Collection [collectionId=" + collectionId + ", collectorId=" + collectorId + ", collectionImgTxtId="
				+ collectionImgTxtId + ", collectionCreatTime=" + collectionCreatTime + "]";
	}
	
	
	
	
}
