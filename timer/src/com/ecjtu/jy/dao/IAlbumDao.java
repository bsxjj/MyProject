package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Album;

/**
 * ����ӿ�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public interface IAlbumDao {
	
	/**
	 * �����û�id����ѯ���û������
	 * @param id �û�id
	 * @return �����û���Ἧ��
	 */
	List<Album> selectAlbumById(int id);
	
	/**
	 * �½����
	 * @param blbum ������
	 * @return  >0 �½��ɹ� =0�½�ʧ��
	 */
	int insertAlbum(Album blbum);
	
	/**
	 * ����id��ɾ�����
	 * @param id ���id
	 * @return  >0 ɾ���ɹ� =0ɾ��ʧ��
	 */
	int deleteAlbum(int id);
	
	/**
	 * ���������Ϣ
	 * @param album ������
	 * @return >0 ���³ɹ� =0����ʧ��
	 */
	int updateAlbum(Album album);
	public int selectAlbumCountNum(int userid);
	
	public List<Album> selctAlbumByPageNum(int pageNum, int userid);
}
