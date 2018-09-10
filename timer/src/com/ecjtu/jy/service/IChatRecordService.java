package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.ChatRecord;

public interface IChatRecordService {

	/**
	 * ���¼���в�������(sendid receiveid��ֵ����������)
	 * @param cr
	 * @return
	 */
	ChatRecord insertChatRecord(ChatRecord cr);

	/**
	 * ɾ�����˵������¼(����¼���е�sendstat��Ϊ1)
	 * @param sendid
	 * @return
	 */
	int deleteChatRecord(int crid,int userid);
	
	/**
	 * �ݲ��ṩ�÷���
	 * @param crid
	 * @return
	 */
	int updateChatRecord(int crid);
	
	/**
	 * ��ѯ�ҵ������б�
	 * @param userid
	 * @return
	 */
	List<ChatRecord> selectChatRecordList(int userid);
}
