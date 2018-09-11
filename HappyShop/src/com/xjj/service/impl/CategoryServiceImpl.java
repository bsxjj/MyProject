package com.xjj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjj.dao.CategoryDao;
import com.xjj.entity.Category;
import com.xjj.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> showAll() {
		return categoryDao.findAll();
	}

	@Override
	public int saveCategory(String cname) {
		return categoryDao.insertCategory(cname);
	}

	@Override
	public int deleteCategory(Integer cid) {
		return categoryDao.deleteCategory(cid);
	}

	@Override
	public int updateCategory(Category category) {
		return categoryDao.updateCategory(category);
	}

	@Override
	public Category findById(Integer cid) {
		return categoryDao.findById(cid);
	}

	@Override
	public List<Category> findAllWithAdmin() {
		
		return categoryDao.findAllWithAdmin();
	}

}
