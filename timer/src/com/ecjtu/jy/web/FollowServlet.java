package com.ecjtu.jy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.ecjtu.jy.pojo.Follow;
import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.service.IFollowService;
import com.ecjtu.jy.service.impl.FollowServiceImpl;
import com.ecjtu.jy.utils.JdbcUtils;


@WebServlet("/follow")
public class FollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IFollowService followService = new FollowServiceImpl();
    private ObjectMapper mapper = new ObjectMapper();
    public FollowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method) {
		case "getfans":
			doGetFans(request,response);
			break;
		case "addfocus":
			doGetAddFocus(request,response);
			break;
		case "rmfocus":
			doGetRmFocus(request,response);
			break;
				
		default:
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void doGetAddFocus(HttpServletRequest request, HttpServletResponse response){
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		UserInfo info = (UserInfo)request.getSession().getAttribute("user");
		Follow follow = new Follow();
		follow.setFollowerId(info.getUserId());
		follow.setBeFollowerId(userid);
//		follow.setFollowerName(info.getUsername());
//		follow.setFollowerImg(info.getHeadPicture());
		follow.setFollowTime(new Timestamp(System.currentTimeMillis()));
		Integer result = followService.insertFocus(follow);
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
	public void doGetRmFocus(HttpServletRequest request, HttpServletResponse response){
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		UserInfo info = (UserInfo)request.getSession().getAttribute("user");
		Follow follow = new Follow();
		follow.setFollowerId(info.getUserId());
		follow.setBeFollowerId(userid);
		Integer result = followService.deleteFollowByFollow(follow);
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
	
	
	
	public void doGetFans(HttpServletRequest request, HttpServletResponse response){
		UserInfo info = (UserInfo)request.getSession().getAttribute("user");
		int fansNum = followService.selectFansCountNum(info.getUserId());
		Map<String,Integer>fans = new HashMap<>();
		fans.put("fans", fansNum);
		ServletOutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
			mapper.writeValue(outputStream, fans);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeServletOutput(outputStream);
		}
		
	}
	
	
	
	
	
	
}
