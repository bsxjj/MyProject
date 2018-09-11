package com.xjj.service;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.User;

public interface UserService {
	
	int register(User user);//增加用户
	boolean findByUserName(String username);//通过查找名字查询用户名是否存在
	//查询登录页面输入的用户名和密码是否存在
	User login(@Param("username")String username,
			@Param("password")String password);

}
