package com.ecjtu.jy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IFollowDao;
import com.ecjtu.jy.dao.impl.FollowDaoImpl;
import com.ecjtu.jy.pojo.Follow;
import com.ecjtu.jy.service.IFollowService;

public class FollowServiceImpl implements IFollowService {
	
	private IFollowDao ifDao = new FollowDaoImpl();
	
	@Override
	public int insertFocus(Follow follw) {
		int result = 0;
		result = ifDao.insertFollow(follw);
		return result;
	}

	@Override
	public int deleteFocus(Follow follow) {
		int result = 0;
		result = ifDao.deleteFollowById(follow.getId());
		return result;
	}

	@Override
	public List<Follow> selectFocusByPageNum(int userid, int pageNum) {
		List<Follow> fList = new ArrayList<>();
		fList = ifDao.selectFollowByPageNum(pageNum, userid, 0);
		return fList;
	}

	@Override
	public int selectFocusCountNum(int userid) {
		int result = 0;
		result = ifDao.selectFollowUserCount(userid, 0);
		return result;
	}

	@Override
	public List<Follow> selectFansByPageNum(int userid, int pageNum) {
		List<Follow> fList = new ArrayList<>();
		fList = ifDao.selectFollowByPageNum(pageNum, userid, 1);
		return fList;
	}

	@Override
	public int selectFansCountNum(int userid) {
		int result = 0;
		result = ifDao.selectFollowUserCount(userid, 1);
		return result;
	}

	@Override
	public boolean isFocus(int userid, int myid) {
		
		return ifDao.isFocus(userid, myid);
	}

	@Override
	public int deleteFollowByFollow(Follow follow) {
		
		return ifDao.deleteFollowByFollow(follow);
	}

}
