package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Notification;
import com.ecjtu.jy.pojo.Reply;

/**
 * �ظ���ӿ�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public interface IReplyDao {

	/**
	 * �ظ�
	 * @param reply
	 * @return
	 */
	public int insertReply(Reply reply);
	
	
	/**
	 * ����id��ɾ���ظ�
	 * @param id
	 * @return
	 */
	public int deleteReply(int id);
	
	public int updateReply(Reply reply);
	
	/**
	 * ��ѯ�ظ���
	 * @param commentid
	 * @return
	 */
	public List<Reply> selectReplyByCommentId(int commentid);
	
	
	Reply selectReplyById(int id);
	
	/**
	 * �ڻظ����в鿴�ظ��ҵ����۵Ļظ�
	 * @param myid
	 * @return
	 */
	List<Notification> selectNotifications_Reply_Comm(int myid); 
	
	/**
	 * �ڻظ����в鿴�ظ��ҵĻظ��Ļظ�
	 * @param myid
	 * @return
	 */
	List<Notification> selectNotifications_Reply_Reply(int myid); 
	
	/**
	 * �ظ�����δ����
	 * @param myid
	 * @return
	 */
	int selectReply_ToCommNotRead(int myid);
	/**
	 * �ظ��ظ�δ����
	 * @param myid
	 * @return
	 */
	int selectReply_ToRelyNotRead(int myid);
	
	/**
	 * ����δ����Ϣ
	 * @param myid
	 * @return
	 */
	int updateReply_ToCommNotRead(int myid);
	
	int updateReply_ToRelyNotRead(int myid);
	
	
	
	
}
