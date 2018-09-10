package com.ecjtu.jy.dao;



import com.ecjtu.jy.pojo.JoinActivity;

/**
 * ������ӿ�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public interface IJoinActivityDao {

	/**
	 * ����
	 * @param joinActivity ����ʵ����
	 * @return >0�����ɹ�  =0����ʧ��
	 */
	int insertJoinActivity(JoinActivity joinActivity);
	
	/**
	 * ȡ���μӸû
	 * @param id �μӻ��id
	 * @return
	 */
	int deleteJoinActivity(int jid);
	
	/**
	 * ���ݻid����ѯ�û�ж����˲μ���
	 * @param activityid
	 * @return �μӵ�����
	 */
	int selectActivityCount(int activityid);
	
	
	
	
}
