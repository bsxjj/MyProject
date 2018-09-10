package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IInterviewDao;
import com.ecjtu.jy.pojo.Interview;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;
import com.ecjtu.jy.utils.Page;

public class InterviewDaoImpl implements IInterviewDao {

	
	
	
	@Override
	public int insertInterview(Interview interview) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "insert into interview(interviewId,interviewerId,intervieweeId,interviewTime) values(?,?,?,?)";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, interview.getId());
			ps.setInt(2, interview.getInterviewid());
			ps.setInt(3, interview.getBeinterviewid());
			ps.setTimestamp(4, interview.getInterviewtime());
			result = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	@Override
	public int deleteInterview(int interid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "delete from interview  where interviewId=?";
		try {
			conn=C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, interid);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		return result;
	}

	@Override
	public List<Interview> selectInterviewByPageNum(int pageNum, int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Interview> interviews = new ArrayList<>();
		int page = (pageNum-1)*Page.INTERVIEW_NUM;
		try {
			conn = conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from interview where intervieweeId=? limit ?,?");
			ps.setInt(1,userid);
			ps.setInt(2,page);
			ps.setInt(3, Page.INTERVIEW_NUM);
			rs = ps.executeQuery();
			while(rs.next()) {
				Interview interview = new Interview();
				interview.setId(rs.getInt("interviewId"));
				interview.setInterviewid(rs.getInt("interviewerId"));
//				interview.setInterviewName(rs.getString("interviewName"));
//				interview.setInterviewImg(rs.getString("interviewImg"));
				interview.setBeinterviewid(rs.getInt("intervieweeId"));
				interview.setInterviewtime(rs.getTimestamp("interviewTime"));
				interviews.add(interview);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return interviews;
	}

}
