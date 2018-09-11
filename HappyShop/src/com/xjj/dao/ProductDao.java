package com.xjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.Product;

public interface ProductDao {
	
	List<Product> findHot(); //��ѯ������Ʒ
	List<Product> findNew();//��ѯ������Ʒ
    Product findByPid(Integer  pid);// ������ƷID��ѯ��Ʒ
	int findCountCid(Integer cid);// ���ݷ���id��ѯ��Ʒ�ĸ���
	// ���ݷ���id��ѯ��Ʒ�ļ���
	List<Product> findByPageCid(@Param("cid")Integer cid, 
			@Param("begin")int begin, @Param("pageSize")int pageSize);
	//���ݶ�������id��ѯ��Ʒ����
	int findCountCsid(Integer csid);
	//���ݶ�������id��ѯ��Ʒ��Ϣ
	List<Product> findByPageCsid(@Param("csid")Integer csid, 
			@Param("begin")int begin, @Param("pageSize")int pageSize);
	//������Ʒ
	int insertProduct(Product product);
	//ɾ����Ʒ
	int deleteProduct(Integer pid);
	//������Ʒ
	int updateProduct(Product product);
	//��ѯ������Ʒ����
	int findCount();
	//��ҳ��ѯ������Ʒ
	List<Product> findByPage(@Param("begin")int begin,@Param("pageSize")int pageSize);
	//��ѯ������Ʒ
	List<Product> findAll();

}
