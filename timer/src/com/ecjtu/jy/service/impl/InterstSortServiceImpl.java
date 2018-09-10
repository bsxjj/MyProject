package com.ecjtu.jy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IInterstSortDao;
import com.ecjtu.jy.dao.impl.InterestSortDaoImpl;
import com.ecjtu.jy.pojo.InterestSort;
import com.ecjtu.jy.service.IInterstSortService;

public class InterstSortServiceImpl implements IInterstSortService {

	private IInterstSortDao iISortDao = new InterestSortDaoImpl();
	
	@Override
	public int insertInterSort(InterestSort interSort) {
		int result = 0;
		result = iISortDao.insertInterSort(interSort);
		return result;
	}

	@Override
	public int deleteInterstSort(int id) {
		int result = 0;
		result = iISortDao.deleteInterstSort(id);
		return result;
	}

	@Override
	public int updateInterstSort(InterestSort interSort) {
		int result = 0;
		result = iISortDao.updateInterstSort(interSort);
		return result;
	}

	@Override
	public List<InterestSort> selectInterSorts(int pageNum) {
		List<InterestSort> interestSorts = new ArrayList<>();
		interestSorts = iISortDao.selectInterSorts(pageNum);
		return interestSorts;
	}

}
