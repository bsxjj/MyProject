package com.xjj.dao;

import java.util.List;

import com.xjj.entity.Category;

public interface CategoryDao {
	
	List<Category> findAll();//��ѯ���е�һ�������
	int insertCategory(String cname);//����һ�������б�
	int deleteCategory(Integer cid);//ɾ��һ������
	int updateCategory(Category category);//�޸�һ������
	Category findById(Integer cid);//����cid��ѯһ������
	List<Category> findAllWithAdmin();//��̨��ѯ���е�һ�������

}
