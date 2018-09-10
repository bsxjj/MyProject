package com.ecjtu.jy.service.impl;

import java.util.List;

import com.ecjtu.jy.dao.IPrivateLetterDao;
import com.ecjtu.jy.dao.impl.PrivateLetterDaoImpl;
import com.ecjtu.jy.pojo.PrivateLetter;
import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.service.IPrivateLetterService;
import com.ecjtu.jy.service.IUserInfoService;

public class PrivateLetterServiceImpl implements IPrivateLetterService{

	IPrivateLetterDao ipDao = null;
	public PrivateLetterServiceImpl() {
		ipDao = new PrivateLetterDaoImpl();
	}
	@Override
	public int insertPrivateLetter(PrivateLetter letter) {
		// TODO Auto-generated method stub
		return ipDao.insertPrivateLetter(letter);
	}

	@Override
	public int deletePrivateLetter(int user1id, int user2id) {
		// TODO Auto-generated method stub
		return ipDao.deletePrivateLetter(user1id, user2id);
	}

	@Override
	public int deletePrivateLetterById(int letterid) {
		// TODO Auto-generated method stub
		return ipDao.deletePrivateLetterById(letterid);
	}

	@Override
	public List<PrivateLetter> selectLetterByPageNum(int pageNum, int userid) {
		// TODO Auto-generated method stub
		return ipDao.selectLetterByPageNum(pageNum, userid);
	}

	@Override
	public int selectLetterCount(int userid) {
		// TODO Auto-generated method stub
		return ipDao.selectLetterCount(userid);
	}

	@Override
	public int selectLetterCountByNotRead(int userid) {
		// TODO Auto-generated method stub
		return ipDao.selectLetterCountByNotRead(userid);
	}

	@Override
	public int selectLetterCountByIsRead(int userid) {
		// TODO Auto-generated method stub
		return ipDao.selectLetterCountByIsRead(userid);
	}

	@Override
	public List<PrivateLetter> selectLetterByPageNum(int pageNum, int userid, int type) {
		// TODO Auto-generated method stub
		return ipDao.selectLetterByPageNum(pageNum, userid, type);
	}
	@Override
	public List<PrivateLetter> selectLetterUserList(int crid,int userid) {
		List<PrivateLetter> letterList = ipDao.selectLetterUserList(crid);
		IUserInfoService iuser = new UserInfoServiceImpl();
		for (PrivateLetter privateLetter : letterList) {
			if (userid == privateLetter.getAcceptId() && privateLetter.getAcceptStatus() == 0){
				privateLetter.setAcceptStatus(ipDao.updateLetter(privateLetter.getPrivateLetterId()));
			}
			
			UserInfo info = iuser.selectUserById(privateLetter.getSenderId());
			privateLetter.setSendimg(info.getHeadPicture());
		}
		
		return letterList;
	}

}
