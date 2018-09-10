package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.ImgTxtInfo;

/**
 * 图文消息服务接口
 * @author 建伟
 * @date 20180726
 * @version 1.0
 *
 */
public interface IImgTxtInfoService {

	/**
	 * 新增图文消息
	 * @param imgTxt 图文消息实体类
	 * @return >0新增成功    =0新增失败
	 */
	int insertImgTxtInfo(ImgTxtInfo imgTxt);
	
	/**
	 * 根据图文id来删除图文消息
	 * @param id 图文id
	 * @return >0删除成功    =0删除失败
	 */
	int deleteImgTxtInfoById(int id);
	
	/**
	 * 根据页号和用户id来查询图文消息
	 * @param pageNum 页号
	 * @param id 用户id
	 * @return 图文消息集合
	 */
	List<ImgTxtInfo> selectImgTxtByPageNum(int pageNum,int id);
	
	/**
	 * 根据用户的id来查询该用户的图文总数
	 * @param id 用户id
	 * @return 用户图文消息总数
	 */
	int selectImgTxtSum(int id);
	
	/**
	 * 按点赞数进行排序分页
	 * @param pageNum 页号
	 * @param id 用户id
	 * @return
	 */
	List<ImgTxtInfo> selectImgTxtByHot(int pageNum,int id);
	
	/**
	 * 按点赞数进行排序分页
	 * @param pageNum 页号
	 * @param id 用户id
	 * @return
	 */
	List<ImgTxtInfo> selectImgTxtByComment(int pageNum,int id);
	
	
	/**
	 * 根据id来查看具体的图文消息
	 * @param id 图文消息id
	 * @return 具体的图文消息实体
	 */
	ImgTxtInfo selectImgTxtById(int id);
	
	/**
	 * 获取所有图文总数
	 * @return
	 */
	public int selectAllImgTxtNum();
	/**
	 * 根据页号查询图文消息
	 * @param pageNum 页号
	 * @param id 用户id
	 * @return 图文消息集合
	 */
	List<ImgTxtInfo> selectImgTxtByPageNum(int pageNum,int userid,int a);
	
	
}
