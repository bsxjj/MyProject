package com.ecjtu.jy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IBottleDao;
import com.ecjtu.jy.dao.impl.BottleDaoImpl;
import com.ecjtu.jy.pojo.Bottle;
import com.ecjtu.jy.service.IBottleService;

public class BottleServiceImpl implements IBottleService {
	
	private IBottleDao bDao = new BottleDaoImpl(); 

	@Override
	public Bottle selectBottleByRandom() {
		List<Bottle> bottles = new ArrayList<>();
		int state = 0;
		bottles = bDao.selectBottles(state);
		int id=(int)(Math.random()*20);
		Bottle bottle = new Bottle();
		try {
			bottle = bottles.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bottle;
		
	}

	@Override
	public List<Bottle> selectMyBottleByPageNum(int pageNum, int userid) {
		List<Bottle> bottles = new ArrayList<>();
		bottles = bDao.selectMyBottleByPageNum(pageNum, userid);
		return bottles;
	}

	@Override
	public int selectBottleCountSum(int userid) {
		int count = 0;
		count = bDao.selectBottleCountSum(userid);
		return count;
	}

	@Override
	public int insertBottle(Bottle bottle) {
		int result = 0;
		result = bDao.insertBottle(bottle);
		return result;
	}

	@Override
	public int deleteBottle(int bottleid) {
		int result = 0;
		result = bDao.deleteBottle(bottleid);
		return result;
	}

	@Override
	public int updateBottle(Bottle bottle) {
		int result = 0;
		result = bDao.updateBottle(bottle);
		return result;
	}

}
