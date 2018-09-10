package com.ecjtu.jy.service.impl;

import java.util.List;

import com.ecjtu.jy.dao.IUserInfoDao;
import com.ecjtu.jy.dao.impl.UserInfoImpl;
import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.service.IAlbumService;
import com.ecjtu.jy.service.IFollowService;
import com.ecjtu.jy.service.IInterstService;
import com.ecjtu.jy.service.IUserInfoService;

public class UserInfoServiceImpl implements IUserInfoService{

	private IUserInfoDao userDao = new UserInfoImpl();
	@Override
	public UserInfo selectUserByPassAndUserName(String userName, String password) {
		
		return userDao.selectUserByPassAndUserName(userName, password);
	}

	@Override
	public int validateUserName(String userName) {
		
		return userDao.validateUserName(userName);
	}

	@Override
	public int validateEmail(String email) {
	
		return userDao.validateEmail(email);
	}

	
	/**
	 * 查询用户更多信息
	 */
	@Override
	public UserInfo selectUserById(int id) {
		IFollowService ifservice = new FollowServiceImpl();
		UserInfo user = userDao.selectUserById(id);
		IInterstService iiservice = new InterstServiceImpl();
		IAlbumService ialservice = new AlbumServiceImpl();
		user.setFocusNum(ifservice.selectFocusCountNum(id));
		user.setFansNum(ifservice.selectFansCountNum(id));
		//照片最新
		user.setImgs(ialservice.selectImgsByNew(id));
		user.setIntersts(iiservice.selectIntersts(id));
		
		return user;
		
		
	}

	@Override
	public List<UserInfo> selectUsersById(String likeName) {
		
		return userDao.selectUsersById(likeName);
	}

	@Override
	public int insertUser(UserInfo user) {
		
		return userDao.insertUser(user);
	}

	@Override
	public int updateUserImg(String img,int userid) {
		
		return userDao.updateUserImg(img,userid);
	}

	@Override
	public int updateUserInfo(UserInfo user) {
		
		return userDao.updateUserInfo(user);
	}

	@Override
	public int updateUserMessagePower(int power,int id) {
		
		return userDao.updateUserMessagePower(power,id);
	}

	@Override
	public int updateUserVisitPower(int power,int id) {
		
		return userDao.updateUserVisitPower(power,id);
	}

	@Override
	public int deleteUser(int id) {
		
		return userDao.deleteUser(id);
	}

}
