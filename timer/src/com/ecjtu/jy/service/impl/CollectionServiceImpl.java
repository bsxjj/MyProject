package com.ecjtu.jy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.ICollectionDao;
import com.ecjtu.jy.dao.impl.CollectionDaoImpl;
import com.ecjtu.jy.pojo.Collection;
import com.ecjtu.jy.service.ICollectionService;

public class CollectionServiceImpl implements ICollectionService {
	
	private ICollectionDao cDao = new CollectionDaoImpl();

	@Override
	public int insertCollection(Collection collection) {
		int result = 0;
		result = cDao.insertCollection(collection);
		return result;
	}

	@Override
	public int deleteCollection(int collectionid) {
		int result = 0;
		result = cDao.deleteCollection(collectionid);
		return result;
	}

	@Override
	public List<Collection> selectCollectionByPageNum(int pageNum, int userid) {
		List<Collection> collections = new ArrayList<>();
		collections = cDao.selectCollectionByPage(pageNum, userid);
		return collections;
	}

	@Override
	public int selectCollectionPageSum(int id) {
		int count = 0;
		count = cDao.selectCollectionPageSum(id);
		return count;
	}

	@Override
	public int selectImgtxtBeCollect(int imgtxtid) {
		
		return cDao.selectImgtxtBeCollect(imgtxtid);
	}

	@Override
	public int selectIsCollection(int imgtxtid, int userid) {
		
		return cDao.selectIsCollection(imgtxtid, userid);
	}

	

}
