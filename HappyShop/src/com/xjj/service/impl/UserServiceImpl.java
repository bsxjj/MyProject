package com.xjj.service.impl;

import com.xjj.entity.User;
import com.xjj.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjj.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;//��������

	//ע��
	@Override
	public int register(User user) {
		System.out.println("ע���û�");
		return userDao.insertUser(user);
	}

	//����û����Ƿ����
	@Override
	public boolean findByUserName(String username) {
		return userDao.findByUserName(username) != null ? true:false;
	}

	//��¼
	@Override
	public User login(String username, String password) {
		System.out.println("�û���¼");
		return userDao.findByUsernameAndPwd(username, password);
	}

}
