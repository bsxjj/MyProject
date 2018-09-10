package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Comment;
import com.ecjtu.jy.pojo.Notification;

/**
 * ���۽ӿڲ�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 * 
 */
public interface ICommentDao {
	
	/**
	 * ��������
	 * @param comment ����ʵ����
	 * @return
	 */
	public int insertComment(Comment comment);

	/**
	 * ��������idɾ������
	 * @param commentId
	 * @return
	 */
	public int deleteComment(int commentId);

	/**
	 * �������� (�˹�����ʱ����)
	 * @param comment
	 * @return
	 */
	public int updateComment(Comment comment);

	/**
	 * ��������id����ѯ����
	 * @param commentId
	 * @return
	 */
	public Comment selectCommentById(int commentId);
	
	/**
	 * ����ͼ��id����ѯ����
	 * @param comimgtxtid
	 * @return
	 */
	public List<Comment> selectComments(int comimgtxtid);

	/**
	 * ͨ��imgtxtid����ȡ��ͼ�ĵ�������
	 * @param imgtxtid
	 * @return ������
	 */
	int selectImgTxtCommentsNum(int imgtxtid);
	
	
	/**
	 * �����ҵ�id����ȡ�ҵ�ͼ�ĵ�����
	 * @param myid
	 * @return
	 */
	List<Notification> selectNotifications(int myid);
	
	
	int selectCommentNotRead(int myid);
	
	/**
	 * ����Ϊ�Ѷ�
	 * @param myid
	 * @return
	 */
	int updateCommentNotRead(int myid);
	
	
}
