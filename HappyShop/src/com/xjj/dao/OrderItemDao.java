package com.xjj.dao;

import java.util.List;

import com.xjj.entity.OrderItem;

public interface OrderItemDao {
	
	//���涩����
	int saveOrderItem(OrderItem orderItem);
	//����id��ѯ������Ϣ
	List<OrderItem> findByOid(Integer oid);

}
