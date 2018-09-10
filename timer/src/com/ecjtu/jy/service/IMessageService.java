package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Message;

/**
 * �û����Է����ӿ�
 * @author ��ΰ
 * @date 20180726
 * @version 1.0
 */
public interface IMessageService {
	
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
