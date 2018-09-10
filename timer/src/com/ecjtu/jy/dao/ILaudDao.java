package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Laud;

/**
 * 用户点赞层接口
 * @author 建伟
 * @date 20180724
 * @version 1.0
 */
public interface ILaudDao {

	/**
	 * 增加用户点赞
	 * @param laud 点赞实体类
	 * @return >0增加成功 =0增加失败
	 */
	int insertLaud(Laud laud);
	
	/**
	 * 取消点赞
	 * @param txtid 图文id
	 * @param userid 用户id
	 * @return >0取消成功 =0取消失败
	 */
	int deleteLaud(int userid,int txtid);
	
	/**
	 * 根据图文id来获取其获赞个数
	 * @param txtid 图文id
	 * @return 获赞总数
	 */
	int selectLaudCount(int txtid);
	
	/**
	 * 根据图文id获取点赞实例
	 * @param txtid 图文id
	 * @return
	 */
	List<Laud>selectLaud(int txtid);
	
	/**
	 * 查看用户是否给该图文点赞
	 * @param userid 用户id
	 * @param txtid 图文id
	 * @return >0是  =0 没有
	 */
	int isLaud(int userid,int txtid);
	
	
	
}
