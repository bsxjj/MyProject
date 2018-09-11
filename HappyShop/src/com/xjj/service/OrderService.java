package com.xjj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.Order;
import com.xjj.entity.OrderItem;
import com.xjj.util.PageBean;

public interface OrderService {
	
	//���涩����
	int saveOrder(Order order);
	//ͳ�ƶ�������
	int findCountByUid(Integer uid);
	//��ҳ��ѯ
	PageBean<Order> findPageByUid(Integer uid,int page);
	//���ݶ���id��ѯ����
	Order findByOid(Integer oid);
	//���¶���,�޸Ķ���״̬
	void update(Order order);
	//��ҳ��ѯ���ж���
	PageBean<Order> findByPage(Integer page);
	//��̨���ݶ���id��ѯ������
	List<OrderItem> findOrderItemByOid(Integer oid);
	
}
