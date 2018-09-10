package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Activity;

/**
 * ��߼���
 * @author ��ΰ
 * @date 20180726
 * @version
 */
public interface IActivityService {

	
	/**
	 * �����
	 * @param activity �ʵ��
	 * @return >0�����ɹ� =0����ʧ��
	 */
	int insertActivity(Activity activity);
	
	
	/**
	 * ���� ���в������ƣ�ʵ�ֵ�һ����(ע���Լ����ܼ�������Ϊ�Լ��Ѿ��ڻ����)
	 * @param activityid �id
	 * @param userid �û�id
	 * @return >0����ɹ� =0����ʧ��
	 */
	int joinActivity(int activityid,int userid);
	
	/**
	 * ɾ���Ҵ����Ļ(ɾ��ʱ֪ͨÿһ�������߸û��ȡ��,֪ͨ��ȡ˽�ŵ���ʽ��
	 * ������Ϊϵͳ֪ͨ����Ϊ�𾴵��û������μӵ�xxx��ѱ�������ȡ��)
	 * @param activityid
	 * @param userid
	 * @return 
	 */
	int deleteActivity(int activityid);
	
	/**
	 * ��Ϊ������ѯ���������ҳ����(ע��Ҫ�ų����ڵĻ�������������ڵĻҪ�ų�)
	 * �pojo���¼����Ѳμ�����������
	 * ��ѯ�ʱͬʱҲҪ��ѯ�Ѳμ���������set������������
	 * @param pageNum ҳ��
	 * @return �����
	 */
	List<Activity> selectActivityByPageNum(int pageNum);
	
	/**
	 * ��ѯ�ҷ���Ļ(��ҳ)
	 * ��ѯ�ʱͬʱҲҪ��ѯ�Ѳμ���������set������������
	 * @param userid �û�id
	 * @return �����
	 */
	List<Activity> selectMyStartActivity(int pageNum,int userid);
	
	/**
	 * �˳�������û��˳��ʱϵͳ���û�����˽�ţ�˽������Ϊϵͳ֪ͨ ����֪������xxx�û��˳��û
	 * @param userid �û�id
	 * @param activityid �id
	 * @return
	 */
	int outActivity(int userid,int activityid);
	
}
