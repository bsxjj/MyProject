package com.ecjtu.jy.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//import util.DBFactory;

/**
 * @author : yao
 * @date 创建时间：2017年7月24日 上午11:11:34
 * @version 1.0
 * 
 */
public class C3P0Util {

	
	private static DataSource ds = new ComboPooledDataSource();
	private static C3P0Util c3p0Util = new C3P0Util();
	private C3P0Util(){}
	
	public static Connection getConnection() throws SQLException {

		return c3p0Util.getC3P0Conn();
	}

	private Connection getC3P0Conn() throws SQLException{
		return ds.getConnection();
	}
}
