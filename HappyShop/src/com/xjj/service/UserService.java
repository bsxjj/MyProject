package com.xjj.service;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.User;

public interface UserService {
	
	int register(User user);//�����û�
	boolean findByUserName(String username);//ͨ���������ֲ�ѯ�û����Ƿ����
	//��ѯ��¼ҳ��������û����������Ƿ����
	User login(@Param("username")String username,
			@Param("password")String password);

}
