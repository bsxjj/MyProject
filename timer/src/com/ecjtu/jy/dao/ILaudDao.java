package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Laud;

/**
 * �û����޲�ӿ�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public interface ILaudDao {

	/**
	 * �����û�����
	 * @param laud ����ʵ����
	 * @return >0���ӳɹ� =0����ʧ��
	 */
	int insertLaud(Laud laud);
	
	/**
	 * ȡ������
	 * @param txtid ͼ��id
	 * @param userid �û�id
	 * @return >0ȡ���ɹ� =0ȡ��ʧ��
	 */
	int deleteLaud(int userid,int txtid);
	
	/**
	 * ����ͼ��id����ȡ����޸���
	 * @param txtid ͼ��id
	 * @return ��������
	 */
	int selectLaudCount(int txtid);
	
	/**
	 * ����ͼ��id��ȡ����ʵ��
	 * @param txtid ͼ��id
	 * @return
	 */
	List<Laud>selectLaud(int txtid);
	
	/**
	 * �鿴�û��Ƿ����ͼ�ĵ���
	 * @param userid �û�id
	 * @param txtid ͼ��id
	 * @return >0��  =0 û��
	 */
	int isLaud(int userid,int txtid);
	
	
	
}
