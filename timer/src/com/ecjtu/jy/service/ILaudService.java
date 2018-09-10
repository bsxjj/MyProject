package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Laud;

/**
 * 点赞业务逻辑层
 * @author 建伟
 * @date 20180726
 * @version 1.0
 */
public interface ILaudService {

	/**
	 * 实现点赞 并发控制
	 * @param laud 点赞实体类
	 * @return >0成功  =0失败
	 */
	int insertLaud(Laud laud);
	
	/**
	 * 取消点赞
	 * @param txtid 
	 * @return
	 */
	int deleteLaud(int userid,int txtid);
	
	/**
	 * 获取点赞数
	 * @param txtid 图文id
	 * @return
	 */
	int selectLaudCount(int txtid);
	
	
	/**
	 * 获取点赞实体类
	 * @param txtid 图文id
	 * @return
	 */
	List<Laud>selectLaud(int txtid);
	
	
	/**
	 * 判断是否点了赞
	 * @param userid 用户id
	 * @param txtid 图文id
	 * @return
	 */
	int isLaud(int userid,int txtid);
	
	
	
}
