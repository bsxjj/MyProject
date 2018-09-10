package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.FeedBack;

/**
 * �û������ӿڲ�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public interface IFeedBackDao {

	/**
	 * ����ҳ������ȡ�û���������
	 * @param pageNum ҳ�� ÿҳ����10��
	 * @return 
	 */
	List<FeedBack> selectFeedBackByPageNum(int pageNum);
	
	/**
	 * ��ȡ�û�����������
	 * @return ����
	 */
	int selectFeedBackSum();
	
	/**
	 * ����id��ѯ����ķ�������
	 * @param id ����id
	 * @return ����ʵ����
	 */
	FeedBack selectFeedBackById(int id);
	
	/**
	 * ����id��ɾ���û�����
	 * @param id ����id
	 * @return >0ɾ���ɹ�  =0ɾ��ʧ��
	 */
	int delectFeedBack(int id);
	
	/**
	 * �����û�����״̬���Ѷ���δ������
	 * @param state
	 * @return
	 */
	int updateFeedBackState(FeedBack feedBack);
	public int insertFeedBack(FeedBack feedBack);
}
