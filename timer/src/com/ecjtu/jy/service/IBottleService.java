package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Bottle;

/**
 * 时光瓶逻辑层
 * @author 建伟
 * @date 20180726
 * @version 1.0
 */
public interface IBottleService {

	/**
	 * 捞瓶子
	 * 查询时光瓶表中有多少瓶子
	 * 随机产生id，查询该id是否存在及是否已被捞取
	 * 若已被捞取，或不存在则返回null
	 * 否则返回时光瓶实例
	 * @return 实例
	 */
	Bottle selectBottleByRandom();
	
	/**
	 * 获取我的所有瓶子(分页)
	 * @param pageNum 页号
	 * @param userid 用户id
	 * @return 瓶子集合
	 */
	List<Bottle> selectMyBottleByPageNum(int pageNum,int userid);
	
	/**
	 * 获取我的所有瓶子
	 * @param userid 用户id
	 * @return 总数
	 */
	int selectBottleCountSum(int userid);
	
	/**
	 * 扔瓶子
	 * 插入新的时光瓶
	 * @param bottle 瓶子实例
	 * @return >0成功 =0失败
	 */
	int insertBottle(Bottle bottle);
	
	/**
	 * 删除瓶子
	 * @param bottleid 瓶子id
	 * @return >0成功 =0失败
	 */
	int deleteBottle(int bottleid);
	
	/**
	 * 更新瓶子状态(捞到之后扔掉)
	 * @param bottle
	 * @return
	 */
	int updateBottle(Bottle bottle);
	
	
	
	
}
