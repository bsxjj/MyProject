package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IPrivateLetterDao;
import com.ecjtu.jy.pojo.PrivateLetter;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;
import com.ecjtu.jy.utils.Page;

public class PrivateLetterDaoImpl implements IPrivateLetterDao{

	
	
	@Override
	public int insertPrivateLetter(PrivateLetter letter) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="insert into privateletter(cr_id,privatelettercontent,sendtime,sendid,acceptid) values(?,?,?,?,?)";
		int result=0;
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, letter.getCr_id());
			ps.setString(2, letter.getPrivateLetterContents());
			ps.setTimestamp(3, letter.getSendTime());
			ps.setInt(4, letter.getSenderId());
			ps.setInt(5, letter.getAcceptId());
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
	public int deletePrivateLetter(int user1id, int user2id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="delete from privateletter where sendId=? and acceptId=?";
		int result=0;
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, user1id);
			ps.setInt(2, user2id);
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
	public int deletePrivateLetterById(int letterid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="delete from privateletter where privateLetterId=?";
		int result=0;
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, letterid);
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
	public List<PrivateLetter> selectLetterByPageNum(int pageNum, int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<PrivateLetter> letters=new ArrayList<PrivateLetter>();
		String sql="select * from privateletter where sendId=? order by sendId limit ?,? ";
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, (pageNum-1)*Page.COMMON_NUM);
			ps.setInt(3, Page.COMMON_NUM);
			rs=ps.executeQuery();
			while(rs.next()){
				PrivateLetter letter=new PrivateLetter();
				letter.setPrivateLetterId(rs.getInt("privateLetterId"));
				letter.setPrivateLetterContents(rs.getString("privateLetterContent"));
				letter.setPrivateLetterType(rs.getInt("privateLetterType"));
				letter.setAcceptStatus(rs.getInt("acceptStatus"));
				letter.setSendTime(rs.getTimestamp("sendTime"));
				letter.setSenderId(rs.getInt("sendId"));
				letter.setAcceptId(rs.getInt("acceptId"));
				letters.add(letter);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePC(conn, ps);
		}
		return letters;
	}

	@Override
	public int selectLetterCount(int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select count(privateLetterId) from privateletter where sendId=? or acceptid=?";
		int count=0;
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, userid);
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
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
	public int selectLetterCountByNotRead(int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select count(*) from privateletter where acceptId=? and acceptStatus=0";
		int count=0;
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return count;
	}

	@Override
	public int selectLetterCountByIsRead(int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select count(privateLetterContent) from privateletter where acceptId=? and acceptStatus=1";
		int count=0;
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt("count(privateLetterContent)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return count;
	}

	@Override
	public List<PrivateLetter> selectLetterByPageNum(int pageNum, int userid, int type) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<PrivateLetter> letters=new ArrayList<PrivateLetter>();
		String sql="select * from privateletter where acceptId=? and acceptStatus=? limit ?,?";
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, type);
			ps.setInt(3, (pageNum-1)*Page.COMMON_NUM);
			ps.setInt(4, Page.COMMON_NUM);
			rs=ps.executeQuery();
			while(rs.next()){
				PrivateLetter letter=new PrivateLetter();
				letter.setPrivateLetterId(rs.getInt("privateLetterId"));
				letter.setPrivateLetterContents(rs.getString("privateLetterContent"));
				letter.setPrivateLetterType(rs.getInt("privateLetterType"));
				letter.setAcceptStatus(rs.getInt("acceptStatus"));
				letter.setSendTime(rs.getTimestamp("sendTime"));
				letter.setSenderId(rs.getInt("sendId"));
				letter.setAcceptId(rs.getInt("acceptId"));
				letters.add(letter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return letters;
	}

	@Override
	public List<PrivateLetter> selectLetterUserList(int crid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<PrivateLetter> letters=new ArrayList<PrivateLetter>();
		String sql="select * from privateletter where cr_id = ? order by privateletterid asc";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, crid);
			rs = ps.executeQuery();
			while(rs.next()){
				PrivateLetter p = new PrivateLetter();
				p.setPrivateLetterId(rs.getInt("privateLetterId"));
				p.setCr_id(rs.getInt("cr_id"));
				p.setPrivateLetterContents(rs.getString("privateLetterContent"));
				p.setPrivateLetterType(rs.getInt("privateLetterType"));
				p.setAcceptStatus(rs.getInt("acceptStatus"));
				p.setSendTime(rs.getTimestamp("sendTime"));
				p.setSenderId(rs.getInt("sendId"));
				p.setAcceptId(rs.getInt("acceptId"));
				letters.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return letters;
	}

	@Override
	public List<PrivateLetter> selectLetterByCrid(int crid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateLetter(int privateletid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update privateletter set acceptStatus = 1 where privateletterid=?";
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, privateletid);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closePC(conn, ps);
			
		}
		return result;
	}

	
}
