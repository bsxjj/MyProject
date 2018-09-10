package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Interview;

/**
 * 访客记录层接口
 * @author 建伟
 * @date 20180724
 * @version 1.0
 */
public interface IInterviewDao {

	/**
	 * 新增访客记录
	 * @param interview 访客记录实体类
 	 * @return >0新增成功  =0新增失败
	 */
	int insertInterview(Interview interview);
	
	/**
	 * 根据访客记录id进行删除
	 * @param interid 访客记录id
	 * @return >0删除成功  =0删除失败
	 */
	int deleteInterview(int interid);
	
	/**
	 * 根据页号及用户id进行查询
	 * @param pageNum 页号每页限制10
	 * @param userid 用户id
	 * @return
	 */
	List<Interview> selectInterviewByPageNum(int pageNum,int userid);
	
	
	
	
	
}
