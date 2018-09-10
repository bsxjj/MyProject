package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Comment;
import com.ecjtu.jy.pojo.Notification;
import com.ecjtu.jy.pojo.Reply;

public interface ICommentService {
	/**
	 * ����
	 * @return
	 */
	public int addComment(Comment comment);
	
	/**
	 * �ظ�
	 * @param reply
	 * @return
	 */
	public int addReply(Reply reply);
	
	/**
	 * ɾ������
	 * @param commentid
	 * @return
	 */
	public int removeComment(int commentid);
	
	/**
	 * ��ȡͼ�����ۼ���ظ�
	 * @param comimgtxtid
	 * @return
	 */
	public List<Comment> findImxtxtCommentById(int comimgtxtid);
	
	/**
	 * ��ȡͼ��������
	 * @param imgtxtid
	 * @return
	 */
	public int selectImgTxtCommentsNum(int imgtxtid);
	
	/**
	 * �鿴ͼ�ĵ�������Ϣ
	 * @param myid
	 * @return
	 */
	public List<Notification> selectNotifications(int myid);
	
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
	 * �鿴������δ���ĸ���
	 * @param myid
	 * @return
	 */
	int selectCommentNotRead(int myid);
	

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
	
	
	public int updateCommentNotRead(int myid);
	
	
	/**
	 * ����δ����Ϣ
	 * @param myid
	 * @return
	 */
	int updateReply_ToCommNotRead(int myid);
	
	int updateReply_ToRelyNotRead(int myid);
	
}
