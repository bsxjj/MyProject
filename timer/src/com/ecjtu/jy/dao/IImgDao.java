package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Img;

/**
 * 图片接口层
 * @author 建伟
 * @date 20180724
 * @version 1.0
 */
public interface IImgDao {

	/**
	 * 批量插入图片链接
	 * @param imgs 图片集合
	 * @return 插入结果反馈
	 * 
	 */
	int insertImgs(List<Img>imgs);
	
	/**
	 * 插入单张图片
	 * @param img 图片
	 * @return >0 插入成功 =0插入失败
	 */
	int insertImg(Img img);
	
	/**
	 * 根据id批量进行删除
	 * @param ids id数组
	 * @return 删除结果反馈
	 * sql语句参考 delete from table where id in (?,?,?);
	 */
	int deleteImgs(int []ids);
	
	/**
	 * 删除单张相片
	 * @param id 图片id
	 * @return  >0 删除成功 =0删除失败
	 */
	int deleteImg(int id);
	
	
	/**
	 * 根据相册id来查询图片
	 * @param id 相册id
	 * @return 图片集合
	 */
	List<Img> selectImgsById(int id);
	
	/**
	 * 根据用户的id来查询相册中最新的照片
	 * @param id
	 * @return
	 */
	List<Img>selectImgsByNew(int id);
	
	
}
