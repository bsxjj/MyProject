package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.FeedBack;

/**
 * 用户反馈接口层
 * @author 建伟
 * @date 20180724
 * @version 1.0
 */
public interface IFeedBackDao {

	/**
	 * 根据页号来获取用户反馈数据
	 * @param pageNum 页号 每页限制10条
	 * @return 
	 */
	List<FeedBack> selectFeedBackByPageNum(int pageNum);
	
	/**
	 * 获取用户反馈的总数
	 * @return 总数
	 */
	int selectFeedBackSum();
	
	/**
	 * 根据id查询具体的反馈内容
	 * @param id 反馈id
	 * @return 反馈实体类
	 */
	FeedBack selectFeedBackById(int id);
	
	/**
	 * 根据id来删除用户反馈
	 * @param id 反馈id
	 * @return >0删除成功  =0删除失败
	 */
	int delectFeedBack(int id);
	
	/**
	 * 更新用户反馈状态，已读和未读两种
	 * @param state
	 * @return
	 */
	int updateFeedBackState(FeedBack feedBack);
	public int insertFeedBack(FeedBack feedBack);
}
