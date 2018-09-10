package com.ecjtu.jy.service.impl;

import java.util.List;

import com.ecjtu.jy.dao.ICommentDao;
import com.ecjtu.jy.dao.IReplyDao;
import com.ecjtu.jy.dao.impl.CommentDaoImpl;
import com.ecjtu.jy.dao.impl.ReplyDaoImpl;
import com.ecjtu.jy.pojo.Comment;
import com.ecjtu.jy.pojo.Notification;
import com.ecjtu.jy.pojo.Reply;
import com.ecjtu.jy.service.ICommentService;
import com.ecjtu.jy.service.IImgTxtInfoService;

public class CommentServiceImpl implements ICommentService{
	ICommentDao comDao = null;
	IReplyDao ireplyDao = null;
	public CommentServiceImpl() {
		comDao = new CommentDaoImpl();
		ireplyDao = new ReplyDaoImpl();
	}

	@Override
	public int addComment(Comment comment) {
		
		return comDao.insertComment(comment);
	}

	@Override
	public int addReply(Reply reply) {
		
		return ireplyDao.insertReply(reply);
	}

	@Override
	public int removeComment(int commentid) {
		
		return comDao.deleteComment(commentid);
	}

	@Override
	public List<Comment> findImxtxtCommentById(int comimgtxtid) {
		List<Comment> comments = comDao.selectComments(comimgtxtid);
		for (Comment comment : comments) {
			List<Reply> replies = ireplyDao.selectReplyByCommentId(comment.getCommentId());
			comment.setReplies(replies);
		}
	
		return comments;
	}

	@Override
	public int selectImgTxtCommentsNum(int imgtxtid) {
		
		return comDao.selectImgTxtCommentsNum(imgtxtid);
	}

	@Override
	public List<Notification> selectNotifications(int myid) {
		List<Notification> notifications = comDao.selectNotifications(myid);
		IImgTxtInfoService iiservice = new ImgTxtInfoServiceImpl();
		for (Notification notification : notifications) {
			notification.setContent(iiservice.selectImgTxtById(notification.getComImgTxtId()).getText());
		}
		
		return notifications;
	}

	@Override
	public List<Notification> selectNotifications_Reply_Comm(int myid) {
		List<Notification> comms = ireplyDao.selectNotifications_Reply_Comm(myid);
		for (Notification notification : comms) {
			notification.setContent(comDao.selectCommentById(notification.getCommentid()).getCommentContent());
		}
		return comms;
	}

	@Override
	public List<Notification> selectNotifications_Reply_Reply(int myid) {
		
		return ireplyDao.selectNotifications_Reply_Reply(myid);
	}

	@Override
	public int selectCommentNotRead(int myid) {
		
		return comDao.selectCommentNotRead(myid);
	}

	@Override
	public int selectReply_ToCommNotRead(int myid) {
		
		return ireplyDao.selectReply_ToCommNotRead(myid);
	}

	@Override
	public int selectReply_ToRelyNotRead(int myid) {
		
		return ireplyDao.selectReply_ToRelyNotRead(myid);
	}

	@Override
	public int updateCommentNotRead(int myid) {
		// TODO Auto-generated method stub
		return comDao.updateCommentNotRead(myid);
	}

	@Override
	public int updateReply_ToCommNotRead(int myid) {
		
		return ireplyDao.updateReply_ToCommNotRead(myid);
	}

	@Override
	public int updateReply_ToRelyNotRead(int myid) {
		
		return ireplyDao.updateReply_ToRelyNotRead(myid);
	}

}
