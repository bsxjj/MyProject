package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IBottleDao;
import com.ecjtu.jy.pojo.Bottle;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;
import com.ecjtu.jy.utils.Page;
import com.sun.org.apache.xerces.internal.util.Status;

public class BottleDaoImpl implements IBottleDao {
	
	

	@Override
	public List<Bottle> selectBottleByUserId(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Bottle> bottles = new ArrayList<>();
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from bottle where bottleUserId = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Bottle bottle = new Bottle();
				bottle.setId(rs.getInt("bottleId"));
				bottle.setBottlename(rs.getString("bottleName"));
				bottle.setBottlecontent(rs.getString("bottleContent"));
				bottle.setBottleuserid(rs.getInt("bottleUserId"));
				bottle.setBottleusername(rs.getString("bottleUserName"));
				bottle.setDrifttime(rs.getTimestamp("driftTime"));
				bottle.setState(rs.getInt("state"));
				bottle.setGainuserid(rs.getInt("gainUserId"));
				bottle.setGainuser(rs.getString("gainUserName"));
				bottles.add(bottle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return bottles;
	}

	@Override
	public Bottle selectBottleByRandom(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		Bottle bottle = new Bottle();
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from bottle where bottleId = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt("state")==0) {
					bottle.setId(rs.getInt("bottleId"));
					bottle.setBottlename(rs.getString("bottleName"));
					bottle.setBottlecontent(rs.getString("bottleContent"));
					bottle.setBottleuserid(rs.getInt("bottleUserId"));
					bottle.setBottleusername(rs.getString("bottleUserName"));
					bottle.setDrifttime(rs.getTimestamp("driftTime"));
					bottle.setState(rs.getInt("state"));
					bottle.setGainuserid(rs.getInt("gainUserId"));
					bottle.setGainuser(rs.getString("gainUserName"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return bottle;
	}

	@Override
	public List<Bottle> selectBottles(int state) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Bottle> bottles = new ArrayList<>();
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from bottle where state = ?");
			ps.setInt(1, state);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt("state")==0) {
					Bottle bottle = new Bottle();
					bottle.setId(rs.getInt("bottleId"));
					bottle.setBottlename(rs.getString("bottleName"));
					bottle.setBottlecontent(rs.getString("bottleContent"));
					bottle.setBottleuserid(rs.getInt("bottleUserId"));
					bottle.setBottleusername(rs.getString("bottleUserName"));
					bottle.setDrifttime(rs.getTimestamp("driftTime"));
					bottle.setState(rs.getInt("state"));
					bottle.setGainuserid(rs.getInt("gainUserId"));
					bottle.setGainuser(rs.getString("gainUserName"));
					bottles.add(bottle);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return bottles;
	}

	@Override
	public int updateBottle(Bottle bottle) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("update bottle set gainUserId=?,gainUserName=?,state=? where bottleId = ?");
			ps.setInt(1,bottle.getGainuserid());
			ps.setString(2, bottle.getGainuser());
			ps.setInt(3, bottle.getState());
			ps.setInt(4, bottle.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	@Override
	public int insertBottle(Bottle bottle) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("insert into bottle(bottleId,bottleName,bottleContent,bottleUserId,bottleUserName,driftTime) values(?,?,?,?,?,?)");
			ps.setInt(1, bottle.getId());
			ps.setString(2, bottle.getBottlename());
			ps.setString(3, bottle.getBottlecontent());
			ps.setInt(4, bottle.getBottleuserid());
			ps.setString(5, bottle.getBottleusername());
			ps.setTimestamp(6, bottle.getDrifttime());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	@Override
	public List<Bottle> selectMyBottleByPageNum(int pageNum, int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Bottle> bottles = new ArrayList<>();
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from bottle where albumCreatorId=? limit ?,?");
			ps.setInt(1, userid);
			ps.setInt(2, (pageNum-1)*Page.COMMON_NUM);
			ps.setInt(3, Page.COMMON_NUM);
			rs = ps.executeQuery();
			while (rs.next()) {
					Bottle bottle = new Bottle();
					bottle.setId(rs.getInt("bottleId"));
					bottle.setBottlename(rs.getString("bottleName"));
					bottle.setBottlecontent(rs.getString("bottleContent"));
					bottle.setBottleuserid(rs.getInt("bottleUserId"));
					bottle.setBottleusername(rs.getString("bottleUserName"));
					bottle.setDrifttime(rs.getTimestamp("driftTime"));
					bottle.setState(rs.getInt("state"));
					bottle.setGainuserid(rs.getInt("gainUserId"));
					bottle.setGainuser(rs.getString("gainUserName"));
					bottles.add(bottle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return bottles;
	}

	@Override
	public int selectBottleCountSum(int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select count(*) from bottle ");
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);//对总数赋值
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return count;
	}

	@Override
	public int deleteBottle(int bottleid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("delete from bottle where bottleId=?");
			ps.setInt(1, bottleid);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	/*@Override
	public List<Bottle> selectBottles() {
		// TODO Auto-generated method stub
		return null;
	}
*/
	

}
