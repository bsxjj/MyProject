package com.ecjtu.jy.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ecjtu.jy.utils.MyUtil;

/**
 * ���۱�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public class Comment {
	private Integer commentId;     //����ID
	private Integer comImgTxtId;   //ͼ����ϢID
	private Integer commentorId;	//������ID
	private String  commentContent;//��������
	private String  commentorHead;	   //������ͷ��
	private String  commentorName;
	private Timestamp createTime;	   //����ʱ��
	public  List<Reply>replies;
	
	private String strCreateTime;
	
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(Integer comImgTxtId, Integer commentorId, String commentContent,
			String commentorHead, String commentorName, Timestamp createTime) {
		super();
		
		this.comImgTxtId = comImgTxtId;
		this.commentorId = commentorId;
		this.commentContent = commentContent;
		this.commentorHead = commentorHead;
		this.commentorName = commentorName;
		this.createTime = createTime;
	}
	
	
	public String getStrCreateTime() {
		return strCreateTime;
	}
	public void setStrCreateTime(String strCreateTime) {
		this.strCreateTime = strCreateTime;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getComImgTxtId() {
		return comImgTxtId;
	}
	public void setComImgTxtId(Integer comImgTxtId) {
		this.comImgTxtId = comImgTxtId;
	}
	public Integer getCommentorId() {
		return commentorId;
	}
	public void setCommentorId(Integer commentorId) {
		this.commentorId = commentorId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentorHead() {
		return commentorHead;
	}
	public void setCommentorHead(String commentorHead) {
		this.commentorHead = commentorHead;
	}
	public String getCommentorName() {
		return commentorName;
	}
	public void setCommentorName(String commentorName) {
		this.commentorName = commentorName;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.setStrCreateTime(MyUtil.longTimeToStringStyle(createTime));
		this.createTime = createTime;
	}

	public List<Reply> getReplies() {
		return replies;
	}
	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comImgTxtId=" + comImgTxtId + ", commentorId=" + commentorId
				+ ", commentContent=" + commentContent + ", commentorHead=" + commentorHead + ", commentorName="
				+ commentorName + ", createTime=" + createTime + ", replies=" + replies + "]";
	}
	
	
	
	
}
