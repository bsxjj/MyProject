package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Interest;

/**
 * 用户兴趣服务接口
 * @author 建伟
 * @date 20180726
 * @version 1.0
 */
public interface IInterstService {

	/**
	 * 用户新增兴趣
	 * @param interest 兴趣实体类
	 * @return >0 插入成功 =0 插入失败
	 */
	int insertInterst(Interest interest);
	
	/**
	 * 批量插入
	 * @param interests 兴趣集合
	 * @return 
	 */
	int insertIntersts(List<Interest>interests);
	
	/**
	 * 根据兴趣id删除兴趣
	 * @param interid 兴趣id
	 * @param userid 用户id
	 * @return >0 删除成功 =0 删除失败
	 */
	int deleteInterst(int interid,int userid);
	
	/**
	 * 根据id数组来批量删除
	 * @param ids 兴趣id数组
	 * @param userid 用户id
	 * @return
	 * sql参考 delete from table where id in(?,?,?)
	 */
	int deleteIntersts(int []ids,int userid);
	

	/**
	 * 根据用户的id来查询用户的兴趣
	 * @param userid 用户id
	 * @return 兴趣集合
	 */
	List<Interest> selectIntersts(int userid);
}
