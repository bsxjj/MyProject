package com.xjj.service;

import java.util.List;

import com.xjj.entity.OrderItem;

public interface OrderItemService {
	
	//���涩����
	int saveOrderItem(OrderItem orderItem);
	//����id��ѯ������Ϣ
	List<OrderItem> findByOid(Integer oid);

}
