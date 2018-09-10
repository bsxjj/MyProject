package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Album;
import com.ecjtu.jy.pojo.Img;

/**
 * 相册逻辑层
 * @author 建伟
 * @date 20180726
 * @version 1.0
 */
public interface IAlbumService {
	
	/**
	 * 新增相册
	 * @param album 相册实体类
	 * @return >0新增成功 =0新增失败
	 */
	int insertAlbum(Album album);
	
	/**
	 * 插入单张相片
	 * @param img
	 * @return
	 */
	int uploadImg(Img img);
	
	/**
	 * 批量插入到相册
	 * @param imgs
	 * @return
	 */
	int uploadImgs(List<Img> imgs);
	
	/**
	 * 删除相册
	 * @param albumid
	 * @return
	 */
	int deleteAlbum(int albumid);
	
	/**
	 * 修改相册的信息
	 * @param album
	 * @return
	 */
	int updateAlbum(Album album);
	
	/**
	 * 根据分页进行查询
	 * @param pageNum 页号
	 * @param userid 用户id
	 * @return 相册集合
	 */
	List<Album> selctAlbumByPageNum(int pageNum,int userid);
	
	/**
	 * 根据用户的id来查询该用户的相册总数
	 * @return 相册总数
	 */
	int selectAlbumCountNum(int userid);
	
	/**
	 * 根据相册id来查看相册中的所有图片
	 * @param blbumid
	 * @return
	 */
	List<Img> selectImgByAlbumId(int blbumid);
	
	
	/**
	 * 根据用户id来查看最新的照片
	 * @param id
	 * @return
	 */
	public List<Img> selectImgsByNew(int id);
	
	
	
}
