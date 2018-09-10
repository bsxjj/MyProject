package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Activity;

/**
 * 活动逻辑层
 * @author 建伟
 * @date 20180726
 * @version
 */
public interface IActivityService {

	
	/**
	 * 创建活动
	 * @param activity 活动实例
	 * @return >0创建成功 =0创建失败
	 */
	int insertActivity(Activity activity);
	
	
	/**
	 * 加入活动 进行并发控制，实现单一访问(注意自己不能加入活动，因为自己已经在活动里了)
	 * @param activityid 活动id
	 * @param userid 用户id
	 * @return >0加入成功 =0加入失败
	 */
	int joinActivity(int activityid,int userid);
	
	/**
	 * 删除我创建的活动(删除时通知每一个参与者该活动已取消,通知采取私信的形式，
	 * 发件人为系统通知内容为尊敬的用户，您参加的xxx活动已被发起人取消)
	 * @param activityid
	 * @param userid
	 * @return 
	 */
	int deleteActivity(int activityid);
	
	/**
	 * 此为公共查询活动方法按分页进行(注意要排除过期的活动，超过截至日期的活动要排除)
	 * 活动pojo类新加了已参加人数的属性
	 * 查询活动时同时也要查询已参加人数并用set方法进行设置
	 * @param pageNum 页号
	 * @return 活动集合
	 */
	List<Activity> selectActivityByPageNum(int pageNum);
	
	/**
	 * 查询我发起的活动(分页)
	 * 查询活动时同时也要查询已参加人数并用set方法进行设置
	 * @param userid 用户id
	 * @return 活动集合
	 */
	List<Activity> selectMyStartActivity(int pageNum,int userid);
	
	/**
	 * 退出活动，当用户退出活动时系统向用户发出私信，私信类型为系统通知 ，告知发起人xxx用户退出该活动
	 * @param userid 用户id
	 * @param activityid 活动id
	 * @return
	 */
	int outActivity(int userid,int activityid);
	
}
