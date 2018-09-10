package com.ecjtu.jy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IImgTxtInfoDao;
import com.ecjtu.jy.dao.ILaudDao;
import com.ecjtu.jy.dao.impl.ImgTxtInfoDaoImpl;
import com.ecjtu.jy.pojo.ImgTxtInfo;
import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.service.ICollectionService;
import com.ecjtu.jy.service.ICommentService;
import com.ecjtu.jy.service.IImgTxtInfoService;
import com.ecjtu.jy.service.ILaudService;
import com.ecjtu.jy.service.IUserInfoService;

public class ImgTxtInfoServiceImpl implements IImgTxtInfoService {

	private IImgTxtInfoDao iImgTxtInfoDao = new ImgTxtInfoDaoImpl();
	
	@Override
	public int insertImgTxtInfo(ImgTxtInfo imgTxt) {
		int result = 0;
		result = iImgTxtInfoDao.insertImgTxtInfo(imgTxt);
		return result;
	}

	@Override
	public int deleteImgTxtInfoById(int id) {
		int result = 0;
		result = iImgTxtInfoDao.deleteImgTxtInfoById(id);
		return result;
	}

	@Override
	public List<ImgTxtInfo> selectImgTxtByPageNum(int pageNum,int userid,int a) {
		List<ImgTxtInfo> imgTxtInfos = new ArrayList<>();
		imgTxtInfos = iImgTxtInfoDao.selectImgTxtByPageNum(pageNum);
		ILaudService ilaud = new LaudServiceImpl();
		ICollectionService icollection = new CollectionServiceImpl();
		ICommentService icomm = new CommentServiceImpl();
		IUserInfoService iuservice = new UserInfoServiceImpl();
		for (ImgTxtInfo imgTxtInfo : imgTxtInfos) {
			imgTxtInfo.setLaudNum(ilaud.selectLaudCount(imgTxtInfo.getImgTxtId()));
			imgTxtInfo.setLaud(ilaud.isLaud(userid, imgTxtInfo.getImgTxtId()) > 0 ? true : false);
			imgTxtInfo.setCollectionNum(icollection.selectImgtxtBeCollect(imgTxtInfo.getImgTxtId()));
			imgTxtInfo.setIsCollection(icollection.selectIsCollection(imgTxtInfo.getImgTxtId(), userid) > 0 ? true:false);
			imgTxtInfo.setCommNum(icomm.selectImgTxtCommentsNum(imgTxtInfo.getImgTxtId()));
			UserInfo uinfo = iuservice.selectUserById(imgTxtInfo.getSendId());
			imgTxtInfo.setUsername(uinfo.getUsername());
			imgTxtInfo.setUserImg(uinfo.getHeadPicture());
		}
		return imgTxtInfos;
	}

	@Override
	public int selectImgTxtSum(int id) {
		int sum = 0;
		sum = iImgTxtInfoDao.selectImgTxtSum(id);
		return sum;
	}

	@Override
	public List<ImgTxtInfo> selectImgTxtByHot(int pageNum, int id) {
		List<ImgTxtInfo> imgTxtInfos = new ArrayList<>();
		imgTxtInfos = iImgTxtInfoDao.selectImgTxtByHot(pageNum, id);
		return imgTxtInfos;
	}

	@Override
	public List<ImgTxtInfo> selectImgTxtByComment(int pageNum, int id) {
		List<ImgTxtInfo> imgTxtInfos = new ArrayList<>();
		imgTxtInfos = iImgTxtInfoDao.selectImgTxtByComment(pageNum, id);
		return imgTxtInfos;
	}

	@Override
	public ImgTxtInfo selectImgTxtById(int id) {
		ImgTxtInfo imgTxtInfo = new ImgTxtInfo();
		imgTxtInfo = iImgTxtInfoDao.selectImgTxtById(id);
		return imgTxtInfo;
	}

	@Override
	public int selectAllImgTxtNum() {
		
		return iImgTxtInfoDao.selectAllImgTxtNum();
	}

	@Override
	public List<ImgTxtInfo> selectImgTxtByPageNum(int pageNum,int userid) {
		List<ImgTxtInfo> imgtxts = iImgTxtInfoDao.selectImgTxtByPageNum(pageNum,userid);
	
		ILaudService ilaud = new LaudServiceImpl();
		ICollectionService icollection = new CollectionServiceImpl();
		ICommentService icomm = new CommentServiceImpl();
		IUserInfoService iuservice = new UserInfoServiceImpl();
		for (ImgTxtInfo imgTxtInfo : imgtxts) {
			imgTxtInfo.setLaudNum(ilaud.selectLaudCount(imgTxtInfo.getImgTxtId()));
			imgTxtInfo.setLaud(ilaud.isLaud(userid, imgTxtInfo.getImgTxtId()) > 0 ? true : false);
			imgTxtInfo.setCollectionNum(icollection.selectImgtxtBeCollect(imgTxtInfo.getImgTxtId()));
			imgTxtInfo.setIsCollection(icollection.selectIsCollection(imgTxtInfo.getImgTxtId(), userid) > 0 ? true:false);
			imgTxtInfo.setCommNum(icomm.selectImgTxtCommentsNum(imgTxtInfo.getImgTxtId()));
			UserInfo uinfo = iuservice.selectUserById(imgTxtInfo.getSendId());
			imgTxtInfo.setUsername(uinfo.getUsername());
			imgTxtInfo.setUserImg(uinfo.getHeadPicture());
			
		}
		return imgtxts;
	}

}
