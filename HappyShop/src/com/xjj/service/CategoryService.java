package com.xjj.service;

import java.util.List;

import com.xjj.entity.Category;

public interface CategoryService {
	
	List<Category> showAll();//��ѯ���е�һ�������
	int saveCategory(String cname);//����һ������
	int deleteCategory(Integer cid);//ɾ��һ������
	int updateCategory(Category category);//�޸�һ������
	Category findById(Integer cid);//����cid��ѯһ������
	List<Category> findAllWithAdmin();//��̨��ѯ���е�һ�������

}
