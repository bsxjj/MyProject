package com.ecjtu.jy.pojo;

import java.sql.Timestamp;

/**
 * ˽�ű�ʵ����
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public class PrivateLetter {

	private Integer privateLetterId;		//˽��Id
	private String privateLetterContents;	//˽������
	private Integer cr_id;
	private Integer privateLetterType;		//˽�����ͣ�
	private Integer acceptStatus;			//����״̬
	private Timestamp sendTime;				//����ʱ�� ��
	private Integer senderId;				//������Id
	private Integer acceptId;				//������Id
	private String sendimg;
	private String acceptimg;
	public PrivateLetter(Integer privateLetterId, String privateLetterContents, Integer privateLetterType,
			Integer acceptStatus, Timestamp endTime, Integer senderId, Integer acceptId) {
		super();
		this.privateLetterId = privateLetterId;
		this.privateLetterContents = privateLetterContents;
		this.privateLetterType = privateLetterType;
		this.acceptStatus = acceptStatus;
		this.sendTime = endTime;
		this.senderId = senderId;
		this.acceptId = acceptId;
	}
	public PrivateLetter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getSendimg() {
		return sendimg;
	}
	public void setSendimg(String sendimg) {
		this.sendimg = sendimg;
	}
	public String getAcceptimg() {
		return acceptimg;
	}
	public void setAcceptimg(String acceptimg) {
		this.acceptimg = acceptimg;
	}
	public Integer getCr_id() {
		return cr_id;
	}
	public void setCr_id(Integer cr_id) {
		this.cr_id = cr_id;
	}
	public Integer getPrivateLetterId() {
		return privateLetterId;
	}
	public void setPrivateLetterId(Integer privateLetterId) {
		this.privateLetterId = privateLetterId;
	}
	public String getPrivateLetterContents() {
		return privateLetterContents;
	}
	public void setPrivateLetterContents(String privateLetterContents) {
		this.privateLetterContents = privateLetterContents;
	}
	public Integer getPrivateLetterType() {
		return privateLetterType;
	}
	public void setPrivateLetterType(Integer privateLetterType) {
		this.privateLetterType = privateLetterType;
	}
	public Integer getAcceptStatus() {
		return acceptStatus;
	}
	public void setAcceptStatus(Integer acceptStatus) {
		this.acceptStatus = acceptStatus;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp endTime) {
		this.sendTime = endTime;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public Integer getAcceptId() {
		return acceptId;
	}
	public void setAcceptId(Integer acceptId) {
		this.acceptId = acceptId;
	}
	@Override
	public String toString() {
		return "PrivateLetter [privateLetterId=" + privateLetterId + ", privateLetterContents=" + privateLetterContents
				+ ", privateLetterType=" + privateLetterType + ", acceptStatus=" + acceptStatus + ", endTime=" + sendTime
				+ ", senderId=" + senderId + ", acceptId=" + acceptId + "]";
	}

	
}
