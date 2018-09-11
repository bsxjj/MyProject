package com.xjj.service;

import java.util.List;

import com.xjj.entity.CategorySecond;
import com.xjj.util.PageBean;

public interface CategorySecondService {
	
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
	//分页查询所有二级分类列表
	PageBean<CategorySecond> findByPage(Integer page);

}
