package com.xjj.entity;

public class CartItem {
	
	private Product product;//��Ʒ��Ϣ
	private int count;//��Ʒ����
	private double subtotal;//������Ʒ���ܷ���
	
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
