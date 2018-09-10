package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Bottle;

/**
 * ʱ��ƿ�߼���
 * @author ��ΰ
 * @date 20180726
 * @version 1.0
 */
public interface IBottleService {

	/**
	 * ��ƿ��
	 * ��ѯʱ��ƿ�����ж���ƿ��
	 * �������id����ѯ��id�Ƿ���ڼ��Ƿ��ѱ���ȡ
	 * ���ѱ���ȡ���򲻴����򷵻�null
	 * ���򷵻�ʱ��ƿʵ��
	 * @return ʵ��
	 */
	Bottle selectBottleByRandom();
	
	/**
	 * ��ȡ�ҵ�����ƿ��(��ҳ)
	 * @param pageNum ҳ��
	 * @param userid �û�id
	 * @return ƿ�Ӽ���
	 */
	List<Bottle> selectMyBottleByPageNum(int pageNum,int userid);
	
	/**
	 * ��ȡ�ҵ�����ƿ��
	 * @param userid �û�id
	 * @return ����
	 */
	int selectBottleCountSum(int userid);
	
	/**
	 * ��ƿ��
	 * �����µ�ʱ��ƿ
	 * @param bottle ƿ��ʵ��
	 * @return >0�ɹ� =0ʧ��
	 */
	int insertBottle(Bottle bottle);
	
	/**
	 * ɾ��ƿ��
	 * @param bottleid ƿ��id
	 * @return >0�ɹ� =0ʧ��
	 */
	int deleteBottle(int bottleid);
	
	/**
	 * ����ƿ��״̬(�̵�֮���ӵ�)
	 * @param bottle
	 * @return
	 */
	int updateBottle(Bottle bottle);
	
	
	
	
}
