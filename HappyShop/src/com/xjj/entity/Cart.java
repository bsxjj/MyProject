package com.xjj.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart implements Serializable {

	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();//�������
	private double total;//�����ܷ���
	
	public Collection<CartItem> getCartItems() {
		return map.values();
	}
	public double getTotal() {
		return total;
	}
	//��ӹ�����
	public void addCart(CartItem cartItem) {
		//ͨ����Ʒid�жϹ��ﳵ�Ƿ���ڸù������if�ж�
		Integer pid = cartItem.getProduct().getPid();
		if (map.containsKey(pid)) {
			cartItem = map.get(pid);
			cartItem .setCount(cartItem.getCount()+1);
		}else {
			map.put(pid, cartItem);
		}
		//�����ܷ���
		total += cartItem.getSubtotal();
	}
	//ɾ��������
	public void deleteCart(Integer pid) {
		CartItem cartItem = map.remove(pid);
		total -=cartItem.getSubtotal(); 
	}
	//��չ��ﳵ
	public void clearCart() {
		map.clear();
		total = 0;
	}

}
