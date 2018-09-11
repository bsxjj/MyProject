package com.xjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.Product;

public interface ProductDao {
	
	List<Product> findHot(); //查询热门商品
	List<Product> findNew();//查询最新商品
    Product findByPid(Integer  pid);// 根据商品ID查询商品
	int findCountCid(Integer cid);// 根据分类id查询商品的个数
	// 根据分类id查询商品的集合
	List<Product> findByPageCid(@Param("cid")Integer cid, 
			@Param("begin")int begin, @Param("pageSize")int pageSize);
	//根据二级分类id查询商品数量
	int findCountCsid(Integer csid);
	//根据二级分类id查询商品信息
	List<Product> findByPageCsid(@Param("csid")Integer csid, 
			@Param("begin")int begin, @Param("pageSize")int pageSize);
	//增加商品
	int insertProduct(Product product);
	//删除商品
	int deleteProduct(Integer pid);
	//更新商品
	int updateProduct(Product product);
	//查询所有商品数量
	int findCount();
	//分页查询所有商品
	List<Product> findByPage(@Param("begin")int begin,@Param("pageSize")int pageSize);
	//查询所有商品
	List<Product> findAll();

}
