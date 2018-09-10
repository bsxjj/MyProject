package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecjtu.jy.dao.IJoinActivityDao;
import com.ecjtu.jy.pojo.JoinActivity;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;

public class JoinActivityDaoImpl implements IJoinActivityDao{

	

	@Override
	public int insertJoinActivity(JoinActivity joinActivity) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="insert into joinactivity values(?,?,?,?)";
		int result=0;
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, joinActivity.getJoinActivityId());
			ps.setInt(2, joinActivity.getActivityid());
			ps.setInt(3, joinActivity.getJoinerId());
			ps.setInt(4, joinActivity.getStat());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePC(conn, ps);
		}
		return result;
	}

	@Override
	public int deleteJoinActivity(int jid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="delete from joinactivity where joinactivity_id=?";
		int result=0;
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, jid);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePC(conn, ps);
		}
		return result;
	}

	@Override
	public int selectActivityCount(int activityid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select count(joinerid) from joinactivity where activityid=?";
		int count=0;
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, activityid);
			rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt("count(joinerid)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return count;
	}

}
