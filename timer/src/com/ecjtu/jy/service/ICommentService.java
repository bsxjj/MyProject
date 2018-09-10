package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Comment;
import com.ecjtu.jy.pojo.Notification;
import com.ecjtu.jy.pojo.Reply;

public interface ICommentService {
	/**
	 * 评论
	 * @return
	 */
	public int addComment(Comment comment);
	
	/**
	 * 回复
	 * @param reply
	 * @return
	 */
	public int addReply(Reply reply);
	
	/**
	 * 删除评论
	 * @param commentid
	 * @return
	 */
	public int removeComment(int commentid);
	
	/**
	 * 获取图文评论及其回复
	 * @param comimgtxtid
	 * @return
	 */
	public List<Comment> findImxtxtCommentById(int comimgtxtid);
	
	/**
	 * 获取图文评论数
	 * @param imgtxtid
	 * @return
	 */
	public int selectImgTxtCommentsNum(int imgtxtid);
	
	/**
	 * 查看图文的评论消息
	 * @param myid
	 * @return
	 */
	public List<Notification> selectNotifications(int myid);
	
	/**
	 * 在回复表中查看回复我的评论的回复
	 * @param myid
	 * @return
	 */
	List<Notification> selectNotifications_Reply_Comm(int myid); 
	
	/**
	 * 在回复表中查看回复我的回复的回复
	 * @param myid
	 * @return
	 */
	List<Notification> selectNotifications_Reply_Reply(int myid); 
	/**
	 * 查看评论中未读的个数
	 * @param myid
	 * @return
	 */
	int selectCommentNotRead(int myid);
	

	/**
	 * 回复评论未读的
	 * @param myid
	 * @return
	 */
	int selectReply_ToCommNotRead(int myid);
	/**
	 * 回复回复未读的
	 * @param myid
	 * @return
	 */
	int selectReply_ToRelyNotRead(int myid);
	
	
	public int updateCommentNotRead(int myid);
	
	
	/**
	 * 更新未读信息
	 * @param myid
	 * @return
	 */
	int updateReply_ToCommNotRead(int myid);
	
	int updateReply_ToRelyNotRead(int myid);
	
}
