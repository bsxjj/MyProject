package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.FeedBack;

/**
 * ������ȡ����ӿ�
 * @author ��ΰ
 * @date 20180726
 * @version 1.0
 */
public interface IFeedBackService {

	
	/**
	 * ��ӷ���
	 * @param feedBack ����ʵ��
	 * @return >0�ɹ� =0ʧ��
	 */
	int insertFeedBack(FeedBack feedBack);
	
	/**
	 * 
	 * ���ķ�����Ϣ״̬
	 * @param feedBack
	 * @return
	 */
	int updateFeedBack(FeedBack feedBack);
	
	/**
	 * ����id��ɾ���û�����
	 * @param id ����id
	 * @return >0ɾ���ɹ�  =0ɾ��ʧ��
	 */
	int delectFeedBack(int id);
	
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
	
}
