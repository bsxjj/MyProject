package com.xjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.Order;
import com.xjj.entity.OrderItem;

public interface OrderDao {
	
	//���涩����
	int saveOrder(Order order);
	//ͳ�ƶ�������
	int findCountByUid(Integer uid);
	//��ҳ��ѯ
	List<Order> findPageByUid(@Param("uid")Integer uid,
			@Param("begin")int begin,@Param("pageSize")int pageSize);
	//���ݶ���id��ѯ����
	Order findByOid(Integer oid);
	//���¶���
	void update(Order order);
	//��ѯ���ж�������
	int findCount();
	//��ҳ��ѯ���ж���
	List<Order> findByPage(@Param("begin")int begin, @Param("pageSize")int pageSize);
	//��̨���ݶ���id��ѯ����
	List<OrderItem> findOrderItemByOid(Integer oid);

}
