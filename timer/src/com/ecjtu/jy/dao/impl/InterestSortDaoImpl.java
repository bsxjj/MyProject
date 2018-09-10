package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ecjtu.jy.dao.IInterstSortDao;
import com.ecjtu.jy.pojo.InterestSort;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;
import com.ecjtu.jy.utils.Page;

public class InterestSortDaoImpl implements IInterstSortDao {

	
	
	@Override
	public int insertInterSort(InterestSort interSort) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "insert into inerestsort(inerestSortId,inerestSortName) values(?,?)";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, interSort.getInterestSortId());
			ps.setString(2, interSort.getInterestSortName());
			result = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	@Override
	public int deleteInterstSort(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("delete from inerestSort where inerestSortId=?");
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
	public int updateInterstSort(InterestSort interSort) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("update inerestSort set inerestSortName=? where inerestSortId=?");
			ps.setString(1, interSort.getInterestSortName());
			ps.setInt(2, interSort.getInterestSortId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	@Override
	public List<InterestSort> selectInterSorts(int pageNum) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<InterestSort> iSorts = new ArrayList<>();
		int page = (pageNum-1)*Page.COMMON_NUM;
		try {
			conn = conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from inerestsort limit ?,?");
			ps.setInt(1,page);
			ps.setInt(2, Page.COMMON_NUM);
			rs = ps.executeQuery();
			while(rs.next()) {
				InterestSort iSort = new InterestSort();
				iSort.setInterestSortId(rs.getInt("inerestSortId"));
				iSort.setInterestSortName(rs.getString("inerestSortName"));
				iSorts.add(iSort);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return iSorts;
	}

	@Override
	public String selectInterSortNameById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String interSortName = "";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select inerestSortName from inerestsort where inerestSortId=?");
			ps.setInt(1, id);
			rs =  ps.executeQuery();
			while (rs.next()) {
				interSortName = rs.getString("inerestSortName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		return interSortName;
	}

}
