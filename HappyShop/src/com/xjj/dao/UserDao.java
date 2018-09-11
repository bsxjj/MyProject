package com.xjj.dao;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.User;

public interface UserDao {
	
	int insertUser(User user);//增加用户
	User findByUserName(String username);//通过查找名字查询用户名是否存在
	//查询登录页面输入的用户名和密码是否存在
	User findByUsernameAndPwd(@Param("username")String username,
			@Param("password")String password);

}
