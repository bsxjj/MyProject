package com.xjj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjj.dao.CategorySecondDao;
import com.xjj.entity.CategorySecond;
import com.xjj.service.CategorySecondService;
import com.xjj.util.PageBean;

@Service
public class CategorySecondServiceImpl implements CategorySecondService {
	
	@Autowired
	CategorySecondDao categorySecondDao;

	@Override
	public int insert(CategorySecond categorySecond) {
		return categorySecondDao.insert(categorySecond);
	}

	@Override
	public int delete(Integer csid) {
		return categorySecondDao.delete(csid);
	}

	@Override
	public int update(CategorySecond categorySecond) {
		return categorySecondDao.update(categorySecond);
	}

	@Override
	public CategorySecond findById(Integer csid) {
		return categorySecondDao.findById(csid);
	}

	@Override
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}

	@Override
	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		pageBean.setPage(page);
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<CategorySecond> list = categorySecondDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

}
