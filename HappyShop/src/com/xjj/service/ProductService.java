package com.xjj.service;

import java.util.List;

import com.xjj.entity.Product;
import com.xjj.util.PageBean;

public interface ProductService {
	
	List<Product> findHot(); //��ѯ������Ʒ
	List<Product> findNew();//��ѯ������Ʒ
	Product findByPid(Integer  pid);// ������ƷID��ѯ��Ʒ
	//����һ�������cid��ҳ��ѯ��Ʒ
	PageBean<Product> findByPageCid(Integer cid, Integer page);
	//���ݶ��������csid��ҳ��ѯ��Ʒ��Ϣ
	PageBean<Product> findByPageCsid(Integer csid, Integer page);
	//������Ʒ
	int insertProduct(Product product);
	//ɾ����Ʒ
	int deleteProduct(Integer pid);
	//������Ʒ
	int updateProduct(Product product);
	//��ҳ��ѯ������Ʒ
	PageBean<Product> findByPage(Integer page);
	List<Product> findAll();

}
