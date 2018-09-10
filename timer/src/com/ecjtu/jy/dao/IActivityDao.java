package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Activity;

/**
 * 活动层接口
 * @author 建伟
 * @date 20180726
 * @version 1.0
 */
public interface IActivityDao {

	/**
	 * 插入活动
	 * @param activity 活动实例
	 * @return >0插入成功 =0插入失败
	 */
	int insertActivity(Activity activity);
	
	/**
	 * 删除活动
	 * @param activityid 活动id
	 * @return >0删除成功 =0删除失败
	 */
	int deleteActivity(int activityid);
	
	/**
	 * 更新活动
	 * @param activity 活动实例
	 * @return
	 */
	int updateActivity(Activity activity);
	
	/**
	 * 查询所有活动并进行分页
	 * @param pageNum 页号
	 * @return 活动集合
	 */
	List<Activity>selectActivityByPageNum(int pageNum);
	
	/**
	 * 获取所有活动的个数
	 * @return 总数
	 */
	int selectActivityCountNum();
	
	/**
	 * 查询我发起的项目
	 * @param userid 用户id
	 * @return
	 */
	List<Activity> selectMyStartActivityByPageNum(int userid);
	
	
	
	
	
	
	
	
	
	
	
}
