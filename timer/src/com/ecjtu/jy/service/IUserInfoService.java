package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.UserInfo;

public interface IUserInfoService {
	
	/**
	 * ������֤��½
	 * @param userName �û���
	 * @param password ����
	 * @return ����UserInfoʵ����
	 */
	UserInfo selectUserByPassAndUserName(String userName,String password);
	
	/**
	 * ��֤�û����Ƿ����
	 * @param userName �û���
	 * @return type int 
	 * 1 �� > 0-����    0-��ʾ�û��������ڿ���ʹ�� 
	 */
	int validateUserName(String userName);
	
	/**
	 * ��֤email�Ƿ��Ѵ���
	 * @param email
	 * @return 1 �� > 0-����    0-��ʾemail�����ڿ���ʹ�� 
	 */
	int validateEmail(String email);
	
	/**
	 * �����û�id����ѯ�����û�
	 * @param id �û�id
	 * @return �����û�ʵ����
	 */
	UserInfo selectUserById(int id);
	
	/**
	 * ģ����ѯ����ģ��������ѯ�û�
	 * @param likeName ģ����
	 * @return �����û�����
	 */
	List<UserInfo> selectUsersById(String likeName);
	
	/**
	 * �����û�
	 * @param user �û��࣬����ע��ʱ����Ϣ��Ĭ��ͷ��--�û���,����,ͷ��,����
	 * @return ���ز����û���id
	 * 
	 */
	int insertUser(UserInfo user);
	
	/**
	 * �����û�ͷ��
	 * @param img ͷ��url
	 * @return ���ظ��½�� >0 ��ʾ���³ɹ�    =0 ʧ��
	 */
	int updateUserImg(String img,int userid);
	
	/**
	 * �����û����Ա𣬵���������������Ϣ
	 * @param user 
	 * @return 1 �� > 0-���³ɹ�    0-��ʾ����ʧ��
	 */
	int updateUserInfo(UserInfo user);
	
	/**
	 * �����û������԰�Ȩ��
	 * @param id
	 * @return  1 �� > 0-���³ɹ�    0-��ʾ����ʧ��
	 */
	int updateUserMessagePower(int power,int id);
	
	/**
	 * �����û��ķ���Ȩ��
	 * @param id 
	 * @return  1 �� > 0-���³ɹ�    0-��ʾ����ʧ��
	 */
	int updateUserVisitPower(int power,int id);
	/**
	 * ɾ���û�����id
	 * @param id
	 * @return 1 �� > 0-ɾ���ɹ�    0-��ʾɾ��ʧ��
	 */
	int deleteUser(int id);
	
	
	

}
