package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.FeedBack;

/**
 * 反馈获取服务接口
 * @author 建伟
 * @date 20180726
 * @version 1.0
 */
public interface IFeedBackService {

	
	/**
	 * 添加反馈
	 * @param feedBack 反馈实例
	 * @return >0成功 =0失败
	 */
	int insertFeedBack(FeedBack feedBack);
	
	/**
	 * 
	 * 更改反馈信息状态
	 * @param feedBack
	 * @return
	 */
	int updateFeedBack(FeedBack feedBack);
	
	/**
	 * 根据id来删除用户反馈
	 * @param id 反馈id
	 * @return >0删除成功  =0删除失败
	 */
	int delectFeedBack(int id);
	
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
	
}
