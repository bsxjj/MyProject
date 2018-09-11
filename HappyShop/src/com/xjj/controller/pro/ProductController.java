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
		System.out.println("��Ʒ������");
		Product product = productService.findByPid(pid);
		model.addAttribute("pro", product);
		System.out.println("��ѯ����Ʒ��"+product);
		return "product";
	}
	
	//���ݷ���id��ѯ��Ʒ
	@RequestMapping("/findByCid")
	public String findByCid(Integer cid,int page,Model model, HttpSession session) {
		System.out.println("������Ʒ�б�ҳ��");
		//����һ�������ѯ��Ʒ�������ѯ
		PageBean<Product> pageBean = productService.findByPageCid(cid, page);
		session.setAttribute("page", page);
		//��PageBean,cid ������������
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("cid", cid);
		return "productList";
	}
	
	//���ݶ�������id��ѯ��Ʒ
	@RequestMapping("/findByCsid")
	public String findByCsid(Integer csid,Integer page,HttpSession session) {		
		page = (int) session.getAttribute("page");		
		PageBean<Product> pageBean = productService.findByPageCsid(csid, page);
		session.setAttribute("pageBean", pageBean);
		session.setAttribute("csid", csid);
		return "productList";
	}

}
