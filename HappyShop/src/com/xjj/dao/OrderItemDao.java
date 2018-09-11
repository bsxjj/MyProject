package com.xjj.dao;

import java.util.List;

import com.xjj.entity.OrderItem;

public interface OrderItemDao {
	
	//保存订单项
	int saveOrderItem(OrderItem orderItem);
	//根据id查询订单信息
	List<OrderItem> findByOid(Integer oid);

}
