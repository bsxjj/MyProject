package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Activity;

/**
 * ���ӿ�
 * @author ��ΰ
 * @date 20180726
 * @version 1.0
 */
public interface IActivityDao {

	/**
	 * ����
	 * @param activity �ʵ��
	 * @return >0����ɹ� =0����ʧ��
	 */
	int insertActivity(Activity activity);
	
	/**
	 * ɾ���
	 * @param activityid �id
	 * @return >0ɾ���ɹ� =0ɾ��ʧ��
	 */
	int deleteActivity(int activityid);
	
	/**
	 * ���»
	 * @param activity �ʵ��
	 * @return
	 */
	int updateActivity(Activity activity);
	
	/**
	 * ��ѯ���л�����з�ҳ
	 * @param pageNum ҳ��
	 * @return �����
	 */
	List<Activity>selectActivityByPageNum(int pageNum);
	
	/**
	 * ��ȡ���л�ĸ���
	 * @return ����
	 */
	int selectActivityCountNum();
	
	/**
	 * ��ѯ�ҷ������Ŀ
	 * @param userid �û�id
	 * @return
	 */
	List<Activity> selectMyStartActivityByPageNum(int userid);
	
	
	
	
	
	
	
	
	
	
	
}
