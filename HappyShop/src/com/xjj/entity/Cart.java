package com.xjj.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart implements Serializable {

	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();//购物项集合
	private double total;//购物总费用
	
	public Collection<CartItem> getCartItems() {
		return map.values();
	}
	public double getTotal() {
		return total;
	}
	//添加购物项
	public void addCart(CartItem cartItem) {
		//通过商品id判断购物车是否存在该购物项，用if判断
		Integer pid = cartItem.getProduct().getPid();
		if (map.containsKey(pid)) {
			cartItem = map.get(pid);
			cartItem .setCount(cartItem.getCount()+1);
		}else {
			map.put(pid, cartItem);
		}
		//计算总费用
		total += cartItem.getSubtotal();
	}
	//删除购物项
	public void deleteCart(Integer pid) {
		CartItem cartItem = map.remove(pid);
		total -=cartItem.getSubtotal(); 
	}
	//清空购物车
	public void clearCart() {
		map.clear();
		total = 0;
	}

}
