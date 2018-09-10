package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Comment;
import com.ecjtu.jy.pojo.Notification;

/**
 * 评论接口层
 * @author 建伟
 * @date 20180724
 * @version 1.0
 * 
 */
public interface ICommentDao {
	
	/**
	 * 创建评论
	 * @param comment 评论实体类
	 * @return
	 */
	public int insertComment(Comment comment);

	/**
	 * 根据评论id删除评论
	 * @param commentId
	 * @return
	 */
	public int deleteComment(int commentId);

	/**
	 * 更改评论 (此功能暂时不做)
	 * @param comment
	 * @return
	 */
	public int updateComment(Comment comment);

	/**
	 * 根据评论id来查询评论
	 * @param commentId
	 * @return
	 */
	public Comment selectCommentById(int commentId);
	
	/**
	 * 根据图文id来查询评论
	 * @param comimgtxtid
	 * @return
	 */
	public List<Comment> selectComments(int comimgtxtid);

	/**
	 * 通过imgtxtid来获取该图文的评论数
	 * @param imgtxtid
	 * @return 评论数
	 */
	int selectImgTxtCommentsNum(int imgtxtid);
	
	
	/**
	 * 根据我的id来获取我的图文的评论
	 * @param myid
	 * @return
	 */
	List<Notification> selectNotifications(int myid);
	
	
	int selectCommentNotRead(int myid);
	
	/**
	 * 更新为已读
	 * @param myid
	 * @return
	 */
	int updateCommentNotRead(int myid);
	
	
}
