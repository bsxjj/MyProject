package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IFeedBackDao;
import com.ecjtu.jy.pojo.FeedBack;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;
import com.ecjtu.jy.utils.Page;

public class FeedBackDaoImpl implements IFeedBackDao {
	
	

	@Override
	public List<FeedBack> selectFeedBackByPageNum(int pageNum) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FeedBack> feedBacks = new ArrayList<>();
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from feedback where feedbackerId limit ?,?");
			ps.setInt(1, (pageNum-1)*Page.COMMON_NUM);
			ps.setInt(2, Page.COMMON_NUM);
			rs = ps.executeQuery();
			while (rs.next()) {
				FeedBack feedBack = new FeedBack();
				feedBack.setFeedbackId(rs.getInt("feedbackId"));
				feedBack.setFeedbackContent(rs.getString("feedbackContent"));
				feedBack.setFeedbackerId(rs.getInt("feedbackerId"));
				feedBack.setFeedbackerName(rs.getString("feedbackerName"));
				feedBack.setFeedbackTime(rs.getTimestamp("feedbackTime"));
				feedBack.setFeedbackStatus(rs.getInt("feedbackStatus"));
				feedBacks.add(feedBack);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return feedBacks;
	}

	@Override
	public int selectFeedBackSum() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select count(*) from feedback ");
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
	public FeedBack selectFeedBackById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		FeedBack feedBack = new FeedBack();
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from feedback where feedbackerId = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				feedBack.setFeedbackId(rs.getInt("feedbackId"));
				feedBack.setFeedbackContent(rs.getString("feedbackContent"));
				feedBack.setFeedbackerId(rs.getInt("feedbackerId"));
				feedBack.setFeedbackerName(rs.getString("feedbackerName"));
				feedBack.setFeedbackTime(rs.getTimestamp("feedbackTime"));
				feedBack.setFeedbackStatus(rs.getInt("feedbackStatus"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return feedBack;
	}

	@Override
	public int delectFeedBack(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("delete from feedback where feedbackerId = ?");
			ps.setInt(1, id);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	@Override
	public int updateFeedBackState(FeedBack feedBack) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("update feedback set feedbackStatus=? where feedbackId = ?");
			ps.setInt(1, feedBack.getFeedbackStatus());
			ps.setInt(2, feedBack.getFeedbackId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	@Override
	public int insertFeedBack(FeedBack feedBack) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("insert into feedback(feedbaackId,feedbaackContent,feedbackerId,feedbackerName,feedbackStatus) values(?,?,?,?,?)");
			ps.setInt(1, feedBack.getFeedbackId());
			ps.setString(2, feedBack.getFeedbackContent());
			ps.setInt(3, feedBack.getFeedbackerId());
			ps.setString(4, feedBack.getFeedbackerName());
			ps.setInt(5, feedBack.getFeedbackStatus());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

}
