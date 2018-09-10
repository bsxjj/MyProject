package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IChatRecordDao;
import com.ecjtu.jy.pojo.ChatRecord;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;

public class ChatRecordDaoImpl implements IChatRecordDao{

	@Override
	public ChatRecord insertChatRecord(ChatRecord cr) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		int count = 0;
		if (this.isExits(cr)){
			return cr;
		}
		String sql = "insert into chat_record(sendid,receiveid)values(?,?)";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, cr.getSendid());
			ps.setInt(2, cr.getReceiveid());
			count = ps.executeUpdate();
			if (count > 0){
				rs = ps.getGeneratedKeys();
				if (rs.next()){
					cr.setCrid(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		return cr;
	}

	@Override
	public int deleteChatRecord(int crid,int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		String sql = "update chat_record ";
		int result = 0;
		if (this.isliveSend(crid, userid)){
			sql = sql + "set sendstat = 1 where crid=?";
		}else{
			sql = sql + "set receivestat = 1 where crid=?";
		}
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, crid);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int updateChatRecord(int crid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ChatRecord> selectChatRecordList(int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<ChatRecord>records = new ArrayList<>();
		String sql = "select * from chat_record where sendid = ? and sendstat = 0 or receiveid=? and receivestat = 0";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, userid);
			rs = ps.executeQuery();
			while(rs.next()){
				ChatRecord cr = new ChatRecord();
				cr.setCrid(rs.getInt("cr_id"));
				cr.setSendid(rs.getInt("sendid"));
				cr.setReceiveid(rs.getInt("receiveid"));
				if (cr.getSendid() == userid){
					cr.setSend(true);
				}
				records.add(cr);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		
		return records;
	}
	
	//是否是发送者
	public boolean isliveSend(int crid,int userid){
		boolean issend = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		String sql = "select * from chat_record where cr_id = ? and sendid =?";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, crid);
			ps.setInt(2, userid);
			rs = ps.executeQuery();
			if (rs.next()){
				issend = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return issend;
	}
	
	
	public boolean isExits(ChatRecord cr){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		boolean isChatExits = false;
		String sql = "select cr_id from chat_record where sendid = ? and receiveid = ? or sendid = ? and receiveid=?;";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cr.getSendid());
			ps.setInt(2, cr.getReceiveid());
			ps.setInt(3, cr.getReceiveid());
			ps.setInt(4, cr.getSendid());
			rs = ps.executeQuery();
			if (rs.next()){
				isChatExits = true;
				cr.setCrid(rs.getInt("cr_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return isChatExits;
	}

}
