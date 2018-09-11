package com.xjj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjj.dao.ProductDao;
import com.xjj.entity.Product;
import com.xjj.service.ProductService;
import com.xjj.util.PageBean;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findHot() {
		return productDao.findHot();
	}

	@Override
	public List<Product> findNew() {
		return productDao.findNew();
	}

	@Override
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	@Override
	public PageBean<Product> findByPageCid(Integer cid,Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//设置总记录数
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid);
		//System.out.println("总记录数："+totalCount);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else {
			totalPage = totalCount / pageSize + 1;
		}
		System.out.println("总页数："+totalPage);
		pageBean.setTotalPage(totalPage);
		//每页显示的数据：从哪开始
		int begin = (page-1)*pageSize;
		List<Product> list = productDao.findByPageCid(cid, begin, pageSize);
		System.out.println("分页显示的list："+list);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Product> findByPageCsid(Integer csid, Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		System.out.println(page);
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//设置总记录数
		int totalCount = 0;
		totalCount = productDao.findCountCsid(csid);
		//System.out.println("二级分类的总记录数："+totalCount);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else {
			totalPage = totalCount / pageSize + 1;
		}
		//System.out.println("总页数："+totalPage);
		pageBean.setTotalPage(totalPage);
		//每页显示的数据：从哪开始
		int begin = (page-1)*pageSize;
		List<Product> list = productDao.findByPageCsid(csid, begin, pageSize);
		//System.out.println("二级分页显示的list："+list);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public int insertProduct(Product product) {
		return productDao.insertProduct(product);
	}

	@Override
	public int deleteProduct(Integer pid) {
		return productDao.deleteProduct(pid);
	}
	
	@Override
	public int updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	@Override
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPage(page);
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		int totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<Product> list = productDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

}
