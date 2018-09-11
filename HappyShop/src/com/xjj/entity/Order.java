package com.xjj.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	
	private Integer oid;
	private Double total;
	private Date ordertime;
	private Integer state;// 1:未付款   2:订单已经付款   3:已经发货   4:订单结束
	private String name;
	private String phone;
	private String addr;
	// 用户的外键:对象
	private User user;
	private Integer uid;
	// 配置订单项的集合
	private List<OrderItem> orderItems=new ArrayList<>();
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", total=" + total + ", ordertime=" + ordertime + ", state=" + state + ", name="
				+ name + ", phone=" + phone + ", addr=" + addr + ", user=" + user + ", uid=" + uid + ", orderItems="
				+ orderItems + "]";
	}
	

}
