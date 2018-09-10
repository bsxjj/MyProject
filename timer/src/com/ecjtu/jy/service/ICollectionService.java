package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Collection;

/**
 * ͼ���ղط���ӿ�
 * @author ��ΰ
 * @date 20180726
 * @version 1.0
 * 
 */
public interface ICollectionService {

	/**
	 * ����ղ�
	 * �����ղ�
	 * @param collection �ղ�ʵ��
	 * @return >0�ɹ� =0ʧ��
	 */
	int insertCollection(Collection collection);
	
	/**
	 * ɾ������(ȡ������)
	 * @param collectionid �ղ�id
	 * @return >0�ɹ� =0ʧ��
	 */
	int deleteCollection(int collectionid);
	
	/**
	 * ����ҳ�Ż�ȡ�ղ���
	 * @param pageNum ҳ��
	 * @param userid �û�id
	 * @return >0�ɹ� =0ʧ��
	 */
	List<Collection> selectCollectionByPageNum(int pageNum,int userid);
	
	/**
	 * ��ȡ�ղص�����
	 * @param id �û�id
	 * @return �ղص�����
	 */
	int selectCollectionPageSum(int id);
	/**
	 * ��ͼ�ı��ղص�����
	 * @param imgtxtid ͼ��id
	 * @return
	 */
	public int selectImgtxtBeCollect(int imgtxtid);
	
	/**
	 * �жϸ�ͼ���Ƿ��ղ�
	 * @param imgtxtid ͼ��id
	 * @param userid �û�id
	 * @return
	 */
	public int selectIsCollection(int imgtxtid, int userid);
	
	
	
	
	
	
}
