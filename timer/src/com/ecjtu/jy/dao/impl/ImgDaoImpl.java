package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IImgDao;
import com.ecjtu.jy.pojo.Img;
import com.ecjtu.jy.pojo.Interest;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;

public class ImgDaoImpl implements IImgDao {
	
	


	@Override
	public int insertImg(Img img) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("insert into img(imgId,belongId,aImgUrl) values(?,?,?)");
			ps.setInt(1, img.getImgId());
			ps.setInt(2, img.getBelongId());
			ps.setString(3, img.getImgUrl());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return result;
	}


	@Override
	public int deleteImg(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("delete from img where imgId = ?");
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
	public List<Img> selectImgsById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Img> imgs = new ArrayList<>();
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from img where belongId = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Img img = new Img();
				img.setImgId(rs.getInt("imgId"));
				img.setBelongId(rs.getInt("belongId"));
				img.setImgUrl(rs.getString("aimgUrl"));
				imgs.add(img);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return imgs;
	}

	@Override
	public int insertImgs(List<Img> imgs) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql = "insert into img(imgId,belongId,aImgUrl) values(?,?,?)";
		
		try {
			conn = C3P0Util.getConnection();
			//���Ȱ�Auto commit����Ϊfalse,�������Զ��ύ 
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for (Img img : imgs) {
				ps.setInt(1, img.getImgId());
				ps.setInt(2, img.getBelongId());
				ps.setString(3, img.getImgUrl());
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
	public int deleteImgs(int[] ids) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql = "delete from img  where imgId=?";
		
		try {
			conn = C3P0Util.getConnection();
			//���Ȱ�Auto commit����Ϊfalse,�������Զ��ύ 
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for (int i : ids) {
				ps.setInt(1, i);
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
	public List<Img> selectImgsByNew(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Img> imgs = new ArrayList<>();
		String sql = "SELECT * from img WHERE belongId in (select albumId from album where albumCreatorId=?) ORDER BY upload_time DESC LIMIT 0,8";
		
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Img img = new Img();
				img.setImgId(rs.getInt("imgId"));
				img.setBelongId(rs.getInt("belongId"));
				img.setImgUrl(rs.getString("aimgUrl"));
				imgs.add(img);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return imgs;
		
	}

}
