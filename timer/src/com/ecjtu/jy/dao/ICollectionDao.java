package com.ecjtu.jy.dao;


import java.util.List;

import com.ecjtu.jy.pojo.Collection;

/**
 * 图文收藏层
 * @author 建伟
 * @date 20180724
 * @version 1.0
 * 
 */
public interface ICollectionDao {

	/**
	 * 根据页号来查询收藏数据
	 * @param page 页号 每页5条
	 * @param id 用户id
	 * @return 收藏集合
	 */
	List<Collection> selectCollectionByPage(int page,int id);
	
	/**
	 * 获取收藏的总数
	 * @param id 用户id
	 * @return 收藏的总数
	 */
	int selectCollectionPageSum(int id);
	
	
	/**
	 * 添加收藏
	 * @param collection 收藏参数
	 * @return >0收藏成功 =0收藏失败
	 */
	int insertCollection(Collection collection);
	
	/**
	 * 根据id来删除收藏
	 * @param id
	 * @return >0删除成功 =0删除失败
	 * 
	 */
	int deleteCollection(int id);
	
	int selectImgtxtBeCollect(int imgtxtid);
	
	/**
	 * 判断该图文是否被收藏
	 * @param imgtxtid
	 * @param userid
	 * @return
	 */
	int selectIsCollection(int imgtxtid,int userid);
	
}
