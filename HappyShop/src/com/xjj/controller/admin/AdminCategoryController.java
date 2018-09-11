package com.xjj.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjj.entity.Category;
import com.xjj.service.CategoryService;

@Controller
public class AdminCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/Category_findAll")
	public String Category_findAll(HttpSession session) {
		List<Category> categories = categoryService.findAllWithAdmin();
		session.setAttribute("categories", categories);
		return "redirect:/admin/category/list.jsp";
	}
	@RequestMapping("/Category_save")
	public String Category_save(String cname) {
		if (categoryService.saveCategory(cname) > 0) {
			return "forward:/Category_findAll";
		}else {
			return "redirect:/admin/category/add.jsp";
		}
	}
	@RequestMapping("/Category_delete")
	public String Category_delete(Integer cid) {
		if (categoryService.deleteCategory(cid) > 0) {
			return "forward:/Category_findAll";
		}else {
			return "forward:/admin/category/list.jsp";
		}
	}
	@RequestMapping("/Category_update")
	public String Category_update(Category category) {
		System.out.println(category);
		if (categoryService.updateCategory(category) > 0) {
			return "forward:/Category_findAll";
		}else {
			return "forward:/admin/category/list.jsp";
		}
	}
	@RequestMapping("/Category_edit")
	public String Category_edit(Integer cid,Model model) {
		Category category = categoryService.findById(cid);
		model.addAttribute("category", category);
		return "forward:/admin/category/edit.jsp";
	}

}
