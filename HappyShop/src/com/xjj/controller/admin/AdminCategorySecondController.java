package com.xjj.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjj.entity.Category;
import com.xjj.entity.CategorySecond;
import com.xjj.service.CategorySecondService;
import com.xjj.service.CategoryService;
import com.xjj.util.PageBean;

@Controller
public class AdminCategorySecondController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategorySecondService categorySecondService;
	
	@RequestMapping("/CategorySecond_findAll")
	public String CategorySecond_findAll(Integer page,HttpSession session) {
		PageBean<CategorySecond> pageBean = categorySecondService.findByPage(page);
		session.setAttribute("pageBean", pageBean);
		return "forward:/admin/categorysecond/list.jsp";
	}
	
	@RequestMapping("/CategorySecond_addPage")
	public String CategorySecond_addPage(HttpSession session) {
		List<Category> cList = categoryService.showAll();
		session.setAttribute("cList", cList);
		System.out.println(cList);
		return "forward:/categorysecond/add.jsp";
	}
	
	
	@RequestMapping("/CategorySecond_save") 
	public String CategorySecond_save(CategorySecond categorySecond) {
		if (categorySecondService.insert(categorySecond) > 0) {
			return "forward:/CategorySecond_findAll?page=1";
		}else {
			return "";
		}
	}
	@RequestMapping("/CategorySecond_delete")
	public String CategorySecond_delete(Integer csid) {
		if (categorySecondService.delete(csid) > 0) {
			return "forward:/CategorySecond_findAll?page=1";
		}else {
			return "";
		}
	}
	@RequestMapping("/CategorySecond_update")
	public String CategorySecond_update(CategorySecond categorySecond) {
		if (categorySecondService.update(categorySecond) > 0) {
			return "forward:/CategorySecond_findAll?page=1";
		}else {
			return "";
		}
	}
	@RequestMapping("/CategorySecond_edit")
	public String CategorySecond_edit(Integer csid,Model model) {
		CategorySecond categorySecond = categorySecondService.findById(csid);
		model.addAttribute("categorySecond", categorySecond);
		return "forward:/admin/categorysecond/edit.jsp";
	}

}
