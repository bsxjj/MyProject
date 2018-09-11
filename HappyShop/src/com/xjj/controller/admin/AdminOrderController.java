package com.xjj.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjj.entity.Order;
import com.xjj.entity.OrderItem;
import com.xjj.service.OrderService;
import com.xjj.util.PageBean;

@Controller
public class AdminOrderController {
	
	@Autowired
	private OrderService orderService;
	
	//分页查询所有订单
	@RequestMapping("/Order_findAll")
	public String Order_findAll(Integer page,HttpSession session) {
		PageBean<Order> pageBean = orderService.findByPage(page);
		session.setAttribute("pageBean", pageBean);
		return "forward:/admin/order/list.jsp";
	}
	//根据id查询订单项
	@RequestMapping("/Order_findOrderItem")
	public String Order_findOrderItem(Integer oid,HttpSession session) {
		List<OrderItem> list = orderService.findOrderItemByOid(oid);
		session.setAttribute("list", list);
		return "forward:/admin/order/orderItem.jsp";
	}
	//修改订单状态
	@RequestMapping("/Order_updateState")
	public String Order_updateState(Integer oid) {
		Order order = orderService.findByOid(oid);
		order.setState(3);
		orderService.update(order);
		return "redirect:/Order_findAll?page=1";
	}
}
