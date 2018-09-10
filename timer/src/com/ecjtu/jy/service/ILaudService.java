package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Laud;

/**
 * ����ҵ���߼���
 * @author ��ΰ
 * @date 20180726
 * @version 1.0
 */
public interface ILaudService {

	/**
	 * ʵ�ֵ��� ��������
	 * @param laud ����ʵ����
	 * @return >0�ɹ�  =0ʧ��
	 */
	int insertLaud(Laud laud);
	
	/**
	 * ȡ������
	 * @param txtid 
	 * @return
	 */
	int deleteLaud(int userid,int txtid);
	
	/**
	 * ��ȡ������
	 * @param txtid ͼ��id
	 * @return
	 */
	int selectLaudCount(int txtid);
	
	
	/**
	 * ��ȡ����ʵ����
	 * @param txtid ͼ��id
	 * @return
	 */
	List<Laud>selectLaud(int txtid);
	
	
	/**
	 * �ж��Ƿ������
	 * @param userid �û�id
	 * @param txtid ͼ��id
	 * @return
	 */
	int isLaud(int userid,int txtid);
	
	
	
}
