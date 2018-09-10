package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.PrivateLetter;

/**
 * ˽�Ų�ӿ�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public interface IPrivateLetterDao {

	/**
	 * ����˽��
	 * @param letter ˽��ʵ����
	 * @return >0����ɹ� =0����ʧ��
	 */
	int insertPrivateLetter(PrivateLetter letter);
	
	/**
	 * �����û����û���id��ɾ��˽��
	 * @param user1id �û�1id
	 * @param user2id �û�2id
	 * @return>0ɾ���ɹ� =0ɾ��ʧ��
	 */
	int deletePrivateLetter(int user1id,int user2id);
	
	/**
	 * ����˽��id��ɾ��˽��
	 * @param letterid
	 * @return >0ɾ���ɹ� =0ɾ��ʧ��
	 */
	int deletePrivateLetterById(int letterid);
	
	/**
	 * �����û�id��ҳ������ѯ˽��
	 * @param pageNum ҳ�� ÿҳ����10��
	 * @param userid �û�id
	 * @return ˽�ż���
	 */
	List<PrivateLetter> selectLetterByPageNum(int pageNum,int userid);
	
	/**
	 * ����crid������ѯ����˽��
	 * @param crid �û�id
	 * @return ˽�ż���
	 */
	List<PrivateLetter> selectLetterUserList(int crid);
	
	/**
	 * �����û�id�鿴�û�˽�ŵĸ���
	 * @param userid
	 * @return ˽�Ÿ���
	 */
	int selectLetterCount(int userid);
	
	/**
	 * ��ȡ�û�δ��˽�����ݸ���
	 * @param userid �û�id
	 * @return δ����Ϣ����
	 */
	int selectLetterCountByNotRead(int userid);
	
	/**
	 * ��ȡ�û��Ѷ�˽�����ݸ���
	 * @param userid �û�id
	 * @return �Ѷ���Ϣ����
	 */
	int selectLetterCountByIsRead(int userid);
	
	/**
	 * �����û�id��ҳ������ѯ˽��
	 * @param pageNum ҳ�� ÿҳ����10��
	 * @param userid �û�id
	 * @param type 0 δ�� 1�Ѷ� ����������ֻ����ʶ�ǲ�ѯ�Ѷ�����δ����˽��
	 * @return ˽�ż���
	 */
	List<PrivateLetter> selectLetterByPageNum(int pageNum,int userid,int type);
	
	/**
	 * ���ݸ�crid����ѯ˽��
	 * @param crid
	 * @return
	 */
	List<PrivateLetter> selectLetterByCrid(int crid);
	
	/**
	 * ����˽��id�����Ķ���״̬
	 * @param privateletid
	 * @return
	 */
	int updateLetter(int privateletid);
	
	
	
}
