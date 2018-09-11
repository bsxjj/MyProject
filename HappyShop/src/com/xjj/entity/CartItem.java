package com.xjj.entity;

public class CartItem {
	
	private Product product;//商品信息
	private int count;//商品数量
	private double subtotal;//单个商品的总费用
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public double getSubtotal() {
		return count*product.getShop_price();
	}
	

}
