package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Follow;

/**
 * 粉丝，关注服务接口层
 * @author 建伟
 * @date 20180726
 * @version 1.0
 */
public interface IFollowService {

	/**
	 * 增加关注(添加关注)
	 * @param follw 关注实例
	 * @return >0成功  =0失败
	 */
	int insertFocus(Follow follw);
	
	/**
	 * 删除关注(取消关注)
	 * @param follow 关注实例
	 * @return >0成功  =0失败
	 */
	int deleteFocus(Follow follow);
	
	/**
	 * 分页获取所关注的人
	 * @param userid 用户id
	 * @param pageNum 页号
	 * @return 关注集合
	 */
	List<Follow> selectFocusByPageNum(int userid,int pageNum);
	
	/**
	 * 获取关注的人的总数
	 * @param userid 用户id
	 * @return 所关注的人的总数
	 */
	int selectFocusCountNum(int userid);
	
	/**
	 * 分页获取粉丝集合
	 * @param userid 用户id
	 * @param pageNum 页号
	 * @return 粉丝集合
	 */
	List<Follow> selectFansByPageNum(int userid,int pageNum);
	
	/**
	 * 获取粉丝总数
	 * @param userid 用户id
	 * @return 粉丝总数
	 */
	int selectFansCountNum(int userid);
	
	public boolean isFocus(int userid, int myid);
	
	
	public int deleteFollowByFollow(Follow follow);
	
}
