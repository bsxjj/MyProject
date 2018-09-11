package com.xjj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjj.dao.AdminDao;
import com.xjj.entity.Admin;
import com.xjj.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin login(String username, String password) {
		return adminDao.login(username, password);
	}

}
