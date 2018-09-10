package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Message;

/**
 * 留言层接口
 * @author 建伟
 * @date 20180724
 * @version 1.0
 */
public interface IMessageDao {

	/**
	 * 新增留言
	 * @param mess 留言实体类
	 * @return >0留言成功 =0留言失败
	 * 
	 */
	int insertMessage(Message mess);
	/**
	 * 根据留言id删除留言
	 * @param id 留言表id
	 * @return >0删除成功 =0删除失败
	 */
	int deleteMessage(int id);
	
	/**
	 * 根据页号及被留言人id来查询留言
	 * @param pageNum 页号
	 * @param userid 被留言人id
	 * @return 留言集合
	 */
	List<Message> selectMessagesByPageNum(int pageNum,int userid);
	
	
	/**
	 * 根据被留言用户id来查询留言总数
	 * @param userid 被留言id
	 * @return 留言总数
	 */
	int selectMessageCount(int userid);
	
	
	
	
	
}
