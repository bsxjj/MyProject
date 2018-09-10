package com.ecjtu.jy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.ecjtu.jy.dao.IInterstSortDao;
import com.ecjtu.jy.pojo.Interest;
import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.service.IInterstService;
import com.ecjtu.jy.service.IInterstSortService;
import com.ecjtu.jy.service.impl.InterstServiceImpl;
import com.ecjtu.jy.utils.JdbcUtils;

/**
 * Servlet implementation class InterestServlet
 */
@WebServlet("/interest")
public class InterestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IInterstService interService = new InterstServiceImpl();
    private ObjectMapper mapper = new ObjectMapper();
    
    public InterestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method) {
		case "allinter":
			doAllInter(request, response);
			break;

		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void doAllInter(HttpServletRequest request, HttpServletResponse response){
		UserInfo info = (UserInfo)request.getSession().getAttribute("user");
		List<Interest> selectIntersts = interService.selectIntersts(info.getUserId());
		ServletOutputStream outputStream = null;
		try {
			 outputStream = response.getOutputStream();
			mapper.writeValue(outputStream, selectIntersts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeServletOutput(outputStream);
		}
		
	}
	
	
	
	
	
	

}
