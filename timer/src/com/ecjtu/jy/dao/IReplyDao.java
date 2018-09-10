package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Notification;
import com.ecjtu.jy.pojo.Reply;

/**
 * 回复层接口
 * @author 建伟
 * @date 20180724
 * @version 1.0
 */
public interface IReplyDao {

	/**
	 * 回复
	 * @param reply
	 * @return
	 */
	public int insertReply(Reply reply);
	
	
	/**
	 * 根据id来删除回复
	 * @param id
	 * @return
	 */
	public int deleteReply(int id);
	
	public int updateReply(Reply reply);
	
	/**
	 * 查询回复表
	 * @param commentid
	 * @return
	 */
	public List<Reply> selectReplyByCommentId(int commentid);
	
	
	Reply selectReplyById(int id);
	
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
	
	/**
	 * 更新未读信息
	 * @param myid
	 * @return
	 */
	int updateReply_ToCommNotRead(int myid);
	
	int updateReply_ToRelyNotRead(int myid);
	
	
	
	
}
