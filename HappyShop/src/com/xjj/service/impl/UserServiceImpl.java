package com.xjj.service.impl;

import com.xjj.entity.User;
import com.xjj.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjj.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;//对象属性

	//注册
	@Override
	public int register(User user) {
		System.out.println("注册用户");
		return userDao.insertUser(user);
	}

	//检测用户名是否存在
	@Override
	public boolean findByUserName(String username) {
		return userDao.findByUserName(username) != null ? true:false;
	}

	//登录
	@Override
	public User login(String username, String password) {
		System.out.println("用户登录");
		return userDao.findByUsernameAndPwd(username, password);
	}

}
