package com.xjj.service;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.Admin;

public interface AdminService {
	
	//��¼
	Admin login(@Param("username")String username,@Param("password")String password);

}
