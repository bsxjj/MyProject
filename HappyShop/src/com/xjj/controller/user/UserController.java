package com.xjj.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjj.entity.User;
import com.xjj.service.UserService;
import com.xjj.util.RandomValidateCode;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	//注册
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	//将页面数据保存到数据库中
	@RequestMapping("/doregister")
	public String doregister(User user) {
		userService.register(user);
		return "login";		
	}
	
	//验证用户名是否存在
	@RequestMapping("/checkUserName")
	@ResponseBody
	public void checkUsername(String username,HttpServletResponse response) throws IOException {
		//return userService.findByUserName(username) == true ? "error":"ok";
		if (userService.findByUserName(username)) {
			response.getWriter().println("ok");
		}else {
			response.getWriter().println("error");
		}
	}
	
	//获取随机生成的验证码
	@RequestMapping(value="/checkCode")
	public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		//设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	
	//登录
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	//登录验证
	@RequestMapping("/dologin")
	public String dologin(String username, String password,HttpSession session) {
		User user = userService.login(username, password);
		if(user != null) {
			//登录成功显示用户名
			session.setAttribute("user", user);
			return "forward:/list";
		}else {
			session.setAttribute("orror", "用户名或密码错误！");
			return "forward:/login";
		}		
	}
	
	//登录
	@RequestMapping("/exit")
    public String exit(HttpSession session) {
		session.invalidate();
		return "forward:/list";
	}

}
