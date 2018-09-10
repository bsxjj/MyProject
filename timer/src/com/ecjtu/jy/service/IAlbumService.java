package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Album;
import com.ecjtu.jy.pojo.Img;

/**
 * ����߼���
 * @author ��ΰ
 * @date 20180726
 * @version 1.0
 */
public interface IAlbumService {
	
	/**
	 * �������
	 * @param album ���ʵ����
	 * @return >0�����ɹ� =0����ʧ��
	 */
	int insertAlbum(Album album);
	
	/**
	 * ���뵥����Ƭ
	 * @param img
	 * @return
	 */
	int uploadImg(Img img);
	
	/**
	 * �������뵽���
	 * @param imgs
	 * @return
	 */
	int uploadImgs(List<Img> imgs);
	
	/**
	 * ɾ�����
	 * @param albumid
	 * @return
	 */
	int deleteAlbum(int albumid);
	
	/**
	 * �޸�������Ϣ
	 * @param album
	 * @return
	 */
	int updateAlbum(Album album);
	
	/**
	 * ���ݷ�ҳ���в�ѯ
	 * @param pageNum ҳ��
	 * @param userid �û�id
	 * @return ��Ἧ��
	 */
	List<Album> selctAlbumByPageNum(int pageNum,int userid);
	
	/**
	 * �����û���id����ѯ���û����������
	 * @return �������
	 */
	int selectAlbumCountNum(int userid);
	
	/**
	 * �������id���鿴����е�����ͼƬ
	 * @param blbumid
	 * @return
	 */
	List<Img> selectImgByAlbumId(int blbumid);
	
	
	/**
	 * �����û�id���鿴���µ���Ƭ
	 * @param id
	 * @return
	 */
	public List<Img> selectImgsByNew(int id);
	
	
	
}
