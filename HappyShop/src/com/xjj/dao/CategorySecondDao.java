package com.xjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.CategorySecond;

public interface CategorySecondDao {
	
	//增加二级分类列表
	int insert(CategorySecond categorySecond);
	//删除二级分类列表
	int delete(Integer csid);
	//修改二级分类列表
	int update(CategorySecond categorySecond);
	//根据id查询二级分类列表
	CategorySecond findById(Integer csid);
	//查询所有二级分类列表
	List<CategorySecond> findAll();
	//查询所有二级分类列表的总记录数
	int findCount();
	//分页查询所有二级分类列表
	List<CategorySecond> findByPage(@Param("begin")int begin,@Param("pageSize")int pageSize);

}
