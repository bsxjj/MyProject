package com.ecjtu.jy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IActivityDao;
import com.ecjtu.jy.pojo.Activity;

public class ActivityDaoImpl implements IActivityDao {

	private IActivityDao activityDao = new ActivityDaoImpl();
	
	@Override
	public int insertActivity(Activity activity) {
		int result = 0;
		result = activityDao.insertActivity(activity);
		return result;
	}

	@Override
	public int deleteActivity(int activityid) {
		int result = 0;
		result = activityDao.deleteActivity(activityid);
		return result;
	}

	@Override
	public int updateActivity(Activity activity) {
		int result = 0;
		result = activityDao.updateActivity(activity);
		return result;
	}

	@Override
	public List<Activity> selectActivityByPageNum(int pageNum) {
		List<Activity> activities = new ArrayList<>();
		activities = activityDao.selectActivityByPageNum(pageNum);
		return activities;
	}

	@Override
	public int selectActivityCountNum() {
		int sum = 0;
		sum = activityDao.selectActivityCountNum();
		return sum;
	}

	@Override
	public List<Activity> selectMyStartActivityByPageNum(int userid) {
		List<Activity> activities = new ArrayList<>();
		activities = activityDao.selectMyStartActivityByPageNum(userid);
		return activities;
	}

}
