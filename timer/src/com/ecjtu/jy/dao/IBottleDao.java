package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Bottle;

/**
 * ʱ��ƿ�ӿڲ�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public interface IBottleDao {

	/**
	 * �����û�id����ѯʱ��ƿ
	 * @param id �û�id
	 * @return ʱ��ƿ����
	 */
	List<Bottle> selectBottleByUserId(int id);
	
	/**
	 * ����ƿ��id����ȡƿ��(ƿ��״̬Ϊδ����ȡ)
	 * @param id
	 * @return
	 * 
	 */
	Bottle selectBottleByRandom(int id);
	
	/**
	 * ��ȡ����δ����ȡ��ƿ��(����20��)
	 * @return ����ƿ�Ӽ���
	 */
	List<Bottle> selectBottles(int state);
	
	/**
	 * ����ƿ�ӵ���Ϣ
	 * @param state ״̬
	 * @param id ��ȡ��id
	 * @param userName ��ȡ���û���
	 * @return >0 ���³ɹ� =0����ʧ��
	 */
	int updateBottle(Bottle bottle);
	
	/**
	 * �½�Ư��ƿ
	 * @param bottle ƿ�Ӳ��� ƿ����bottlename��ʱ��ƿ����bottlecontent��ƿ����bottleuserid��ƿ��������bottleusername��Ư��ʱ��drifttime
	 * @return >0 �½��ɹ� =0�½�ʧ��
	 */
	int insertBottle(Bottle bottle);
	public int selectBottleCountSum(int userid);
	public List<Bottle> selectMyBottleByPageNum(int pageNum, int userid);
	public int deleteBottle(int bottleid);
}
