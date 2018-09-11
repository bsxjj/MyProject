package com.xjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.Order;
import com.xjj.entity.OrderItem;

public interface OrderDao {
	
	//保存订单额
	int saveOrder(Order order);
	//统计订单数量
	int findCountByUid(Integer uid);
	//分页查询
	List<Order> findPageByUid(@Param("uid")Integer uid,
			@Param("begin")int begin,@Param("pageSize")int pageSize);
	//根据订单id查询订单
	Order findByOid(Integer oid);
	//更新订单
	void update(Order order);
	//查询所有订单数量
	int findCount();
	//分页查询所有订单
	List<Order> findByPage(@Param("begin")int begin, @Param("pageSize")int pageSize);
	//后台根据订单id查询订单
	List<OrderItem> findOrderItemByOid(Integer oid);

}
