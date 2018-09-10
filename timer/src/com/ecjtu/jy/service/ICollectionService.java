package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Collection;

/**
 * 图文收藏服务接口
 * @author 建伟
 * @date 20180726
 * @version 1.0
 * 
 */
public interface ICollectionService {

	/**
	 * 添加收藏
	 * 插入收藏
	 * @param collection 收藏实例
	 * @return >0成功 =0失败
	 */
	int insertCollection(Collection collection);
	
	/**
	 * 删除更新(取消更新)
	 * @param collectionid 收藏id
	 * @return >0成功 =0失败
	 */
	int deleteCollection(int collectionid);
	
	/**
	 * 根据页号获取收藏数
	 * @param pageNum 页号
	 * @param userid 用户id
	 * @return >0成功 =0失败
	 */
	List<Collection> selectCollectionByPageNum(int pageNum,int userid);
	
	/**
	 * 获取收藏的总数
	 * @param id 用户id
	 * @return 收藏的总数
	 */
	int selectCollectionPageSum(int id);
	/**
	 * 该图文被收藏的总数
	 * @param imgtxtid 图文id
	 * @return
	 */
	public int selectImgtxtBeCollect(int imgtxtid);
	
	/**
	 * 判断该图文是否被收藏
	 * @param imgtxtid 图文id
	 * @param userid 用户id
	 * @return
	 */
	public int selectIsCollection(int imgtxtid, int userid);
	
	
	
	
	
	
}
