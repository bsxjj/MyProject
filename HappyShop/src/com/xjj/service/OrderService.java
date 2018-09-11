package com.xjj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.Order;
import com.xjj.entity.OrderItem;
import com.xjj.util.PageBean;

public interface OrderService {
	
	//保存订单额
	int saveOrder(Order order);
	//统计订单数量
	int findCountByUid(Integer uid);
	//分页查询
	PageBean<Order> findPageByUid(Integer uid,int page);
	//根据订单id查询订单
	Order findByOid(Integer oid);
	//更新订单,修改订单状态
	void update(Order order);
	//分页查询所有订单
	PageBean<Order> findByPage(Integer page);
	//后台根据订单id查询订单项
	List<OrderItem> findOrderItemByOid(Integer oid);
	
}
