package com.xjj.entity;

import java.util.List;

public class CategorySecond {
	
	private Integer csid;
	private String csname;
	private String cid;
	//����һ�����࣬�����һ������Ķ���
	private Category category;
	//��Ʒ����
	private List<Product> products;
	
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "CategorySecond [csid=" + csid + ", csname=" + csname + ", cid=" + cid + ", category=" + category
				+ ", products=" + products + "]";
	}
	
	
	

}
