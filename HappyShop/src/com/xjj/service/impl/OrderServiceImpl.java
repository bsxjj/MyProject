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
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ��
		int pageSize = 5;
		pageBean.setPage(pageSize);
		//�����ܼ�¼��
		int totalCount = 0;
		totalCount = orderDao.findCountByUid(uid);
		System.out.println("�ܼ�¼����"+totalCount);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else {
			totalPage = totalCount / pageSize + 1;
		}
		System.out.println("��ҳ����"+totalPage);
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݣ����Ŀ�ʼ
		int begin = (page-1)*pageSize;
		List<Order> list = orderDao.findPageByUid(uid, begin, pageSize);
		System.out.println("��ҳ��ʾ��list��"+list);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}

	
	//�޸Ķ���״̬
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
	//��̨��ʾ�������鹦��
	// ҵ����ѯ������ķ���
	public List<OrderItem> findOrderItemByOid(Integer oid) {
		return orderDao.findOrderItemByOid(oid);
	}

}
