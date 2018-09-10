package com.ecjtu.jy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IReplyDao;
import com.ecjtu.jy.pojo.Notification;
import com.ecjtu.jy.pojo.Reply;
import com.ecjtu.jy.utils.C3P0Util;
import com.ecjtu.jy.utils.JdbcUtils;
import com.ecjtu.jy.utils.MyUtil;

public class ReplyDaoImpl implements IReplyDao{

	@Override
	public int insertReply(Reply reply) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into reply(rcommentid,replyid,reply_type,replyuserid,replycontent,replyhead,replyname,replycreattime,berepliedname)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reply.getRcommentid());
			ps.setInt(2, reply.getReplyId());
			ps.setString(3, reply.getReply_type());
			ps.setInt(4, reply.getReplyerId());
			ps.setString(5, reply.getReplyContent());
			ps.setString(6, reply.getReplyhead());
			ps.setString(7, reply.getReplyname());
			ps.setTimestamp(8, reply.getReplyTime());
			ps.setString(9, reply.getBeReliedName());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteReply(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from reply where id =?";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateReply(Reply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Reply> selectReplyByCommentId(int commentid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Reply>replies = new ArrayList<>();
		String sql = "select * from reply where rcommentid=? order by id desc";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, commentid);
			rs = ps.executeQuery();
			while (rs.next()){
				Reply reply = new Reply();
				reply.setId(rs.getInt("id"));
				reply.setRcommentid(rs.getInt("rcommentid"));
				reply.setReplyId(rs.getInt("replyid"));
				reply.setReply_type(rs.getString("reply_type"));
				if ("reply_repl".equals(reply.getReply_type())){
					String becontent = this.getBeRepliedContent(reply.getReplyId());
					reply.setBeRepliedContent(becontent);
				}
				reply.setReplyerId(rs.getInt("replyuserid"));
				reply.setReplyContent(rs.getString("replycontent"));
				reply.setReplyhead(rs.getString("replyhead"));
				reply.setReplyname(rs.getString("replyname"));
				reply.setReplyTime(rs.getTimestamp("replycreattime"));
				reply.setBeReliedName(rs.getString("berepliedname"));
				replies.add(reply);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return replies;
		
	}
	
	public String getBeRepliedContent(int replyid){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select replycontent from reply where id=?";
		String content = "";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, replyid);
			rs = ps.executeQuery();
			if (rs.next()){
				content = rs.getString("replycontent");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closePCR(conn, ps, rs);
		}
		
		
		return content;
	}

	@Override
	public List<Notification> selectNotifications_Reply_Comm(int myid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Notification>notifis = new ArrayList<>();
		String sql = "SELECT * from reply where  rcommentId in (SELECT commentid from acomment where commentorId = ?) and reply_type = 'reply_comm'";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, myid);
			rs =ps.executeQuery();
			while(rs.next()){
				Notification notifi = new Notification();
				notifi.setId(rs.getInt("id"));
				notifi.setCommentid(rs.getInt("rcommentid"));
				notifi.setReplyid(rs.getInt("replyid"));
				notifi.setComm_type("comm_reply");
				notifi.setCommtorid(rs.getInt("replyUserid"));
				notifi.setCommContent(rs.getString("replyContent"));
				notifi.setHeadurl(rs.getString("replyhead"));
				notifi.setCommName(rs.getString("replyname"));
				notifi.setCommTime(MyUtil.longTimeToStringStyle(rs.getTimestamp("replyCreatTime")));
				notifi.setComm_time(rs.getTimestamp("replyCreatTime"));
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
	public List<Notification> selectNotifications_Reply_Reply(int myid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Notification>notifis = new ArrayList<>();
		String sql = "SELECT a.id,a.rcommentId,a.replyuserid,a.reply_type,a.replyContent,a.replyHead,a.replyname,a.replyCreatTime,b.replyContent as becontent from reply a,reply b where a.replyid = b.id and b.replyUserId = ?";
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, myid);
			rs =ps.executeQuery();
			while(rs.next()){
				Notification notifi = new Notification();
				notifi.setId(rs.getInt("id"));
				notifi.setCommentid(rs.getInt("rcommentid"));
				notifi.setComm_type("reply_reply");
				notifi.setCommtorid(rs.getInt("replyuserid"));
				notifi.setCommContent(rs.getString("replyContent"));
				notifi.setHeadurl(rs.getString("replyhead"));
				notifi.setCommName(rs.getString("replyname"));
				notifi.setCommTime(MyUtil.longTimeToStringStyle(rs.getTimestamp("replyCreatTime")));
				notifi.setComm_time(rs.getTimestamp("replyCreatTime"));
				notifi.setContent(rs.getString("becontent"));
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
	public Reply selectReplyById(int id) {
		
		return null;
	}

	@Override
	public int selectReply_ToCommNotRead(int myid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) from reply where  rcommentId in (SELECT commentid from acomment where commentorId = ?) and reply_type = 'reply_comm' and replystat = 0";
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
	public int selectReply_ToRelyNotRead(int myid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT count(*)from reply a,reply b where a.replyid = b.id and b.replyUserId = ? and a.replystat = 0";
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
	public int updateReply_ToCommNotRead(int myid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update reply set replystat = 1 where  rcommentId in (SELECT commentid from acomment where commentorId = ?) and reply_type = 'reply_comm' and replystat = 0";
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

	@Override
	public int updateReply_ToRelyNotRead(int myid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update reply a,reply b set a.replystat = 1 where a.replyid = b.id and b.replyUserId = ?";
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
