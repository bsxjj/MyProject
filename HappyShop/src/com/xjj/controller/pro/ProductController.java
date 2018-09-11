package com.xjj.controller.pro;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjj.entity.Product;
import com.xjj.service.ProductService;
import com.xjj.util.PageBean;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/findByPid")
	public String findByPid(Integer pid,Model model) {
		System.out.println("商品控制器");
		Product product = productService.findByPid(pid);
		model.addAttribute("pro", product);
		System.out.println("查询的商品："+product);
		return "product";
	}
	
	//根据分类id查询商品
	@RequestMapping("/findByCid")
	public String findByCid(Integer cid,int page,Model model, HttpSession session) {
		System.out.println("进入商品列表页面");
		//根据一级分类查询商品，分类查询
		PageBean<Product> pageBean = productService.findByPageCid(cid, page);
		session.setAttribute("page", page);
		//把PageBean,cid 保存在请求域
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("cid", cid);
		return "productList";
	}
	
	//根据二级分类id查询商品
	@RequestMapping("/findByCsid")
	public String findByCsid(Integer csid,Integer page,HttpSession session) {		
		page = (int) session.getAttribute("page");		
		PageBean<Product> pageBean = productService.findByPageCsid(csid, page);
		session.setAttribute("pageBean", pageBean);
		session.setAttribute("csid", csid);
		return "productList";
	}

}
