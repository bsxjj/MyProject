package com.ecjtu.jy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IAlbumDao;
import com.ecjtu.jy.dao.IImgDao;
import com.ecjtu.jy.dao.impl.AlbumDaoImpl;
import com.ecjtu.jy.dao.impl.ImgDaoImpl;
import com.ecjtu.jy.pojo.Album;
import com.ecjtu.jy.pojo.Img;
import com.ecjtu.jy.service.IAlbumService;

public class AlbumServiceImpl implements IAlbumService {
	
	private IAlbumDao albumDao = new AlbumDaoImpl();
	private IImgDao imgDao = new ImgDaoImpl();

	@Override
	public int insertAlbum(Album album) {
		int result = 0;
		result = albumDao.insertAlbum(album);
		return result;
	}

	@Override
	public int uploadImg(Img img) {
		int result = 0;
		result = imgDao.insertImg(img);
		return result;
	}

	@Override
	public int uploadImgs(List<Img>imgs) {
		int result = 0;
		result = imgDao.insertImgs(imgs);
		return result;
	}

	@Override
	public int deleteAlbum(int albumid) {
		int result = 0;
		result = albumDao.deleteAlbum(albumid);
		return result;
	}

	@Override
	public int updateAlbum(Album album) {
		int result = 0;
		result = albumDao.insertAlbum(album);
		return result;
	}

	@Override
	public List<Album> selctAlbumByPageNum(int pageNum, int userid) {
		List<Album> albums = new ArrayList<>();
		albums = albumDao.selctAlbumByPageNum(pageNum, userid);
		return albums;
	}

	@Override
	public int selectAlbumCountNum(int userid) {
		int count = 0;
		count = albumDao.selectAlbumCountNum(userid);
		return count;
	}

	@Override
	public List<Img> selectImgByAlbumId(int blbumid) {
		List<Img> imgs = new ArrayList<>();
		imgs = imgDao.selectImgsById(blbumid);
		return imgs;
	}

	@Override
	public List<Img> selectImgsByNew(int id) {
		
		return imgDao.selectImgsByNew(id);
	}

}
