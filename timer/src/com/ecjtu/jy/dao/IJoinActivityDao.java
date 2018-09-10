package com.ecjtu.jy.dao;



import com.ecjtu.jy.pojo.JoinActivity;

/**
 * 加入活动层接口
 * @author 建伟
 * @date 20180724
 * @version 1.0
 */
public interface IJoinActivityDao {

	/**
	 * 加入活动
	 * @param joinActivity 加入活动实体类
	 * @return >0新增成功  =0新增失败
	 */
	int insertJoinActivity(JoinActivity joinActivity);
	
	/**
	 * 取消参加该活动
	 * @param id 参加活动表id
	 * @return
	 */
	int deleteJoinActivity(int jid);
	
	/**
	 * 根据活动id来查询该活动有多少人参加了
	 * @param activityid
	 * @return 参加的人数
	 */
	int selectActivityCount(int activityid);
	
	
	
	
}
