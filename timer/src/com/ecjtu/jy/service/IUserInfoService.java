package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.UserInfo;

public interface IUserInfoService {
	
	/**
	 * 用于验证登陆
	 * @param userName 用户名
	 * @param password 密码
	 * @return 返回UserInfo实体类
	 */
	UserInfo selectUserByPassAndUserName(String userName,String password);
	
	/**
	 * 验证用户名是否存在
	 * @param userName 用户名
	 * @return type int 
	 * 1 或 > 0-存在    0-表示用户名不存在可以使用 
	 */
	int validateUserName(String userName);
	
	/**
	 * 验证email是否已存在
	 * @param email
	 * @return 1 或 > 0-存在    0-表示email不存在可以使用 
	 */
	int validateEmail(String email);
	
	/**
	 * 根据用户id来查询单个用户
	 * @param id 用户id
	 * @return 返回用户实体类
	 */
	UserInfo selectUserById(int id);
	
	/**
	 * 模糊查询根据模糊词来查询用户
	 * @param likeName 模糊词
	 * @return 返回用户集合
	 */
	List<UserInfo> selectUsersById(String likeName);
	
	/**
	 * 插入用户
	 * @param user 用户类，仅有注册时的信息与默认头像--用户名,密码,头像,邮箱
	 * @return 返回插入用户的id
	 * 
	 */
	int insertUser(UserInfo user);
	
	/**
	 * 更新用户头像
	 * @param img 头像url
	 * @return 返回更新结果 >0 表示更新成功    =0 失败
	 */
	int updateUserImg(String img,int userid);
	
	/**
	 * 更新用户的性别，地区，出生日期信息
	 * @param user 
	 * @return 1 或 > 0-更新成功    0-表示更新失败
	 */
	int updateUserInfo(UserInfo user);
	
	/**
	 * 更新用户的留言板权限
	 * @param id
	 * @return  1 或 > 0-更新成功    0-表示更新失败
	 */
	int updateUserMessagePower(int power,int id);
	
	/**
	 * 更新用户的访问权限
	 * @param id 
	 * @return  1 或 > 0-更新成功    0-表示更新失败
	 */
	int updateUserVisitPower(int power,int id);
	/**
	 * 删除用户根据id
	 * @param id
	 * @return 1 或 > 0-删除成功    0-表示删除失败
	 */
	int deleteUser(int id);
	
	
	

}
