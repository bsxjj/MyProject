package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.ecjtu.jy.dao.IUserInfoDao;
import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;


public class UserInfoImpl implements IUserInfoDao{

	
	
	
	
	@Override
	public UserInfo selectUserByPassAndUserName(String userName, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfo userInfo = null;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from user_info where username=? and userPassword=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()){
				userInfo = new UserInfo(rs.getInt("userid"),rs.getString("username"),rs.getString("userpassword"),rs.getString("sex"), rs.getString("place"), rs.getTimestamp("userCreatTim"), rs.getString("headPicture"), rs.getInt("messagePower"), rs.getInt("visitPower"), rs.getInt("isAdmin"),rs.getString("email"));
				userInfo.setSignature(rs.getString("signature"));
			}
			/**
			 * rs.getDate("") 数据库里的类型为Date
			 * rs.getTimestamp("") 数据库里的类型为DateTIme
			 * 
			 */
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return userInfo;
	}

	@Override
	public int validateUserName(String userName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select username from user_info where username=?";
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()){
				count = 1;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return count;
	}

	@Override
	public int validateEmail(String email) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select email from user_info where email=?";
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()){
				count = 1;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return count;
	}

	@Override
	public UserInfo selectUserById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user_info where userid=?";
		UserInfo userInfo = null;
		
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()){
				userInfo = new UserInfo(rs.getInt("userid"), rs.getString("username"), rs.getString("userpassword"), rs.getString("sex"), rs.getString("place"), rs.getTimestamp("usercreattim"), rs.getString("headpicture"), rs.getInt("messagepower"), rs.getInt("visitpower"), rs.getInt("isAdmin"),rs.getString("email"));
				userInfo.setBirthday(rs.getDate("birthday"));
				userInfo.setSignature(rs.getString("signature"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		return userInfo;
	}

	@Override
	public List<UserInfo> selectUsersById(String likeName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user_info where username like %?%";
		UserInfo userInfo = null;
		List<UserInfo>users = new ArrayList<>();
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, likeName);
			rs = ps.executeQuery();
			while (rs.next()){
				userInfo = new UserInfo(rs.getInt("userid"), rs.getString("username"), rs.getString("userpassword"), rs.getString("sex"), rs.getString("place"), rs.getTimestamp("usercreattim"), rs.getString("headpicture"), rs.getInt("messagepower"), rs.getInt("visitpower"), rs.getInt("isAdmin"),rs.getString("email"));
				userInfo.setBirthday(rs.getDate("birthday"));
				users.add(userInfo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return users;
	}

	@Override
	public int insertUser(UserInfo user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into user_info(username,userpassword,sex,userCreatTim,email)values(?,?,?,?,?)";
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3,user.getSex());
			ps.setTimestamp(4,user.getUserCreateTime());
			ps.setString(5, user.getEmail());
			count = ps.executeUpdate();
			if (count > 0){
				rs = ps.getGeneratedKeys();
				if (rs.next()){
					count = rs.getInt(1);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return count;
	}

	@Override
	public int updateUserImg(String img,int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update user_info set headpicture = ? where userid=?";
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, img);
			ps.setInt(2, userid);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePC(conn, ps);
		}
		
		return count;
	}

	@Override
	public int updateUserInfo(UserInfo user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update user_info set sex = ?,place=?,birthday=? where userid =?";
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getSex());
			ps.setString(2, user.getPlace());
			ps.setDate(3, user.getBirthday());
			ps.setInt(4, user.getUserId());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePC(conn, ps);
		}
		
		return count;
	}

	@Override
	public int updateUserMessagePower(int power,int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update user_info set messagepower=? where userid=?";
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, power);
			ps.setInt(2, id);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePC(conn, ps);
		}
		
		
		
		return count;
	}

	@Override
	public int updateUserVisitPower(int power,int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update user_info set visitpower=? where userid=?";
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, power);
			ps.setInt(2, id);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePC(conn, ps);
		}
		
		return count;
	}

	@Override
	public int deleteUser(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from user_info where userid=?";
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePC(conn, ps);
		}
		
		return count;
	}

}
