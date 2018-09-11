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
	
	//Ĭ�ϴ���
	@RequestMapping("/")
	public String testdefault() {
		return "forward:/list";
	}
	
	@RequestMapping("/list")
	public String show(HttpSession session) {
		// ��ѯ����һ�����༯��
		List<Category> cList = categoryService.showAll();
		// ��һ��������뵽Session�ķ�Χ:
		session.setAttribute("cList", cList);
		//��ѯ������Ʒ
		List<Product> hList = productService.findHot();
		session.setAttribute("hList", hList);
		//��ѯ������Ʒ
		List<Product> nList = productService.findNew();
		session.setAttribute("nList", nList);
		return "index";
	}

}
