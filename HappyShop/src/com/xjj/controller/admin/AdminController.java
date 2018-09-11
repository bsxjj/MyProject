package com.xjj.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjj.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	
	@RequestMapping("/doLogin")
	public String doLogin(String username,String password,HttpSession session) {
		if (adminService.login(username, password) != null) {
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			return "forward:/admin/home.jsp";
		}else {
			session.setAttribute("error", "用户名或密码错误！");
			return "redirect:/admin/index.jsp";
		}
	}

}
