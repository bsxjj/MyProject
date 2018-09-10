package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Interest;

/**
 * �û���Ȥ����ӿ�
 * @author ��ΰ
 * @date 20180726
 * @version 1.0
 */
public interface IInterstService {

	/**
	 * �û�������Ȥ
	 * @param interest ��Ȥʵ����
	 * @return >0 ����ɹ� =0 ����ʧ��
	 */
	int insertInterst(Interest interest);
	
	/**
	 * ��������
	 * @param interests ��Ȥ����
	 * @return 
	 */
	int insertIntersts(List<Interest>interests);
	
	/**
	 * ������Ȥidɾ����Ȥ
	 * @param interid ��Ȥid
	 * @param userid �û�id
	 * @return >0 ɾ���ɹ� =0 ɾ��ʧ��
	 */
	int deleteInterst(int interid,int userid);
	
	/**
	 * ����id����������ɾ��
	 * @param ids ��Ȥid����
	 * @param userid �û�id
	 * @return
	 * sql�ο� delete from table where id in(?,?,?)
	 */
	int deleteIntersts(int []ids,int userid);
	

	/**
	 * �����û���id����ѯ�û�����Ȥ
	 * @param userid �û�id
	 * @return ��Ȥ����
	 */
	List<Interest> selectIntersts(int userid);
}
