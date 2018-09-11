package com.xjj.controller.order;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjj.entity.Cart;
import com.xjj.entity.CartItem;
import com.xjj.entity.Order;
import com.xjj.entity.OrderItem;
import com.xjj.entity.User;
import com.xjj.service.OrderItemService;
import com.xjj.service.OrderService;
import com.xjj.util.PageBean;
import com.xjj.util.PaymentUtil;

@Controller
public class OrderController {
	
	private Order order = new Order();
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderItemService orderItemSevice;
	
	@RequestMapping("/saveOrder")
	public String saveOrder(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			System.out.println("返回购物车页面");
			return "cart";
		}
		// 设置订单关联的客户:
		User existUser = (User) session.getAttribute("user");
		if (existUser == null) {
			System.out.println("返回登录页面");
			return "login";
		}
		//设置付款总费用
		order.setTotal(cart.getTotal());
		//订单状态
		order.setState(1);//0:已付款，1：未付款
		//订单时间
		order.setOrdertime(new Date());
		//显示用户信息
		order.setUser(existUser);
		order.setUid(existUser.getUid());
		//生成订单
		orderService.saveOrder(order);
		//订单项集合
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setPid(cartItem.getProduct().getPid());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOid(order.getOid());
			//生成订单项数据
			orderItemSevice.saveOrderItem(orderItem);
			order.getOrderItems().add(orderItem);
		}
		// 将order对象保存到session当中，为了能够在订单页面回显订单信息
		session.setAttribute("order", order);
		//清空购物车
		cart.clearCart();
		return "order";
	}
	//根据用户id查询订单
	@RequestMapping("/findByUid")
	public String findByUid(Integer uid,Integer page,HttpSession session) {
		PageBean<Order> pageBean = orderService.findPageByUid(uid, page);
		session.setAttribute("pageBean", pageBean);
		return "orderList";
	}
	//根据订单id查询订单
	@RequestMapping("/findByOid")
	public String findByOid(Integer oid,HttpSession session) {
		User user = (User) session.getAttribute("user");
		order = orderService.findByOid(oid);
		//设置用户名，用户能够查询我的订单之后还能查询用户信息
		order.setUser(user);
		session.setAttribute("order", order);
		System.out.println("根据id查询到的订单："+order);
		return "order";
	}
	//修改订单的状态
	public void updateState() {
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setState(4);
		orderService.update(currOrder);
	}
	// 为订单付款: 接收支付通道编码 pd_FrpId CCB-WAP
	@RequestMapping("/payOrder")
	public void payOrder(String pd_FrpId,HttpServletResponse response) throws IOException {
		//修改数据
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setAddr(order.getUser().getAddr());
		currOrder.setName(order.getUser().getName());
		currOrder.setPhone(order.getUser().getPhone());
		//修改订单
		orderService.update(currOrder);
		//完成付款
		String p0_Cmd = "Buy"; // 业务类型
		String p1_MerId = "10001126856";// 商户编号:
		String p2_Order = order.getOid().toString();// 订单编号:
		String p3_Amt = "0.01"; // 付款金额:
		String p4_Cur = "CNY"; // 交易币种:
		String p5_Pid = ""; // 商品名称:
		String p6_Pcat = ""; // 商品种类:
		String p7_Pdesc = ""; // 商品描述:
		String p8_Url = "http://localhost:8080/HappyShop/callBack"; // 商户接收支付成功数据的地址:
		String p9_SAF = ""; // 送货地址:
		String pa_MP = ""; // 商户扩展信息:
		String pr_NeedResponse = "1"; // 应答机制:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); // hmac
		//向易付宝发送请求
		StringBuffer sb = new StringBuffer("https:/www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		//重定向到易付宝
		response.sendRedirect(sb.toString());
	}
	
	//付款成功跳转的路径
	@RequestMapping("callBack")
	public String callBack(String r3_Amt,String r6_Order,Model model) {
		Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
		currOrder.setState(2);
		orderService.update(currOrder);
		model.addAttribute("info", "支付成功！订单编号："+r6_Order+"付款金额："+currOrder.getTotal());
		return "msg";
	}
}
