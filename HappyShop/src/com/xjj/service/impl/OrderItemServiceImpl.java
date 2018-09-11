package com.xjj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjj.dao.OrderItemDao;
import com.xjj.entity.OrderItem;
import com.xjj.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemDao orderItemDao;

	@Override
	public int saveOrderItem(OrderItem orderItem) {
		return orderItemDao.saveOrderItem(orderItem);
	}

	@Override
	public List<OrderItem> findByOid(Integer oid) {
		return null;
	}

}
