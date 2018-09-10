package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IActivityDao;
import com.ecjtu.jy.pojo.Activity;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;
import com.ecjtu.jy.utils.Page;

import sun.security.krb5.internal.crypto.crc32;

public class ActivityDaoImpl implements IActivityDao {
	
	

	@Override
	public int insertActivity(Activity activity) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("insert into activity(activityId,activityName,activityContent,callId,callName,needNum) values(?,?,?,?,?,?)");
			ps.setInt(1, activity.getActivityId());
			ps.setString(2, activity.getActivityName());
			ps.setString(3, activity.getActivityContent());
			ps.setInt(4, activity.getCallId());
			ps.setString(5, activity.getCallName());
			ps.setInt(6, activity.getNeedNum());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	@Override
	public int deleteActivity(int activityid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("delete from activity where activityId=? ");
			ps.setInt(1, activityid);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	@Override
	public int updateActivity(Activity activity) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("update activity set activityName=?,activityContent=?,callId=?,callName=?,needNum=? where activityId=?");
			ps.setString(1, activity.getActivityName());
			ps.setString(2, activity.getActivityContent());
			ps.setInt(3, activity.getCallId());
			ps.setString(4, activity.getCallName());
			ps.setInt(5, activity.getNeedNum());
			ps.setInt(6, activity.getActivityId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	@Override
	public List<Activity> selectActivityByPageNum(int pageNum) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Activity> activities = new ArrayList<>();
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from activity where activityId limit ?,?");
			ps.setInt(1, (pageNum-1)*Page.COMMON_NUM);
			ps.setInt(2, Page.COMMON_NUM);
			rs = ps.executeQuery();
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setActivityId(rs.getInt("activityId"));
				activity.setActivityName(rs.getString("activityName"));
				activity.setActivityContent(rs.getString("activityContent"));
				activity.setCallId(rs.getInt("callId"));
				activity.setCallName(rs.getString("callName"));
				activity.setNeedNum(rs.getInt("needNum"));
				activities.add(activity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return activities;
	}

	@Override
	public int selectActivityCountNum() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select count(*) from activity ");
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
	public List<Activity> selectMyStartActivityByPageNum(int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Activity> activities = new ArrayList<>();
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from activity where callId = ? ");
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setActivityId(rs.getInt("activityId"));
				activity.setActivityName(rs.getString("activityName"));
				activity.setActivityContent(rs.getString("activityContent"));
				activity.setCallId(rs.getInt("callId"));
				activity.setCallName(rs.getString("callName"));
				activity.setNeedNum(rs.getInt("needNum"));
				activities.add(activity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return activities;
	}

}
