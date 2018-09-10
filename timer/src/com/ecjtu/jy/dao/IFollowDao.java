package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Follow;

/**
 * 用户关注层接口
 * @author 建伟
 * @date 20180724
 * @version 1.0
 */
public interface IFollowDao {

	/**
	 * 根据页号来查询所关注的人
	 * @param pageNum 页号 每页限制10人
	 * @param id 关注者id
	 * @param type type不做查询条件，只做区别查询关注列表还是粉丝列表
	 * 若type为0表示执行查询关注的人的查询，type为1表示执行查询关注我的人的查询
	 * @return 被关注者的集合 或关注者的集合
	 */
	List<Follow> selectFollowByPageNum(int pageNum,int id,int type);
	
	/**
	 * 获取所关注的人的总数
	 * @param id 关注者id
	 * @param type不做查询条件，只做区别查询关注列表数量还是粉丝列表数量
	 * 若type为0表示执行查询关注的人的数量查询，type为1表示执行查询关注我的人的数量查询
	 * @return 被关注者总数
	 */
	int selectFollowUserCount(int id,int type);
	
	/**
	 * 根据id来查询Follow
	 * @param id 关注者id或被关注者id
	 * @param type type不做查询条件，只做区别查询关注者还是粉丝
	 * 若type为0表示执行查询关注的人的查询，type为1表示执行查询粉丝的查询
	 * @return
	 */
	Follow selectFollowById(int id,int type);
	
	/**
	 * 取消关注
	 * @param id 本身id作为followerid
	 * @return >0表示取关成功  =0取关失败
	 */
	int deleteFollowById(int id);
	
	/**
	 * 关注
	 * @param follow 关注参数
	 * @return 返回 >0关注成功  =0关注失败
	 */
	int insertFollow(Follow follow);
	
	/**
	 * 查看是否已经关注
	 * @param userid 该用户id
	 * @param myid 我的id
	 * @return true 已关注 false未关注
	 * 
	 */
	boolean isFocus(int userid,int myid);
	
	
	/**
	 * 根据用户之间的关系进行取关
	 * @param follow
	 * @return
	 */
	int deleteFollowByFollow(Follow follow);
}
