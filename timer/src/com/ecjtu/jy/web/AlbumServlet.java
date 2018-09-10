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

import com.ecjtu.jy.pojo.Album;
import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.service.IAlbumService;
import com.ecjtu.jy.service.impl.AlbumServiceImpl;

@WebServlet("/album")
public class AlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlbumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method) {
		case "addalbum":
			doAddAlbum(request,response);
			break;
		case "upimgs":
			doUpImgs(request,response);
			break;
		
		default:
			break;
		}
	
	
	}

	public void doUpImgs(HttpServletRequest request, HttpServletResponse response){
		
		
		
	}
	public void doAddAlbum(HttpServletRequest request, HttpServletResponse response){
		String albumname = request.getParameter("albumname");
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo) session.getAttribute("user");
		IAlbumService iaservice = new AlbumServiceImpl();
		Album album = new Album();
		album.setAlbumName(albumname);
		album.setAlbumCreatTime(new Timestamp(System.currentTimeMillis()));
		album.setAlbumCreatorId(info.getUserId());
		int result = iaservice.insertAlbum(album);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (result > 0){
				out.print("创建成功");
			}else{
				out.print("创建失败");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
