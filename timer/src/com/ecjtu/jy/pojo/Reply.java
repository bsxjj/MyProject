package com.ecjtu.jy.pojo;

import java.sql.Timestamp;

import com.ecjtu.jy.utils.MyUtil;

/**
 * 回复表实体类
 * @author 建伟
 * @date 20170724
 * @version 1.0
 */
public class Reply {
	private Integer id;				//此表的主键
	private Integer rcommentid;		//回复挂在的根评论id
	private Integer replyId;		//回复目标的id
	private String beReliedName;	//被回答用户的名字
	private String beRepliedContent;//用户被回复的内容
	/**
	 * 如果reply_type是comment的话，
	 * 那么reply_id＝commit_id，
	 * 如果reply_type是reply的话，
	 * 这表示这条回复的父回复
	 */
	private String reply_type;		//回复的类型，因为回复可以是针对评论的回复(comment)，
									//也可以是针对回复的回复(reply)， 通过这个字段来区分两种情景。
	private Integer replyerId;		//回复人ID
	private String  replyContent;	//回复内容
	private String replyhead;
	private String replyname;
	private Timestamp replyTime; 	//回复时间
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
