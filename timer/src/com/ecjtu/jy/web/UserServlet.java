package com.ecjtu.jy.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.service.IAlbumService;
import com.ecjtu.jy.service.IFollowService;
import com.ecjtu.jy.service.IInterstService;
import com.ecjtu.jy.service.IUserInfoService;
import com.ecjtu.jy.service.impl.AlbumServiceImpl;
import com.ecjtu.jy.service.impl.FollowServiceImpl;
import com.ecjtu.jy.service.impl.InterstServiceImpl;
import com.ecjtu.jy.service.impl.UserInfoServiceImpl;
import com.ecjtu.jy.utils.FileUtil;
import com.ecjtu.jy.utils.MySendMail;
import com.ecjtu.jy.utils.MyUtil;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserInfoService userService = new UserInfoServiceImpl();
    private UserInfo userInfo = null;
    public UserServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println("请求的方法为:" + method);
		if (method != null){
			switchMethod(method,request,response);
		}else{
			request.getRequestDispatcher("view/index.jsp").forward(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void switchMethod(String method,HttpServletRequest request, HttpServletResponse response){
		switch (method) {
		case "register":
			doRegister(request,response);
			break;
		case "login":
			doLogin(request,response);
			break;
		case "info":
			doInfo(request,response);
			break;
		case "myinfo":
			doMyInfo(request,response);
			break;
				
		case "valiuser":
			doValidateUserName(request, response);
			break;
		case "valiemail":
			doValidateEmail(request,response);
			break;
		case "sendmail":
			doSendEmail(request, response);
			break;
		case "uploadimg":
			doUploadImg(request, response);
			break;
				
		default:
			break;
		}
		
	}
	private void doMyInfo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo) session.getAttribute("user");
		UserInfo user = userService.selectUserById(info.getUserId());
		try {
			request.setAttribute("myuser", user);
			request.getRequestDispatcher("/view/home.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void doUploadImg(HttpServletRequest request, HttpServletResponse response){
		String imgdata = request.getParameter("imgdata");
		String[]strs = imgdata.split(",");
		String imgName = "";
		if ("jpeg".equals(FileUtil.imgNameWithEnd(strs[0]).toLowerCase())){
			imgName = MyUtil.getImgName() + ".jpg";
			
		}
		
		String path = "G:\\images" + File.separator + imgName;
		PrintWriter out = null;
		try {
			System.out.println(strs[1]);
			MyUtil.saveImage(strs[1],path);
			UserInfo u = (UserInfo)request.getSession().getAttribute("user");
			String imgurl = "http://localhost:8080/images/" + imgName;
			int count = userService.updateUserImg(imgurl, u.getUserId());
			out = response.getWriter();
			if (count > 0){
				u.setHeadPicture(imgurl);
				out.print("上传成功");
			}else{
				
				out.print("上传失败");
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (out != null){
				out.close();
			}
		}
		System.out.println("------------------imgdata " +imgdata);
	
	}
	
	/**
	 * 处理注册请求
	 */
	public void doRegister(HttpServletRequest request, HttpServletResponse response){
		System.out.println("正在进行注册请求");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setPassword(MyUtil.MD5(password));
		userInfo.setEmail(email);
		userInfo.setUserCreateTime(new Timestamp(System.currentTimeMillis()));
		userInfo.setSex("男");
		int id = userService.insertUser(userInfo);
		if (id > 0){
			userInfo = userService.selectUserById(id);
			HttpSession session = request.getSession();
			session.setAttribute("user",userInfo);
			try {
				response.sendRedirect("view/index.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			PrintWriter out = null;
			try {
				out = response.getWriter();
				out.print("注册失败请重试");
				response.setHeader("refresh","3;view/register.jsp");
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
	
	/**
	 * 处理登录请求
	 */
	public void doLogin(HttpServletRequest request, HttpServletResponse response){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserInfo info = userService.selectUserByPassAndUserName(username, MyUtil.MD5(password));
			HttpSession session = request.getSession();
			
			if (info != null){
				IInterstService iiservice =new InterstServiceImpl();
				IAlbumService ialservice = new AlbumServiceImpl();
				try {
					info.setImgs(ialservice.selectImgsByNew(info.getUserId()));
					info.setIntersts(iiservice.selectIntersts(info.getUserId()));
					session.setAttribute("user",info);
					request.getRequestDispatcher("view/index.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				PrintWriter out = null;
				try {
					out = response.getWriter();
					out.print("用户名或密码错误");
					response.setHeader("refresh","3;view/login.jsp");
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
	
	/**
	 * 处理用户信息请求
	 * 查看其他用户信息需求
	 * 跳转到其他用户的页面
	 */
	public void doInfo(HttpServletRequest request, HttpServletResponse response){
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		IFollowService ifservice = new FollowServiceImpl();
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo) session.getAttribute("user");
		UserInfo user = userService.selectUserById(userid);
		user.setFocus(ifservice.isFocus(userid, info.getUserId()));
		try {
			request.setAttribute("tauser", user);
			request.getRequestDispatcher("/view/userinfo.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void doValidateUserName(HttpServletRequest request, HttpServletResponse response){
		
		String username = request.getParameter("username");
		int count = userService.validateUserName(username);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			
			if (count > 0){
				out.print("用户名已存在");
				
			}else{
				out.print("");
				
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
	
	/**
	 * 验证用户邮箱是否已存在
	 * @param request
	 * @param response
	 */
	public void doValidateEmail(HttpServletRequest request, HttpServletResponse response){
		String email = request.getParameter("email");
		int count = userService.validateEmail(email);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (count > 0){
				out.print("邮箱已注册");
				
			}else{
				out.print("");
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
	
	/**
	 * 发送邮件
	 */
	public void doSendEmail(HttpServletRequest request, HttpServletResponse response){
		String email = request.getParameter("email");
		String code =  MyUtil.myRandom();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (MySendMail.sendMail(email,code)){
				out.print(code);
				
			}else{
				out.print("");
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
