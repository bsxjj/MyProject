package com.ecjtu.jy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IFeedBackDao;
import com.ecjtu.jy.dao.impl.FeedBackDaoImpl;
import com.ecjtu.jy.pojo.FeedBack;
import com.ecjtu.jy.service.IFeedBackService;

public class FeedBackServiceImpl implements IFeedBackService {
	
	private IFeedBackDao fDao = new FeedBackDaoImpl();

	@Override
	public int insertFeedBack(FeedBack feedBack) {
		int result = 0;
		result = fDao.insertFeedBack(feedBack);
		return result;
	}

	@Override
	public int updateFeedBack(FeedBack feedBack) {
		int result = 0;
		result = fDao.updateFeedBackState(feedBack);
		return result;
	}

	@Override
	public int delectFeedBack(int id) {
		int result = 0;
		result = fDao.delectFeedBack(id);
		return result;
	}

	@Override
	public List<FeedBack> selectFeedBackByPageNum(int pageNum) {
		List<FeedBack> feedBacks = new ArrayList<>();
		feedBacks = fDao.selectFeedBackByPageNum(pageNum);
		return feedBacks;
	}

	@Override
	public int selectFeedBackSum() {
		int count = 0;
		count = fDao.selectFeedBackSum();
		return count;
	}

}
