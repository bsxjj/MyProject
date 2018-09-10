package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Message;

/**
 * ���Բ�ӿ�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public interface IMessageDao {

	/**
	 * ��������
	 * @param mess ����ʵ����
	 * @return >0���Գɹ� =0����ʧ��
	 * 
	 */
	int insertMessage(Message mess);
	/**
	 * ��������idɾ������
	 * @param id ���Ա�id
	 * @return >0ɾ���ɹ� =0ɾ��ʧ��
	 */
	int deleteMessage(int id);
	
	/**
	 * ����ҳ�ż���������id����ѯ����
	 * @param pageNum ҳ��
	 * @param userid ��������id
	 * @return ���Լ���
	 */
	List<Message> selectMessagesByPageNum(int pageNum,int userid);
	
	
	/**
	 * ���ݱ������û�id����ѯ��������
	 * @param userid ������id
	 * @return ��������
	 */
	int selectMessageCount(int userid);
	
	
	
	
	
}
