package com.ecjtu.jy.dao;


import java.util.List;

import com.ecjtu.jy.pojo.Collection;

/**
 * ͼ���ղز�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 * 
 */
public interface ICollectionDao {

	/**
	 * ����ҳ������ѯ�ղ�����
	 * @param page ҳ�� ÿҳ5��
	 * @param id �û�id
	 * @return �ղؼ���
	 */
	List<Collection> selectCollectionByPage(int page,int id);
	
	/**
	 * ��ȡ�ղص�����
	 * @param id �û�id
	 * @return �ղص�����
	 */
	int selectCollectionPageSum(int id);
	
	
	/**
	 * ����ղ�
	 * @param collection �ղز���
	 * @return >0�ղسɹ� =0�ղ�ʧ��
	 */
	int insertCollection(Collection collection);
	
	/**
	 * ����id��ɾ���ղ�
	 * @param id
	 * @return >0ɾ���ɹ� =0ɾ��ʧ��
	 * 
	 */
	int deleteCollection(int id);
	
	int selectImgtxtBeCollect(int imgtxtid);
	
	/**
	 * �жϸ�ͼ���Ƿ��ղ�
	 * @param imgtxtid
	 * @param userid
	 * @return
	 */
	int selectIsCollection(int imgtxtid,int userid);
	
}
