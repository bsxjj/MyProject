package com.xjj.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.xjj.entity.Product;
import com.xjj.service.ProductService;
import com.xjj.util.PageBean;

@Controller
public class AdminProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/Product_save")
	public String Product_save(Product product,HttpServletRequest request,
			MultipartFile picFile) throws IllegalStateException,IOException {
		if (picFile != null) {
			String originalFilename = picFile.getOriginalFilename();
			System.out.println("得到图片的原始名称："+originalFilename);
			//设置存放图片的路径
			String path = "D:/javacode/HappyShop/WebContent/products/1/";
			File file = new File(path+originalFilename);
			//将内存中的数据写入磁盘
			picFile.transferTo(file);
			//将新图片存入数据库，使用绝对路径
			String image = request.getContextPath()+"/products/1/"+originalFilename;
			System.out.println("保存的图片的路径："+image);
			product.setImage(image);
		}
		//设置图片上传时间
		product.setPdate(new Date());
		productService.insertProduct(product);
		return "forward:/Product_findAll?page=1";
	}
	@RequestMapping("/Product_delete")
	public String Product_delete(Integer pid) {
		if (productService.deleteProduct(pid) > 0) {
			return "forward:/Product_findAll?page=1";
		}else {
			return "";
		}
	}
	@RequestMapping("/Product_update")
	public String Product_update(Product product) {
		if (productService.updateProduct(product) > 0) {
			return "forward:/Product_findAll?page=1";
		}else {
			return "";
		}
	}
	@RequestMapping("/Product_edit")
	public String Product_edit(Integer pid,Model model) {
		Product product = productService.findByPid(pid);
		model.addAttribute("pro", product);
		return "forward:/admin/product/edit.jsp";	
	}
	@RequestMapping("/Product_findAll")
	public String Product_findAll(Integer page,HttpSession session) {
		PageBean<Product> pageBean = productService.findByPage(page);
		session.setAttribute("pageBean", pageBean);
		return "forward:/admin/product/list.jsp";
	}
	@RequestMapping("/Product_addPage")
	public String Product_addPage(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		return "forward:/admin/product/add.jsp";
	}

}
