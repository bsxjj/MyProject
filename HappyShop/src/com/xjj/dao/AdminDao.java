package com.xjj.dao;

import org.apache.ibatis.annotations.Param;

import com.xjj.entity.Admin;

public interface AdminDao {
	
	//��¼
	Admin login(@Param("username")String username,@Param("password")String password);

}
