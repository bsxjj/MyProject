package com.xjj.dao;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.User;

public interface UserDao {
	
	int insertUser(User user);//�����û�
	User findByUserName(String username);//ͨ���������ֲ�ѯ�û����Ƿ����
	//��ѯ��¼ҳ��������û����������Ƿ����
	User findByUsernameAndPwd(@Param("username")String username,
			@Param("password")String password);

}
