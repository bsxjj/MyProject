package com.ecjtu.jy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecjtu.jy.pojo.Collection;
import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.service.ICollectionService;
import com.ecjtu.jy.service.impl.CollectionServiceImpl;
import com.sun.java.swing.plaf.windows.WindowsTreeUI.CollapsedIcon;


@WebServlet("/collection")
public class CollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ICollectionService collservice = null;
  
    public CollectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@Override
	public void init() throws ServletException {
		collservice = new CollectionServiceImpl();
		super.init();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method != null){
			switch (method) {
			case "addcollection":
				doAddCollection(request,response);
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
	public void doAddCollection(HttpServletRequest request, HttpServletResponse response){
		int imgtxtid = Integer.parseInt(request.getParameter("imgtxtid"));
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo) session.getAttribute("user");
		if (info != null){
			Collection collection = new Collection();
			collection.setCollectionImgTxtId(imgtxtid);
			collection.setCollectorId(info.getUserId());
			collection.setCollectionCreatTime(new Timestamp(System.currentTimeMillis()));
			
			int result = collservice.insertCollection(collection);
			int count = collservice.selectImgtxtBeCollect(imgtxtid);
			PrintWriter out = null;
			try {
				
				out = response.getWriter();
				if (result > 0){
					out.print(count);
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
	
	
}
