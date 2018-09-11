package com.xjj.controller.index;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjj.entity.Category;
import com.xjj.entity.Product;
import com.xjj.service.CategoryService;
import com.xjj.service.ProductService;

@Controller
public class IndexController {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	//默认处理
	@RequestMapping("/")
	public String testdefault() {
		return "forward:/list";
	}
	
	@RequestMapping("/list")
	public String show(HttpSession session) {
		// 查询所有一级分类集合
		List<Category> cList = categoryService.showAll();
		// 将一级分类存入到Session的范围:
		session.setAttribute("cList", cList);
		//查询热门商品
		List<Product> hList = productService.findHot();
		session.setAttribute("hList", hList);
		//查询最新商品
		List<Product> nList = productService.findNew();
		session.setAttribute("nList", nList);
		return "index";
	}

}
