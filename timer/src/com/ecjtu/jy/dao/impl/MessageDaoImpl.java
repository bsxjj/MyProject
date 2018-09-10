package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IMessageDao;
import com.ecjtu.jy.pojo.Message;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;
import com.ecjtu.jy.utils.Page;

public class MessageDaoImpl implements IMessageDao{

	
	
	@Override
	public int insertMessage(Message mess) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="insert into message values(?,?,?,?,?,?)";
		int result=0;
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mess.getId());
			ps.setInt(2, mess.getMessageuserid());
			ps.setString(3, mess.getMessageuser());
			ps.setString(4, mess.getMessage());
			ps.setString(5, mess.getMessageuserimgge());
			ps.setInt(6, mess.getBemessageid());
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
	public int deleteMessage(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="delete from message where messageId=?";
		int result=0;
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
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
	public List<Message> selectMessagesByPageNum(int pageNum, int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Message> messages=new ArrayList<Message>();
		String sql="select * from message where beMessageUserId=? order by beMessageUserId limit ?,?";
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, (pageNum-1)*Page.MESSAGEPAGE_NUM);
			ps.setInt(3, Page.MESSAGEPAGE_NUM);
			rs=ps.executeQuery();
			while(rs.next()){
				Message message=new Message();
				message.setId(rs.getInt("messageId"));
				message.setMessageuserid(rs.getInt("messageUserId"));
				message.setMessageuser(rs.getString("messageUserName"));
				message.setMessage(rs.getString("message"));
				message.setMessageuserimgge(rs.getString("messageUserImg"));
				message.setBemessageid(rs.getInt("beMessageUserId"));
				messages.add(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return messages;
	}

	@Override
	public int selectMessageCount(int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select count(messageId) from message where beMessageUserId=?";
		int count=0;
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt("count(messageId)");
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
