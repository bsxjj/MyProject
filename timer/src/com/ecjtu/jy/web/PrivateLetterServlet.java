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

import com.ecjtu.jy.pojo.PrivateLetter;
import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.service.ICommentService;
import com.ecjtu.jy.service.IPrivateLetterService;
import com.ecjtu.jy.service.impl.CommentServiceImpl;
import com.ecjtu.jy.service.impl.PrivateLetterServiceImpl;
import com.ecjtu.jy.utils.JdbcUtils;


@WebServlet("/privateletter")
public class PrivateLetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IPrivateLetterService priService = null;
   
    @Override
	public void init() throws ServletException {
    	priService = new PrivateLetterServiceImpl();
		super.init();
	}

	public PrivateLetterServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method != null){
			switch (method) {
			case "getlenum":
				doGetLetterCount(request,response);
				break;
			case "getallletter":
				doGeAlltLetter(request,response);
				break;
			case "saveletter":
				doGetSaveLetter(request,response);
				break;
			case "notread":
				doGetNotRead(request,response);
				break;
				
			case "userinfo_sendletter":
				doSendUserIndoLetter(request,response);
				break;
			case "privatenotread":
				doGetPrivateNotRead(request,response);
				break;
				
			default:
				break;
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void doSendUserIndoLetter(HttpServletRequest request, HttpServletResponse response){
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		String content = request.getParameter("content");
		
		
		
	}
	private void doGetPrivateNotRead(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo) session.getAttribute("user");
		Integer countNum = 0;
		countNum = countNum + priService.selectLetterCountByNotRead(info.getUserId());
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(countNum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (out != null){
				out.close();
			}
			
		}
	}
	
	
	/**
	 * 获取所有未读的消息
	 * @param request
	 * @param response
	 */
	private void doGetNotRead(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo) session.getAttribute("user");
		ICommentService icservice = new CommentServiceImpl();
		Integer countNum = 0;
		if (info != null){
			countNum = countNum + priService.selectLetterCountByNotRead(info.getUserId());
			countNum = countNum + icservice.selectCommentNotRead(info.getUserId());
			countNum = countNum + icservice.selectReply_ToCommNotRead(info.getUserId());
			countNum = countNum + icservice.selectReply_ToRelyNotRead(info.getUserId());
			
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(countNum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (out != null){
				out.close();
			}
			
		}
		
		
	}
	
	
	public void doGetSaveLetter(HttpServletRequest request, HttpServletResponse response){
		int sendid = Integer.parseInt(request.getParameter("sendid"));
		int acceptid = Integer.parseInt(request.getParameter("acceptid"));
		String content = request.getParameter("content");
		int crid = Integer.parseInt(request.getParameter("crid"));
		PrivateLetter pletter = new PrivateLetter();
		pletter.setSenderId(sendid);
		pletter.setAcceptId(acceptid);
		pletter.setPrivateLetterContents(content);
		pletter.setCr_id(crid);
		pletter.setSendTime(new Timestamp(System.currentTimeMillis()));
		int result = priService.insertPrivateLetter(pletter);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (result > 0){
				System.out.println("私信成功");
				out.print("");
			}else{
				System.out.println("私信失败");
				out.print("私信失败");
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
	
	
	public void doGetLetterCount(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo) session.getAttribute("user");
		if (info != null){
			Integer count = priService.selectLetterCount(info.getUserId());
			PrintWriter out = null;
			try {
				out = response.getWriter();
				out.print(count);
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
	public void doGeAlltLetter(HttpServletRequest request, HttpServletResponse response){
		int crid = Integer.parseInt(request.getParameter("crid"));
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo) session.getAttribute("user");
		if (info != null){
			List<PrivateLetter> letterList = priService.selectLetterUserList(crid,info.getUserId());
			System.out.println("-----"+letterList.size());
			ObjectMapper ommp = new ObjectMapper();
			ServletOutputStream outputStream = null;
			try {
				outputStream = response.getOutputStream();
				ommp.writeValue(outputStream,letterList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JdbcUtils.closeServletOutput(outputStream);
			}
			
		}
	}
	
	
	

}
