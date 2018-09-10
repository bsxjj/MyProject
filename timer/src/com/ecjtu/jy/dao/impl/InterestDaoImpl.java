package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IInterestDao;
import com.ecjtu.jy.pojo.Interest;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;

public class InterestDaoImpl implements IInterestDao {

	
	
	@Override
	public int insertInterst(Interest interest) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "insert into interest(interestId,interestUserId) values(?,?)";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, interest.getInterestid());
			ps.setInt(2, interest.getUserid());
			result = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	
	@Override
	public int insertIntersts(List<Interest> interests) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql = "insert into interest(interestId,interestUserId) values(?,?)";
		
		try {
			conn = C3P0Util.getConnection();
			//���Ȱ�Auto commit����Ϊfalse,�������Զ��ύ 
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for (Interest interest : interests) {
				ps.setInt(1, interest.getInterestid());
				ps.setInt(2, interest.getUserid());
				ps.addBatch();
			}
			ps.executeBatch();
			conn.commit();
			result = 1;//����ɹ�
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				// �������쳣�������ݿ�����������ɵĲ���ȫ����������ع�������ʼ״̬  
                if(!conn.isClosed()){  
                    conn.rollback();//4,���쳣����ִ��catch��SQLExceptionʱ���ǵ�Ҫrollback(�ع�)
                }
                result = 0;//����ʧ��
                conn.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	
	@Override
	public int deleteInterst(int interid, int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "delete from interest  where interestId=? and interestUserId=?";
		
		try {
			conn=C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, interid);
			ps.setInt(2, userid);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		return result;
	}

	@Override
	public int deleteIntersts(int[] ids, int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql = "delete from interest  where interestId=? and interestUserId=?";
		
		try {
			conn = C3P0Util.getConnection();
			//���Ȱ�Auto commit����Ϊfalse,�������Զ��ύ 
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for (int i : ids) {
				ps.setInt(1, i);
				ps.setInt(2, userid);
				ps.addBatch();
			}
			ps.executeBatch();
			conn.commit();
			result = 1;//ɾ���ɹ�
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				// �������쳣�������ݿ�����������ɵĲ���ȫ����������ع�������ʼ״̬  
                if(!conn.isClosed()){  
                    conn.rollback();//4,���쳣����ִ��catch��SQLExceptionʱ���ǵ�Ҫrollback(�ع�)
                }
                result = 0;//ɾ��ʧ��
                conn.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	@Override
	public int updateInterst(Interest inter,int interestId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "update interest set interestId=? where interestUserId=? and interestId=?";
		try {
			conn=C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, interestId);
			ps.setInt(2, inter.getUserid());
			ps.setInt(3, inter.getInterestid());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}

	@Override
	public List<Interest> selectIntersts(int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Interest> interests = new ArrayList<>();
		
		String sql = "select * from interest where interestUserId=?";
		try {
			conn=C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Interest interest = new Interest();
				interest.setInterestid(rs.getInt("interestId"));
				interest.setUserid(rs.getInt("interestUserId"));
				interests.add(interest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		return interests;
	}


}
