package com.ecjtu.jy.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import com.ecjtu.jy.dao.IFollowDao;
import com.ecjtu.jy.pojo.Follow;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;
import com.ecjtu.jy.utils.Page;


public class FollowDaoImpl implements IFollowDao {
	
	
	@Override
	public List<Follow> selectFollowByPageNum(int pageNum, int id, int type) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Follow> follows = new ArrayList<>();
		int page = (pageNum-1)*Page.COMMON_NUM;
		try {
			conn = C3P0Util.getConnection();
			if (type == 0) {
				ps = conn.prepareStatement("select * from follow where followerid=? limit ?,?");
			}else {
				ps = conn.prepareStatement("select * from follow where befollowerid=? limit ?,?");
			}
			ps.setInt(1,id);
			ps.setInt(2,page);
			ps.setInt(3, Page.COMMON_NUM);
			rs = ps.executeQuery();
			while(rs.next()) {
				Follow follow = new Follow();
				follow.setId(rs.getInt("id"));
				follow.setFollowerId(rs.getInt("followerid"));
				follow.setBeFollowerId(rs.getInt("befollowerid"));
				follow.setFollowTime(rs.getTimestamp("ftime"));
//				follow.setFollowerName(rs.getString("followerName"));
//				follow.setFollowerImg(rs.getString("followImg"));
				follows.add(follow);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		return follows;
	}

	@Override
	public int selectFollowUserCount(int id, int type) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = C3P0Util.getConnection();
			
			if (type == 0) {
				ps = conn.prepareStatement("select count(id) count from follow where followerid=?");
			}else {
				ps = conn.prepareStatement("select count(id) count from follow where befollowerid=?");
			}
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				count=rs.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return count;
	}

	@Override
	public Follow selectFollowById(int id, int type) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Follow follow = new Follow();
		try {
			conn = C3P0Util.getConnection();
			
			if (type == 0) {
				ps = conn.prepareStatement("select * from follow where followerid=?");
			}else {
				ps = conn.prepareStatement("select * from follow where befollowerid=?");
			}
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				follow.setId(rs.getInt("id"));
				follow.setFollowerId(rs.getInt("followerid"));
				follow.setBeFollowerId(rs.getInt("befollowerid"));
				follow.setFollowTime(rs.getTimestamp("ftime"));
//				follow.setFollowerName(rs.getString("followerName"));
//				follow.setFollowerImg(rs.getString("followImg"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		
		return follow;
	}

	@Override
	public int deleteFollowById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("delete from follow where id=?");
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
	public int insertFollow(Follow follow) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String insert_sql="insert into follow(followerid,befollowerid,ftime) values(?,?,?)";
	
		int result = 0 ;
		try {
			//
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(insert_sql);
			ps.setInt(1, follow.getFollowerId());
			ps.setInt(2, follow.getBeFollowerId());
			ps.setTimestamp(3, follow.getFollowTime());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn,ps,rs);
		}	
		return result;
	}

	@Override
	public boolean isFocus(int userid, int myid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from follow where followerid = ? and befollowerid = ?";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, myid);
			ps.setInt(2, userid);
			rs = ps.executeQuery();
			if (rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			JdbcUtils.closePCR(conn, ps, rs);
			
		}
		return false;
	}

	@Override
	public int deleteFollowByFollow(Follow follow) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from follow where followerid = ? and befollowerid = ?";
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, follow.getFollowerId());
			ps.setInt(2, follow.getBeFollowerId());
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
