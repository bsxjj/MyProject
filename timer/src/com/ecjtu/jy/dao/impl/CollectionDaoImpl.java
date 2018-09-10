package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ecjtu.jy.pojo.Collection;
import java.util.List;

import com.ecjtu.jy.dao.ICollectionDao;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;
import com.ecjtu.jy.utils.Page;

public class CollectionDaoImpl implements ICollectionDao {
	
	

	@Override
	public List<Collection> selectCollectionByPage(int page, int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Collection> collections = new ArrayList<>();
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from collection where collectorId=? limit ?,?");
			ps.setInt(1, id);
			ps.setInt(2, (page-1)*Page.COMMON_NUM);
			ps.setInt(3, Page.COMMON_NUM);
			rs = ps.executeQuery();
			while (rs.next()) {
				Collection collection = new Collection();
				collection.setCollectionId(rs.getInt("collectionId"));
				collection.setCollectorId(rs.getInt("collectorId"));
				collection.setCollectionImgTxtId(rs.getInt("collectionImgTxtId"));
				collection.setCollectionCreatTime(rs.getTimestamp("collectionCreatTime"));
				collections.add(collection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return collections;
	}

	@Override
	public int selectCollectionPageSum(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select count(*) from collection ");
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);//对收藏总数赋值
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return count;
	}

	@Override
	public int insertCollection(Collection collection) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("insert into collection(collectorid,collectionimgtxtid,collectionCreattime) values(?,?,?)");
			ps.setInt(1, collection.getCollectorId());
			ps.setInt(2, collection.getCollectionImgTxtId());
			ps.setTimestamp(3, collection.getCollectionCreatTime());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePC(conn, ps);
		}
		return result;
	}

	@Override
	public int deleteCollection(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("delete from collection where collectorId = ?");
			ps.setInt(1, id);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	/**
	 * 选择该图文被收藏的总数
	 */
	@Override
	public int selectImgtxtBeCollect(int imgtxtid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select count(*) from collection where collectionimgtxtid=?");
			ps.setInt(1, imgtxtid);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);//对收藏总数赋值
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return count;
	}

	@Override
	public int selectIsCollection(int imgtxtid, int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from collection where collectionimgtxtid=? and collectorid=?");
			ps.setInt(1, imgtxtid);
			ps.setInt(2, userid);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = 1;//对收藏总数赋值
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return count;
		
	}

}
