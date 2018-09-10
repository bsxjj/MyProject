package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.ImgTxtInfo;

/**
 * ͼ����Ϣ�ӿڲ�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public interface IImgTxtInfoDao {

	/**
	 * ����ͼ����Ϣ
	 * @param imgTxt ͼ����Ϣʵ����
	 * @return >0�����ɹ�    =0����ʧ��
	 */
	int insertImgTxtInfo(ImgTxtInfo imgTxt);
	
	/**
	 * ����ͼ��id��ɾ��ͼ����Ϣ
	 * @param id ͼ��id
	 * @return >0ɾ���ɹ�    =0ɾ��ʧ��
	 */
	int deleteImgTxtInfoById(int id);
	
	/**
	 * ����ҳ�ź��û�id����ѯͼ����Ϣ
	 * @param pageNum ҳ��
	 * @param id �û�id
	 * @return ͼ����Ϣ����
	 */
	List<ImgTxtInfo> selectImgTxtByPageNum(int pageNum,int id);
	/**
	 * ����ҳ�Ų�ѯͼ����Ϣ
	 * @param pageNum ҳ��
	 * @param id �û�id
	 * @return ͼ����Ϣ����
	 */
	List<ImgTxtInfo> selectImgTxtByPageNum(int pageNum);
	/**
	 * �����û���id����ѯ���û���ͼ������
	 * @param id �û�id
	 * @return �û�ͼ����Ϣ����
	 */
	int selectImgTxtSum(int id);
	
	/**
	 * ��ȡ����ͼ������
	 * @return
	 */
	int selectAllImgTxtNum();
	
	/**
	 * �����������������ҳ
	 * @param pageNum ҳ��
	 * @param id �û�id
	 * @return
	 */
	List<ImgTxtInfo> selectImgTxtByHot(int pageNum,int id);
	
	/**
	 * �����������������ҳ
	 * @param pageNum ҳ��
	 * @param id �û�id
	 * @return
	 */
	List<ImgTxtInfo> selectImgTxtByComment(int pageNum,int id);
	
	
	/**
	 * ����id���鿴�����ͼ����Ϣ
	 * @param id ͼ����Ϣid
	 * @return �����ͼ����Ϣʵ��
	 */
	ImgTxtInfo selectImgTxtById(int id);
	
	
	
	
	
}
