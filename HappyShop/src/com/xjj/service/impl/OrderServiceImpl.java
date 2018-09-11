package com.xjj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjj.dao.OrderDao;
import com.xjj.entity.Order;
import com.xjj.entity.OrderItem;
import com.xjj.service.OrderService;
import com.xjj.util.PageBean;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public int saveOrder(Order order) {
		return orderDao.saveOrder(order);
	}

	@Override
	public int findCountByUid(Integer uid) {
		return orderDao.findCountByUid(uid);
	}

	@Override
	public PageBean<Order> findPageByUid(Integer uid,int page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示数
		int pageSize = 5;
		pageBean.setPage(pageSize);
		//设置总记录数
		int totalCount = 0;
		totalCount = orderDao.findCountByUid(uid);
		System.out.println("总记录数："+totalCount);
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
		List<Order> list = orderDao.findPageByUid(uid, begin, pageSize);
		System.out.println("分页显示的list："+list);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}

	
	//修改订单状态
	@Override
	public void update(Order order) {
		orderDao.update(order);
	}

	@Override
	public PageBean<Order> findByPage(Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		pageBean.setPage(page);
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		int totalCount = orderDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<Order> list = orderDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	//后台显示订单详情功能
	// 业务层查询订单项的方法
	public List<OrderItem> findOrderItemByOid(Integer oid) {
		return orderDao.findOrderItemByOid(oid);
	}

}
