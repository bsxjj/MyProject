package com.ecjtu.jy.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.ecjtu.jy.pojo.ImgTxtInfo;
import com.ecjtu.jy.pojo.Laud;
import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.service.IImgTxtInfoService;
import com.ecjtu.jy.service.ILaudService;
import com.ecjtu.jy.service.impl.ImgTxtInfoServiceImpl;
import com.ecjtu.jy.service.impl.LaudServiceImpl;
import com.ecjtu.jy.utils.FileUtil;
import com.ecjtu.jy.utils.JdbcUtils;
import com.ecjtu.jy.utils.MyUtil;

@WebServlet("/imgtxt")
public class ImgTxtInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IImgTxtInfoService imgTxtService = null;
    ObjectMapper mapper = new ObjectMapper();
    ILaudService lservice = null;
    
    @Override
	public void init() throws ServletException {
    	imgTxtService = new ImgTxtInfoServiceImpl();
    	lservice = new LaudServiceImpl();
		super.init();
	}
	public ImgTxtInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method) {
		case "getcount":
			doGetImgTxtInfoNum(request,response);
			break;
		case "gettacount":
			doGetTaImgTxtNum(request,response);
			break;
		case "saveimgtxt":
			doImgTxtSave(request,response);
			break;
		case "getalltxt":
			doGetImgTxtByPage(request,response);
			break;
		case "addlaud":
			doAddLaud(request,response);
			break;
		case "gettaimgtxt":
			doGetTaImgtxt(request,response);
			break;
				
		default:
			break;
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void doGetTaImgTxtNum(HttpServletRequest request, HttpServletResponse response){
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		int sum = imgTxtService.selectImgTxtSum(userid);
		Map<String,Integer>nums = new HashMap<>();
		nums.put("nums", sum);
		ServletOutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
			mapper.writeValue(outputStream, nums);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeServletOutput(outputStream);
		}
		
	}
	
	public void doGetImgTxtInfoNum(HttpServletRequest request, HttpServletResponse response){
		UserInfo info = (UserInfo) request.getSession().getAttribute("user");
		int num = imgTxtService.selectAllImgTxtNum();
		Map<String,Integer>nums = new HashMap<>();
		nums.put("nums", num);
		ServletOutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
			mapper.writeValue(outputStream, nums);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeServletOutput(outputStream);
		}
		
		
	}
	
	public void doGetTaImgtxt(HttpServletRequest request, HttpServletResponse response){
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int userid = Integer.parseInt(request.getParameter("userid"));
		System.out.println(userid + "-----------");
		List<ImgTxtInfo> imgtxts = imgTxtService.selectImgTxtByPageNum(pageNum,userid);
		ObjectMapper ompp = new ObjectMapper();
		ServletOutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
			ompp.writeValue(outputStream, imgtxts);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeServletOutput(outputStream);
		}
		
	}
	
	
	public void doImgTxtSave(HttpServletRequest request, HttpServletResponse response){
		String imgdata = request.getParameter("imgdata");
		String imgtxt  = request.getParameter("imgtxt");
		ImgTxtInfo info = new ImgTxtInfo();
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
			info.setImgUrl("http://localhost:8080/images/" + imgName);
			info.setText(imgtxt);
			UserInfo u = (UserInfo)request.getSession().getAttribute("user");
			info.setSendId(u.getUserId());
			info.setImgTxtSendTime(new Timestamp(System.currentTimeMillis()));
			info.setImgTxtPowerStatus(0);
			int count = imgTxtService.insertImgTxtInfo(info);
			out = response.getWriter();
			if (count > 0){
				out.print("发表成功");
			
			}else{
				
				out.print("发表失败");
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (out != null){
				out.close();
			}
		}
		/*System.out.println(strs[0]);
		*/
		//info.setImgUrl(imgUrl);
		
		
		
	}
	
	public void doGetImgTxtByPage(HttpServletRequest request, HttpServletResponse response){
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo) session.getAttribute("user");
		if (info != null){
			List<ImgTxtInfo> imgTxts = imgTxtService.selectImgTxtByPageNum(pageNum,info.getUserId(),0);
			ServletOutputStream outputStream = null;
			try {
				outputStream = response.getOutputStream();
				mapper.writeValue(outputStream, imgTxts);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JdbcUtils.closeServletOutput(outputStream);
			}
			
		}
		
		
		
		
	}
	
	public void doAddLaud(HttpServletRequest request, HttpServletResponse response){
		String str_imgtxtid = request.getParameter("imgtxtid");
		int imgtxtid = Integer.parseInt(str_imgtxtid);
		Laud laud = new Laud();
		HttpSession session = request.getSession();
		UserInfo info = (UserInfo) session.getAttribute("user");
		laud.setLaudImgTxtId(imgtxtid);
		laud.setBeLaudId(info.getUserId());
		//System.out.println(info.getUserId());
		laud.setBeLaudName(info.getUsername());
		System.out.println(laud);
		PrintWriter out = null;
		try {
			int result = lservice.insertLaud(laud);
			if (result > 0){
				System.out.println("点赞成功");
			}else{
				System.out.println("点赞失败");
			}
			Integer laundcount = lservice.selectLaudCount(imgtxtid);
			out = response.getWriter();
			out.print(laundcount);
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
