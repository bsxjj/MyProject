package com.ecjtu.jy.pojo;


/**
 * ���Ա�ʵ����
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public class Message {

	private Integer id;//
	//����������
	private String messageuser;
	//������id
	private Integer messageuserid;
	//��������
	private String message;
	//������ͷ��
	private String messageuserimgge;
	//��������
	private Integer bemessageid;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(Integer id, String messageuser, Integer messageuserid, String message, String messageuserimgge,
			Integer bemessageid) {
		super();
		this.id = id;
		this.messageuser = messageuser;
		this.messageuserid = messageuserid;
		this.message = message;
		this.messageuserimgge = messageuserimgge;
		this.bemessageid = bemessageid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessageuser() {
		return messageuser;
	}
	public void setMessageuser(String messageuser) {
		this.messageuser = messageuser;
	}
	public Integer getMessageuserid() {
		return messageuserid;
	}
	public void setMessageuserid(Integer messageuserid) {
		this.messageuserid = messageuserid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageuserimgge() {
		return messageuserimgge;
	}
	public void setMessageuserimgge(String messageuserimgge) {
		this.messageuserimgge = messageuserimgge;
	}
	public Integer getBemessageid() {
		return bemessageid;
	}
	public void setBemessageid(Integer bemessageid) {
		this.bemessageid = bemessageid;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", messageuser=" + messageuser + ", messageuserid=" + messageuserid + ", message="
				+ message + ", messageuserimgge=" + messageuserimgge + ", bemessageid=" + bemessageid + "]";
	}

	
}
