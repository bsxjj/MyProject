package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Img;

/**
 * ͼƬ�ӿڲ�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public interface IImgDao {

	/**
	 * ��������ͼƬ����
	 * @param imgs ͼƬ����
	 * @return ����������
	 * 
	 */
	int insertImgs(List<Img>imgs);
	
	/**
	 * ���뵥��ͼƬ
	 * @param img ͼƬ
	 * @return >0 ����ɹ� =0����ʧ��
	 */
	int insertImg(Img img);
	
	/**
	 * ����id��������ɾ��
	 * @param ids id����
	 * @return ɾ���������
	 * sql���ο� delete from table where id in (?,?,?);
	 */
	int deleteImgs(int []ids);
	
	/**
	 * ɾ��������Ƭ
	 * @param id ͼƬid
	 * @return  >0 ɾ���ɹ� =0ɾ��ʧ��
	 */
	int deleteImg(int id);
	
	
	/**
	 * �������id����ѯͼƬ
	 * @param id ���id
	 * @return ͼƬ����
	 */
	List<Img> selectImgsById(int id);
	
	/**
	 * �����û���id����ѯ��������µ���Ƭ
	 * @param id
	 * @return
	 */
	List<Img>selectImgsByNew(int id);
	
	
}
