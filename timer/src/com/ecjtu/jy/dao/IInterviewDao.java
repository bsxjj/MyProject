package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Interview;

/**
 * �ÿͼ�¼��ӿ�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public interface IInterviewDao {

	/**
	 * �����ÿͼ�¼
	 * @param interview �ÿͼ�¼ʵ����
 	 * @return >0�����ɹ�  =0����ʧ��
	 */
	int insertInterview(Interview interview);
	
	/**
	 * ���ݷÿͼ�¼id����ɾ��
	 * @param interid �ÿͼ�¼id
	 * @return >0ɾ���ɹ�  =0ɾ��ʧ��
	 */
	int deleteInterview(int interid);
	
	/**
	 * ����ҳ�ż��û�id���в�ѯ
	 * @param pageNum ҳ��ÿҳ����10
	 * @param userid �û�id
	 * @return
	 */
	List<Interview> selectInterviewByPageNum(int pageNum,int userid);
	
	
	
	
	
}
