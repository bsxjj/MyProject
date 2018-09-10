package com.ecjtu.jy.pojo;

import java.sql.Timestamp;

import com.ecjtu.jy.utils.MyUtil;

/**
 * �ظ���ʵ����
 * @author ��ΰ
 * @date 20170724
 * @version 1.0
 */
public class Reply {
	private Integer id;				//�˱������
	private Integer rcommentid;		//�ظ����ڵĸ�����id
	private Integer replyId;		//�ظ�Ŀ���id
	private String beReliedName;	//���ش��û�������
	private String beRepliedContent;//�û����ظ�������
	/**
	 * ���reply_type��comment�Ļ���
	 * ��ôreply_id��commit_id��
	 * ���reply_type��reply�Ļ���
	 * ���ʾ�����ظ��ĸ��ظ�
	 */
	private String reply_type;		//�ظ������ͣ���Ϊ�ظ�������������۵Ļظ�(comment)��
									//Ҳ��������Իظ��Ļظ�(reply)�� ͨ������ֶ������������龰��
	private Integer replyerId;		//�ظ���ID
	private String  replyContent;	//�ظ�����
	private String replyhead;
	private String replyname;
	private Timestamp replyTime; 	//�ظ�ʱ��
	private String strReplyTime;
	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reply(String beReliedName, Integer replyId, String reply_type, Integer replyerId,
			String replyContent, String replyhead, String replyname, Timestamp replyTime) {
		super();
		
		this.beReliedName = beReliedName;
		this.replyId = replyId;
		this.reply_type = reply_type;
		this.replyerId = replyerId;
		this.replyContent = replyContent;
		this.replyhead = replyhead;
		this.replyname = replyname;
		this.replyTime = replyTime;
	}
	
	public String getBeRepliedContent() {
		return beRepliedContent;
	}

	public void setBeRepliedContent(String beRepliedContent) {
		this.beRepliedContent = beRepliedContent;
	}

	public String getBeReliedName() {
		return beReliedName;
	}

	public void setBeReliedName(String beReliedName) {
		this.beReliedName = beReliedName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRcommentid() {
		return rcommentid;
	}

	public void setRcommentid(Integer rcommentid) {
		this.rcommentid = rcommentid;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getReply_type() {
		return reply_type;
	}

	public void setReply_type(String reply_type) {
		this.reply_type = reply_type;
	}

	public Integer getReplyerId() {
		return replyerId;
	}

	public void setReplyerId(Integer replyerId) {
		this.replyerId = replyerId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyhead() {
		return replyhead;
	}

	public void setReplyhead(String replyhead) {
		this.replyhead = replyhead;
	}

	public String getReplyname() {
		return replyname;
	}

	public void setReplyname(String replyname) {
		this.replyname = replyname;
	}

	public Timestamp getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.setStrReplyTime(MyUtil.longTimeToStringStyle(replyTime));
		this.replyTime = replyTime;
	}

	
	public String getStrReplyTime() {
		return strReplyTime;
	}

	public void setStrReplyTime(String strReplyTime) {
		this.strReplyTime = strReplyTime;
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", rcommentid=" + rcommentid + ", replyId=" + replyId + ", reply_type=" + reply_type
				+ ", replyerId=" + replyerId + ", replyContent=" + replyContent + ", replyhead=" + replyhead
				+ ", replyname=" + replyname + ", replyTime=" + replyTime + "]";
	}
	
	
	
}
