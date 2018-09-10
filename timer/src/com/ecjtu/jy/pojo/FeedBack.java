package com.ecjtu.jy.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * ������ʵ����
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public class FeedBack {

	private Integer feedbackId;		//����Id
	private String feedbackContent; //��������
	private Integer feedbackerId;	//������Id
	private String feedbackerName;	// ��������
	private Timestamp feedbackTime;		//����ʱ��
	private Integer feedbackStatus; //����״̬
	public FeedBack() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FeedBack(Integer feedbackId, String feedbackContent, Integer feedbackerId, String feedbackerName,
			Timestamp feedbackTime, Integer feedbackStatus) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackContent = feedbackContent;
		this.feedbackerId = feedbackerId;
		this.feedbackerName = feedbackerName;
		this.feedbackTime = feedbackTime;
		this.feedbackStatus = feedbackStatus;
	}
	public Integer getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getFeedbackContent() {
		return feedbackContent;
	}
	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}
	public Integer getFeedbackerId() {
		return feedbackerId;
	}
	public void setFeedbackerId(Integer feedbackerId) {
		this.feedbackerId = feedbackerId;
	}
	public String getFeedbackerName() {
		return feedbackerName;
	}
	public void setFeedbackerName(String feedbackerName) {
		this.feedbackerName = feedbackerName;
	}
	public Timestamp getFeedbackTime() {
		return feedbackTime;
	}
	public void setFeedbackTime(Timestamp feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	public Integer getFeedbackStatus() {
		return feedbackStatus;
	}
	public void setFeedbackStatus(Integer feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}
	@Override
	public String toString() {
		return "FeedBack [feedbackId=" + feedbackId + ", feedbackContent=" + feedbackContent + ", feedbackerId="
				+ feedbackerId + ", feedbackerName=" + feedbackerName + ", feedbackTime=" + feedbackTime
				+ ", feedbackStatus=" + feedbackStatus + "]";
	}
	
	
	
	
}
