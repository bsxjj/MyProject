package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.ICommentDao;
import com.ecjtu.jy.pojo.Comment;
import com.ecjtu.jy.pojo.Notification;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;
import com.ecjtu.jy.utils.MyUtil;

public class CommentDaoImpl implements ICommentDao{

	@Override
	public int insertComment(Comment comment) {
		Connection conn = null;
		int result = 0;
		PreparedStatement ps = null;
		String sql = "insert into acomment(comimgtxtid,commentorid,commentcontent,commentorhead,commentcreattime,commentorname)"
				+ "values(?,?,?,?,?,?)";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comment.getComImgTxtId());
			ps.setInt(2, comment.getCommentorId());
			ps.setString(3, comment.getCommentContent());
			ps.setString(4, comment.getCommentorHead());
			ps.setTimestamp(5, comment.getCreateTime());
			ps.setString(6, comment.getCommentorName());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closePC(conn, ps);
		}
		
		return result;
	}

	@Override
	public int deleteComment(int commentId) {
		Connection conn = null;
		int result = 0;
		PreparedStatement ps = null;
		String sql = "delete from acomment where commentid=?";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, commentId);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closePC(conn, ps);
		}
		return result;
	}

	@Override
	public int updateComment(Comment comment) {
		
		return 0;
	}

	@Override
	public Comment selectCommentById(int commentId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from acomment where commentid=?";
		Comment comment = null;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, commentId);
			rs = ps.executeQuery();
			if (rs.next()){
				comment = new Comment();
				comment.setCommentId(rs.getInt("commentid"));
				comment.setComImgTxtId(rs.getInt("comimgtxtid"));
				comment.setCommentorId(rs.getInt("commentorid"));
				comment.setCommentContent(rs.getString("commentContent"));
				comment.setCommentorHead(rs.getString("commentorhead"));
				comment.setCreateTime(rs.getTimestamp("commentCreattime"));
				comment.setCommentorName(rs.getString("commentorname"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return comment;
	}

	@Override
	public List<Comment> selectComments(int comimgtxtid) {
		List<Comment>comments = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from acomment where comimgtxtid=? order by commentid desc";
		
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comimgtxtid);
			rs = ps.executeQuery();
			while (rs.next()){
				Comment comment = new Comment();
				comment.setCommentId(rs.getInt("commentid"));
				comment.setComImgTxtId(rs.getInt("comimgtxtid"));
				comment.setCommentorId(rs.getInt("commentorid"));
				comment.setCommentContent(rs.getString("commentContent"));
				comment.setCommentorHead(rs.getString("commentorhead"));
				comment.setCreateTime(rs.getTimestamp("commentCreattime"));
				comment.setCommentorName(rs.getString("commentorname"));
				comments.add(comment);
			
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		return comments;
	}

	@Override
	public int selectImgTxtCommentsNum(int imgtxtid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from acomment where comimgtxtid=?";
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, imgtxtid);
			rs = ps.executeQuery();
			if (rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		
		return result;
	}

	@Override
	public List<Notification> selectNotifications(int myid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Notification>notifis = new ArrayList<>();
		String sql = "SELECT * from acomment where comImgTxtId in (SELECT imgTxtId FROM imgtxt_info where sendid=?)";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,myid);
			rs = ps.executeQuery();
			while(rs.next()){
				Notification notifi = new Notification();
				notifi.setCommentid(rs.getInt("commentid"));
				notifi.setComImgTxtId(rs.getInt("comimgtxtid"));
				notifi.setCommtorid(rs.getInt("commentorid"));
				notifi.setCommContent(rs.getString("commentContent"));
				notifi.setHeadurl(rs.getString("commentorhead"));
				notifi.setCommTime(MyUtil.longTimeToStringStyle(rs.getTimestamp("commentCreatTime")));
				notifi.setComm_time(rs.getTimestamp("commentCreatTime"));
				notifi.setCommName(rs.getString("commentorname"));
				notifi.setComm_type("comm_comm");
				notifis.add(notifi);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
	
		return notifis;
	}

	@Override
	public int selectCommentNotRead(int myid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//List<Notification>notifis = new ArrayList<>();
		String sql = "SELECT count(*) from acomment where comImgTxtId in (SELECT imgTxtId FROM imgtxt_info where sendid=?) and commentstat=0";
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, myid);
			rs = ps.executeQuery();
			if (rs.next()){
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return count;
	}

	@Override
	public int updateCommentNotRead(int myid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update acomment set commentstat = 1 where comImgTxtId in (SELECT imgTxtId FROM imgtxt_info where sendid=?)";
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, myid);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePC(conn, ps);
		}
	
		return result;
	}

}
