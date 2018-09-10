package com.ecjtu.jy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.ecjtu.jy.pojo.Comment;
import com.ecjtu.jy.pojo.Notification;
import com.ecjtu.jy.pojo.Reply;
import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.service.ICommentService;
import com.ecjtu.jy.service.impl.CommentServiceImpl;
import com.ecjtu.jy.utils.ComparatorByDate;
import com.ecjtu.jy.utils.JdbcUtils;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ICommentService service = null;
    public CommentServlet() {
        
    }
    
    @Override
	public void init() throws ServletException {
    	service = new CommentServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
    	switch (method) {
		case "addcomm":
			doAddComment(request,response);
			break;
		case "getcomms":
			doGetComments(request,response);
			break;
		case "addreply":
			doAddReply(request,response);
			break;
		case "getnotifi":
			doGetNotifications(request,response);
			break;
		case "getnotread":
			doGetCommNotRead(request,response);
			break;
		
		default:
			break;
		}
	}

	public void doGetCommNotRead(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo)session.getAttribute("user");
		int countNum = 0;
		countNum = countNum + service.selectCommentNotRead(info.getUserId());
		countNum = countNum + service.selectReply_ToCommNotRead(info.getUserId());
		countNum = countNum + service.selectReply_ToRelyNotRead(info.getUserId());
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(countNum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
		}
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	@SuppressWarnings("unchecked")
	public void doGetNotifications(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo)session.getAttribute("user");
		List<Notification> notifications = service.selectNotifications(info.getUserId());
		
		notifications.addAll(service.selectNotifications_Reply_Comm(info.getUserId()));
		notifications.addAll(service.selectNotifications_Reply_Reply(info.getUserId()));
		ComparatorByDate bydate = new ComparatorByDate();
		Collections.sort(notifications, bydate);
		for (Notification notification : notifications) {
			notification.setMyName(info.getUsername());
		}
		service.updateCommentNotRead(info.getUserId());
		service.updateReply_ToCommNotRead(info.getUserId());
		service.updateReply_ToRelyNotRead(info.getUserId());
		ObjectMapper ompp = new ObjectMapper();
		ServletOutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
			ompp.writeValue(outputStream, notifications);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeServletOutput(outputStream);
		}
	}
	
	public void doAddComment(HttpServletRequest request, HttpServletResponse response){
		String strimgtxtid = request.getParameter("imgtxtid");
		int imgtxtid = Integer.parseInt(strimgtxtid);
		String comm_content = request.getParameter("comm_content");
		System.out.println("imgtxtid :" +imgtxtid +" comm_content:" +comm_content);
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo)session.getAttribute("user");
		Comment comment = new Comment(imgtxtid, info.getUserId(), comm_content, info.getHeadPicture(), info.getUsername(), new Timestamp(System.currentTimeMillis()));
		int result = service.addComment(comment);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (result > 0){
				out.print("评论成功");
			}else{
				out.print("评论失败");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (out != null){
				out.close();
			}
		}
		
		
	}
	public void doGetComments(HttpServletRequest request, HttpServletResponse response){
		int imgtxtid = Integer.parseInt(request.getParameter("imgtxtid"));
		List<Comment> comments = service.findImxtxtCommentById(imgtxtid);
		ObjectMapper mapper = new ObjectMapper();
		ServletOutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
			mapper.writeValue(outputStream, comments);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeServletOutput(outputStream);
		}
		
		
		
	}
	public void doAddReply(HttpServletRequest request, HttpServletResponse response){
		String type = request.getParameter("type");
		String reply_content = request.getParameter("reply_content");
		String rootcomid = request.getParameter("rootcomid");
		int rootid = Integer.parseInt(rootcomid);
		System.out.println("--------------"+reply_content);
		String strreplyid = request.getParameter("replyid");
		int replyid = Integer.parseInt(strreplyid);
		String berepliedName = request.getParameter("berepliedName");
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo) session.getAttribute("user");
		if (info != null){
			Reply reply = new Reply(berepliedName, replyid, type, info.getUserId(), reply_content, info.getHeadPicture(),info.getUsername(),new Timestamp(System.currentTimeMillis()));
			reply.setRcommentid(rootid);
			int result = service.addReply(reply);
			PrintWriter out = null;
			try {
				out = response.getWriter();
				if (result > 0){
					out.print("回复成功");
				}else{
					out.print("回复失败");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if (out != null){
					out.close();
				}
			}
			
		}
		
	
	}
	

}
