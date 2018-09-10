package com.ecjtu.jy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecjtu.jy.pojo.UserInfo;



/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

   
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requ = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = requ.getSession();
		String path = requ.getRequestURI();
		//System.out.println(path);
		UserInfo user = (UserInfo) session.getAttribute("user");
		if (path.contains("register.jsp") || path.contains("login.jsp") || path.contains("/images/") 
				|| path.contains("/css/") || path.contains("/js/") || path.contains("/dist/") || 
				path.contains("/assets/") || path.contains("/bootstrap/") || request.getParameter("method") != null){
			chain.doFilter(request, response);
			return;
		}
		if (user == null || "".equals(user)){
			String urlPath = requ.getContextPath() + "/view/login.jsp";
			
			//requ.getRequestDispatcher("/view/login.jsp").forward(requ, resp);
			String urlstr = request.getServletContext().getContextPath();
			System.out.println(urlstr);
			resp.sendRedirect(urlstr + "/view/login.jsp");
			
		}else{
			
			chain.doFilter(request, response);
			
		}
	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
