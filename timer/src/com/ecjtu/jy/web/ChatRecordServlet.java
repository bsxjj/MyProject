package com.ecjtu.jy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.ecjtu.jy.pojo.ChatRecord;
import com.ecjtu.jy.pojo.PrivateLetter;
import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.service.IChatRecordService;
import com.ecjtu.jy.service.IPrivateLetterService;
import com.ecjtu.jy.service.impl.ChatRecordServiceImpl;
import com.ecjtu.jy.service.impl.PrivateLetterServiceImpl;
import com.ecjtu.jy.utils.JdbcUtils;

@WebServlet("/chatrecord")
public class ChatRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IChatRecordService icrservice = null;
	
  
    public ChatRecordServlet() {
        super();
     
    }
    
	@Override
	public void init() throws ServletException {
		icrservice = new ChatRecordServiceImpl();
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method != null){
			switch (method) {
			case "getallchat":
				doGetAllChatList(request,response);
				break;
			case "sendletter":
				doSendLetter(request,response);
				break;
			default:
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doSendLetter(HttpServletRequest request, HttpServletResponse response){
		Integer receiveid = Integer.parseInt(request.getParameter("userid"));
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo) session.getAttribute("user");
		ChatRecord cr = new ChatRecord();
		cr.setSendid(info.getUserId());
		cr.setReceiveid(receiveid);
		icrservice.insertChatRecord(cr);
		IPrivateLetterService plservice = new PrivateLetterServiceImpl();
		PrivateLetter pl = new PrivateLetter();
		pl.setCr_id(cr.getCrid());
		pl.setPrivateLetterContents(content);
		pl.setSendTime(new Timestamp(System.currentTimeMillis()));
		pl.setSenderId(info.getUserId());
		pl.setAcceptId(receiveid);
		int result = plservice.insertPrivateLetter(pl);
		PrintWriter out = null;
		try {
			 out = response.getWriter();
			 out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
		
		
		
		
	}
	
	
	
	public void doGetAllChatList(HttpServletRequest request, HttpServletResponse response){
		//Integer cr_id = Integer.parseInt(request.getParameter("cr_id"));
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo) session.getAttribute("user");
		if (info != null){
			List<ChatRecord> chatRecordList = icrservice.selectChatRecordList(info.getUserId());
			ObjectMapper omapp = new ObjectMapper();
			ServletOutputStream outputStream = null;
			try {
				outputStream = response.getOutputStream();
				omapp.writeValue(outputStream, chatRecordList);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JdbcUtils.closeServletOutput(outputStream);
			}
		}
		
	}
}
