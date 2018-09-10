package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.InterestSort;

/**
 * 兴趣分类服务接口层
 * @author 建伟
 * @date 20180726
 * @version 1.0
 */
public interface IInterstSortService {

	/**
	 * 增加用户兴趣分类
	 * @param interSort 兴趣分类
	 * @return >0插入成功   =0 插入失败
	 */
	int insertInterSort(InterestSort interSort);
	
	/**
	 * 根据兴趣id来删除兴趣
	 * @param id 兴趣id
	 * @return >0删除成功   =0 删除失败
	 */
	int deleteInterstSort(int id);
	
	
	/**
	 * 修改用户兴趣分类
	 * @param interSort 用户兴趣分类
	 * @return >0更新成功   =0 更新失败
	 */
	int updateInterstSort(InterestSort interSort);
	
	
	/**
	 * 分页进行兴趣查询
	 * @param pageNum 页号 每页限制10条
	 * @return 兴趣分类集合
	 */
	List<InterestSort> selectInterSorts(int pageNum);
	
	
	
}
