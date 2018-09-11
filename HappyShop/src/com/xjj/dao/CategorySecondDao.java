package com.xjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.CategorySecond;

public interface CategorySecondDao {
	
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
	//��ѯ���ж��������б���ܼ�¼��
	int findCount();
	//��ҳ��ѯ���ж��������б�
	List<CategorySecond> findByPage(@Param("begin")int begin,@Param("pageSize")int pageSize);

}
