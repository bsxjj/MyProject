package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.InterestSort;

/**
 * �û���Ȥ����
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public interface IInterstSortDao {

	/**
	 * �����û���Ȥ����
	 * @param interSort ��Ȥ����
	 * @return >0����ɹ�   =0 ����ʧ��
	 */
	int insertInterSort(InterestSort interSort);
	
	/**
	 * ������Ȥid��ɾ����Ȥ
	 * @param id ��Ȥid
	 * @return >0ɾ���ɹ�   =0 ɾ��ʧ��
	 */
	int deleteInterstSort(int id);
	
	
	/**
	 * �޸��û���Ȥ����
	 * @param interSort �û���Ȥ����
	 * @return >0���³ɹ�   =0 ����ʧ��
	 */
	int updateInterstSort(InterestSort interSort);
	
	
	/**
	 * ��ҳ������Ȥ��ѯ
	 * @param pageNum ҳ�� ÿҳ����10��
	 * @return ��Ȥ���༯��
	 */
	List<InterestSort> selectInterSorts(int pageNum);
	
	public String selectInterSortNameById(int id);
	
	
	
	
	
}