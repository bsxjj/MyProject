package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Bottle;

/**
 * 时光瓶接口层
 * @author 建伟
 * @date 20180724
 * @version 1.0
 */
public interface IBottleDao {

	/**
	 * 根据用户id来查询时光瓶
	 * @param id 用户id
	 * @return 时光瓶集合
	 */
	List<Bottle> selectBottleByUserId(int id);
	
	/**
	 * 根据瓶子id来捞取瓶子(瓶子状态为未被捞取)
	 * @param id
	 * @return
	 * 
	 */
	Bottle selectBottleByRandom(int id);
	
	/**
	 * 获取所有未被捞取的瓶子(限制20个)
	 * @return 返回瓶子集合
	 */
	List<Bottle> selectBottles(int state);
	
	/**
	 * 更新瓶子的信息
	 * @param state 状态
	 * @param id 捞取人id
	 * @param userName 捞取人用户名
	 * @return >0 更新成功 =0跟新失败
	 */
	int updateBottle(Bottle bottle);
	
	/**
	 * 新建漂流瓶
	 * @param bottle 瓶子参数 瓶子名bottlename，时光瓶内容bottlecontent，瓶主人bottleuserid，瓶主人名称bottleusername，漂流时间drifttime
	 * @return >0 新建成功 =0新建失败
	 */
	int insertBottle(Bottle bottle);
	public int selectBottleCountSum(int userid);
	public List<Bottle> selectMyBottleByPageNum(int pageNum, int userid);
	public int deleteBottle(int bottleid);
}
