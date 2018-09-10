package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IImgTxtInfoDao;
import com.ecjtu.jy.pojo.ImgTxtInfo;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;
import com.ecjtu.jy.utils.Page;;

public class ImgTxtInfoDaoImpl implements IImgTxtInfoDao {

	
	

	
	@Override
	public int insertImgTxtInfo(ImgTxtInfo imgTxt) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "insert into imgtxt_info(imgUrl,text,sendId,"
				+ "imgTxtSendTime,imgTxtPowerStatus) values(?,?,?,?,?)";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, imgTxt.getImgUrl());
			ps.setString(2, imgTxt.getText());
			ps.setInt(3, imgTxt.getSendId());
			ps.setTimestamp(4, imgTxt.getImgTxtSendTime());
			ps.setInt(5, imgTxt.getImgTxtPowerStatus());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		return result;
	}

	@Override
	public int deleteImgTxtInfoById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int result = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("delete from imgtxt_info where imgTxtId=?");
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
	public List<ImgTxtInfo> selectImgTxtByPageNum(int pageNum, int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ImgTxtInfo> imgTxtInfos = new ArrayList<>();
		String sql = "";
		sql = "select * from imgtxt_Info where sendId=? order by imgTxtId DESC limit ?,?";
		int page = (pageNum-1)*Page.IMGTXTPAGE_NUM;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setInt(2,page);
			ps.setInt(3, Page.IMGTXTPAGE_NUM);
			rs = ps.executeQuery();
			while(rs.next()) {
				ImgTxtInfo imgTxtInfo = new ImgTxtInfo();
				imgTxtInfo.setImgTxtId(rs.getInt("imgTxtId"));
				imgTxtInfo.setImgUrl(rs.getString("imgUrl"));
				imgTxtInfo.setText(rs.getString("text"));
				imgTxtInfo.setSendId(rs.getInt("sendId"));
				imgTxtInfo.setImgTxtSendTime(rs.getTimestamp("imgTxtSendTime"));
				imgTxtInfo.setSendPlace(rs.getString("sendPlace"));
				imgTxtInfo.setImgTxtPowerStatus(rs.getInt("imgtxtPowerStatus"));
				imgTxtInfos.add(imgTxtInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return imgTxtInfos;
	}

	@Override
	public int selectImgTxtSum(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int sum = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select count(sendId) count from imgtxt_info where sendId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				sum=rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return sum;
	}

	@Override
	public ImgTxtInfo selectImgTxtById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ImgTxtInfo imgTxtInfo = new ImgTxtInfo();
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from imgtxt_info where imgTxtId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				imgTxtInfo.setImgTxtId(rs.getInt("imgTxtId"));
				imgTxtInfo.setImgUrl(rs.getString("imgUrl"));
				imgTxtInfo.setText(rs.getString("text"));
				imgTxtInfo.setSendId(rs.getInt("sendId"));
				imgTxtInfo.setImgTxtSendTime(rs.getTimestamp("imgTxtSendTime"));
				imgTxtInfo.setSendPlace(rs.getString("sendPlace"));
				imgTxtInfo.setImgTxtPowerStatus(rs.getInt("imgtxtPowerStatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return imgTxtInfo;
	}

	@Override
	public List<ImgTxtInfo> selectImgTxtByHot(int pageNum, int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ImgTxtInfo> imgTxtInfos = new ArrayList<>();
		String sql = "select * from imgtxt_info i, " + 
				"(SELECT COUNT(laudId),laudImgTxtId FROM laud  GROUP BY laudImgTxtId HAVING COUNT(laudId) ORDER by COUNT(laudId) deSC) id " + 
				"WHERE i.imgTxtId = id.laudImgTxtId LIMIT ?,?";
		int page = (pageNum-1)*Page.IMGTXTPAGE_NUM;
		
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,page);
			ps.setInt(2, Page.IMGTXTPAGE_NUM);
			rs = ps.executeQuery();
			while(rs.next()) {
				ImgTxtInfo imgTxtInfo = new ImgTxtInfo();
				imgTxtInfo.setImgTxtId(rs.getInt("imgTxtId"));
				imgTxtInfo.setImgUrl(rs.getString("imgUrl"));
				imgTxtInfo.setText(rs.getString("text"));
				imgTxtInfo.setSendId(rs.getInt("sendId"));
				imgTxtInfo.setImgTxtSendTime(rs.getTimestamp("imgTxtSendTime"));
				imgTxtInfo.setSendPlace(rs.getString("sendPlace"));
				imgTxtInfo.setImgTxtPowerStatus(rs.getInt("imgtxtPowerStatus"));
				imgTxtInfos.add(imgTxtInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		return imgTxtInfos;
	}

	@Override
	public List<ImgTxtInfo> selectImgTxtByComment(int pageNum, int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ImgTxtInfo> imgTxtInfos = new ArrayList<>();
		String sql = "select * from imgtxt_info i, " + 
				"(SELECT COUNT(commentId),comImgTxtId FROM acomment GROUP BY comImgTxtId HAVING COUNT(commentId) ORDER by COUNT(commentId) DESC) id " + 
				"WHERE i.imgTxtId = id.comImgTxtId LIMIT ?,?";
		int page = (pageNum-1)*Page.IMGTXTPAGE_NUM;
		
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,page);
			ps.setInt(2, Page.IMGTXTPAGE_NUM);
			rs = ps.executeQuery();
			while(rs.next()) {
				ImgTxtInfo imgTxtInfo = new ImgTxtInfo();
				imgTxtInfo.setImgTxtId(rs.getInt("imgTxtId"));
				imgTxtInfo.setImgUrl(rs.getString("imgUrl"));
				imgTxtInfo.setText(rs.getString("text"));
				imgTxtInfo.setSendId(rs.getInt("sendId"));
				imgTxtInfo.setImgTxtSendTime(rs.getTimestamp("imgTxtSendTime"));
				imgTxtInfo.setSendPlace(rs.getString("sendPlace"));
				imgTxtInfo.setImgTxtPowerStatus(rs.getInt("imgtxtPowerStatus"));
				imgTxtInfos.add(imgTxtInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		return imgTxtInfos;
	}

	@Override
	public int selectAllImgTxtNum() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int sum = 0;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select count(imgtxtid) count from imgtxt_info");
			rs = ps.executeQuery();
			while (rs.next()) {
				sum=rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, rs);
		}
		return sum;
		//return 0;
	}

	@Override
	public List<ImgTxtInfo> selectImgTxtByPageNum(int pageNum) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ImgTxtInfo> imgTxtInfos = new ArrayList<>();
		ResultSet result = null;
		int page = (pageNum-1)*Page.IMGTXTPAGE_NUM;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("select * from imgtxt_Info order by imgTxtId DESC limit ?,?");
			ps.setInt(1,page);
			ps.setInt(2, Page.IMGTXTPAGE_NUM);
			result = ps.executeQuery();
			while(result.next()) {
				ImgTxtInfo imgTxtInfo = new ImgTxtInfo();
				imgTxtInfo.setImgTxtId(result.getInt("imgTxtId"));
				imgTxtInfo.setImgUrl(result.getString("imgUrl"));
				imgTxtInfo.setText(result.getString("text"));
				imgTxtInfo.setSendId(result.getInt("sendId"));
				imgTxtInfo.setImgTxtSendTime(result.getTimestamp("imgTxtSendTime"));
				imgTxtInfo.setSendPlace(result.getString("sendPlace"));
				imgTxtInfo.setImgTxtPowerStatus(result.getInt("imgtxtPowerStatus"));
				imgTxtInfos.add(imgTxtInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closePCR(conn, ps, result);
		}
		return imgTxtInfos;
	}

}
