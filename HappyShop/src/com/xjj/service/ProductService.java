package com.xjj.service;

import java.util.List;

import com.xjj.entity.Product;
import com.xjj.util.PageBean;

public interface ProductService {
	
	List<Product> findHot(); //查询热门商品
	List<Product> findNew();//查询最新商品
	Product findByPid(Integer  pid);// 根据商品ID查询商品
	//根据一级分类的cid分页查询商品
	PageBean<Product> findByPageCid(Integer cid, Integer page);
	//根据二级分类的csid分页查询商品信息
	PageBean<Product> findByPageCsid(Integer csid, Integer page);
	//增加商品
	int insertProduct(Product product);
	//删除商品
	int deleteProduct(Integer pid);
	//更新商品
	int updateProduct(Product product);
	//分页查询所有商品
	PageBean<Product> findByPage(Integer page);
	List<Product> findAll();

}
