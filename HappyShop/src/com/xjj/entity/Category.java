package com.xjj.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
	
	private Integer cid;
	private String cname;
	//һ�������д�Ŷ�������ļ���
	private List<CategorySecond> categorySeconds;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(List<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", categorySeconds=" + categorySeconds + "]";
	}
	

}
