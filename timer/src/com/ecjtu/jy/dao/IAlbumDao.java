package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Album;

/**
 * 相册层接口
 * @author 建伟
 * @date 20180724
 * @version 1.0
 */
public interface IAlbumDao {
	
	/**
	 * 根据用户id来查询该用户的相册
	 * @param id 用户id
	 * @return 返回用户相册集合
	 */
	List<Album> selectAlbumById(int id);
	
	/**
	 * 新建相册
	 * @param blbum 相册参数
	 * @return  >0 新建成功 =0新建失败
	 */
	int insertAlbum(Album blbum);
	
	/**
	 * 根据id来删除相册
	 * @param id 相册id
	 * @return  >0 删除成功 =0删除失败
	 */
	int deleteAlbum(int id);
	
	/**
	 * 更新相册信息
	 * @param album 相册参数
	 * @return >0 更新成功 =0更新失败
	 */
	int updateAlbum(Album album);
	public int selectAlbumCountNum(int userid);
	
	public List<Album> selctAlbumByPageNum(int pageNum, int userid);
}
