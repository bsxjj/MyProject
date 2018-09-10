package com.ecjtu.jy.pojo;

import java.sql.Timestamp;

/**
 * 接受评论通知实体类
 * @author 建伟
 *
 */
public class Notification {

	private Integer commentid;	//评论根id;
	
	private Integer id;			//回复表id
	
	private Integer replyid;	//回复表回复目标id
	
	private String comm_type;	//评论类型，图文 评论 回复
	private Integer comImgTxtId;//图文id
	private String Content; 	//实体内容
	private String myName;
	
	
	
	private Integer commtorid;	//评论对象id
	private String commName;	//评论者名称
	private String headurl;		//评论者头像
	private String commContent;	//评论内容
	
	private String commTime;
	
	private Timestamp comm_time;
	
	public Timestamp getComm_time() {
		return comm_time;
	}

	public void setComm_time(Timestamp comm_time) {
		this.comm_time = comm_time;
	}

	public Integer getReplyid() {
		return replyid;
	}

	public void setReplyid(Integer replyid) {
		this.replyid = replyid;
	}

	public Integer getCommentid() {
		return commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComm_type() {
		return comm_type;
	}

	public void setComm_type(String comm_type) {
		this.comm_type = comm_type;
	}

	public Integer getComImgTxtId() {
		return comImgTxtId;
	}

	public void setComImgTxtId(Integer comImgTxtId) {
		this.comImgTxtId = comImgTxtId;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public Integer getCommtorid() {
		return commtorid;
	}

	public void setCommtorid(Integer commtorid) {
		this.commtorid = commtorid;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public String getHeadurl() {
		return headurl;
	}

	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}

	public String getCommContent() {
		return commContent;
	}

	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}

	public String getCommTime() {
		return commTime;
	}

	public void setCommTime(String commTime) {
		this.commTime = commTime;
	}

	@Override
	public String toString() {
		return "Notification [commentid=" + commentid + ", id=" + id + ", comm_type=" + comm_type + ", comImgTxtId="
				+ comImgTxtId + ", Content=" + Content + ", myName=" + myName + ", commtorid=" + commtorid
				+ ", commName=" + commName + ", headurl=" + headurl + ", commContent=" + commContent + ", commTime="
				+ commTime + "]";
	}
	
	
	
	
	
}
