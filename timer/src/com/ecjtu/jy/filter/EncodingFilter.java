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

@WebFilter("/EncodFilter")
public class EncodingFilter implements Filter {

   
   
    public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println("À¹½Ø½øÐÐ±àÂë×ª»»");
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		String path = servletRequest.getRequestURI();
		if (!path.contains("updateimg.jsp")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
