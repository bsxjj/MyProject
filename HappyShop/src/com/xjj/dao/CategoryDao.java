package com.xjj.dao;

import java.util.List;

import com.xjj.entity.Category;

public interface CategoryDao {
	
	List<Category> findAll();//查询所有的一级分类表
	int insertCategory(String cname);//增加一级分类列表
	int deleteCategory(Integer cid);//删除一级分类
	int updateCategory(Category category);//修改一级分类
	Category findById(Integer cid);//根据cid查询一级分类
	List<Category> findAllWithAdmin();//后台查询所有的一级分类表

}
