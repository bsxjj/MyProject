package com.xjj.service;

import java.util.List;

import com.xjj.entity.CategorySecond;
import com.xjj.util.PageBean;

public interface CategorySecondService {
	
	//���Ӷ��������б�
	int insert(CategorySecond categorySecond);
	//ɾ�����������б�
	int delete(Integer csid);
	//�޸Ķ��������б�
	int update(CategorySecond categorySecond);
	//����id��ѯ���������б�
	CategorySecond findById(Integer csid);
	//��ѯ���ж��������б�
	List<CategorySecond> findAll();
	//��ҳ��ѯ���ж��������б�
	PageBean<CategorySecond> findByPage(Integer page);

}
