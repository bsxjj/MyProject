package com.ecjtu.jy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IInterestDao;
import com.ecjtu.jy.dao.IInterstSortDao;
import com.ecjtu.jy.dao.impl.InterestDaoImpl;
import com.ecjtu.jy.dao.impl.InterestSortDaoImpl;
import com.ecjtu.jy.pojo.Interest;
import com.ecjtu.jy.service.IInterstService;

public class InterstServiceImpl implements IInterstService {
	private IInterestDao iInterestDao= null;
	private IInterstSortDao iISortDao = null;
	public InterstServiceImpl() {
		super();
		iInterestDao= new InterestDaoImpl();
		iISortDao = new InterestSortDaoImpl();
	}

	
	@Override
	public int insertInterst(Interest interest) {
		int result = 0;
		result = iInterestDao.insertInterst(interest);
		return result;
	}

	@Override
	public int insertIntersts(List<Interest> interests) {
		int result = 0;
		result = iInterestDao.insertIntersts(interests);
		return result;
	}

	@Override
	public int deleteInterst(int interid, int userid) {
		int result = 0;
		result = iInterestDao.deleteInterst(interid, userid);
		return result;
	}

	@Override
	public int deleteIntersts(int[] ids, int userid) {
		int result = 0;
		result = iInterestDao.deleteIntersts(ids, userid);
		return result;
	}

	@Override
	public List<Interest> selectIntersts(int userid) {
		List<Interest> interests = new ArrayList<>();
		interests = iInterestDao.selectIntersts(userid);
		for (Interest interest : interests) {
			String interstName = "";
			interstName = iISortDao.selectInterSortNameById(interest.getInterestid());
			interest.setInterstName(interstName);
		}
		return interests;
	}

}
