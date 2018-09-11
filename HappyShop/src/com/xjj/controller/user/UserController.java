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
	
	//ע��
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	//��ҳ�����ݱ��浽���ݿ���
	@RequestMapping("/doregister")
	public String doregister(User user) {
		userService.register(user);
		return "login";		
	}
	
	//��֤�û����Ƿ����
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
	
	//��ȡ������ɵ���֤��
	@RequestMapping(value="/checkCode")
	public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		//������Ӧ����,������������������ΪͼƬ
        response.setContentType("image/jpeg");
        
        //������Ӧͷ��Ϣ�������������Ҫ���������
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//���ͼƬ����
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	
	//��¼
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	//��¼��֤
	@RequestMapping("/dologin")
	public String dologin(String username, String password,HttpSession session) {
		User user = userService.login(username, password);
		if(user != null) {
			//��¼�ɹ���ʾ�û���
			session.setAttribute("user", user);
			return "forward:/list";
		}else {
			session.setAttribute("orror", "�û������������");
			return "forward:/login";
		}		
	}
	
	//��¼
	@RequestMapping("/exit")
    public String exit(HttpSession session) {
		session.invalidate();
		return "forward:/list";
	}

}
