package com.xjj.controller.cart;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjj.entity.Cart;
import com.xjj.entity.CartItem;
import com.xjj.entity.Product;
import com.xjj.service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	ProductService productService;
	
	/**
	 * ��ù��ﳵ�ķ�������session�л�ȡ
	 * @return
	 */
	public Cart getCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		return cart;
	}
	
	@RequestMapping("/myCart")
	public String myCart() {
		return "cart";
	}
	//��ӹ�����
	@RequestMapping("/addCart")
	public String addCart(Integer pid,Integer count,HttpSession session) {
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		Product product = productService.findByPid(pid);
		cartItem.setProduct(product);
		//��ȡ���ﳵ����
		Cart cart = getCart(session);
		cart.addCart(cartItem);
		return "cart";
	}
	//ɾ��������
	@RequestMapping("/deleteCart")
	public String deleteCart(Integer pid,HttpSession session) {
		Cart cart = getCart(session);
		cart.deleteCart(pid);
		return "cart";
	}
	//��չ��ﳵ
	@RequestMapping("/clearCart")
	public String clearCart(HttpSession session) {
		Cart cart = getCart(session);
		cart.clearCart();
		return "cart";
	}

}
