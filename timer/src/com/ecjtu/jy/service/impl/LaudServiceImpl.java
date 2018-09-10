package com.ecjtu.jy.service.impl;

import java.util.List;

import com.ecjtu.jy.dao.ILaudDao;
import com.ecjtu.jy.dao.impl.LaudDaoImpl;
import com.ecjtu.jy.pojo.Laud;
import com.ecjtu.jy.service.ILaudService;

public class LaudServiceImpl implements ILaudService{

	ILaudDao dao=new LaudDaoImpl();
	@Override
	public synchronized int insertLaud(Laud laud) {
		int result=0;
		//·âËø
		result=dao.insertLaud(laud);
		return result;
	}

	@Override
	public int deleteLaud(int userid,int txtid) {
		return dao.deleteLaud(userid, txtid);
	}

	@Override
	public int selectLaudCount(int txtid) {
		return dao.selectLaudCount(txtid);
	}

	@Override
	public List<Laud> selectLaud(int txtid) {
		return dao.selectLaud(txtid);
	}

	@Override
	public int isLaud(int userid, int txtid) {
		return dao.isLaud(userid, txtid);
	}

}
