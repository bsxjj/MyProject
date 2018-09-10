package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.PrivateLetter;

public interface IPrivateLetterService {

	/**
	 * 插入私信
	 * @param letter 私信实体类
	 * @return >0插入成功 =0插入失败
	 */
	int insertPrivateLetter(PrivateLetter letter);
	
	/**
	 * 根据用户与用户的id来删除私信
	 * @param user1id 用户1id
	 * @param user2id 用户2id
	 * @return>0删除成功 =0删除失败
	 */
	int deletePrivateLetter(int user1id,int user2id);
	
	/**
	 * 根据私信id来删除私信
	 * @param letterid
	 * @return >0删除成功 =0删除失败
	 */
	int deletePrivateLetterById(int letterid);
	
	/**
	 * 根据用户id与页号来查询私信
	 * @param pageNum 页号 每页限制10条
	 * @param userid 用户id
	 * @return 私信集合
	 */
	List<PrivateLetter> selectLetterByPageNum(int pageNum,int userid);
	
	/**
	 * 根据用户id查看用户私信的个数
	 * @param userid
	 * @return 私信个数
	 */
	int selectLetterCount(int userid);
	
	/**
	 * 获取用户未读私信内容个数
	 * @param userid 用户id
	 * @return 未读信息总数
	 */
	int selectLetterCountByNotRead(int userid);
	
	/**
	 * 获取用户已读私信内容个数
	 * @param userid 用户id
	 * @return 已读信息总数
	 */
	int selectLetterCountByIsRead(int userid);
	
	/**
	 * 根据用户id与页号来查询私信
	 * @param pageNum 页号 每页限制10条
	 * @param userid 用户id
	 * @param type 0 未读 1已读 不做参数，只作标识是查询已读还是未读的私信
	 * @return 私信集合
	 */
	List<PrivateLetter> selectLetterByPageNum(int pageNum,int userid,int type);
	
	/**
	 * 依据crid来查询私信
	 * @param crid
	 * @return
	 */
	public List<PrivateLetter> selectLetterUserList(int crid,int userid);
	
}
