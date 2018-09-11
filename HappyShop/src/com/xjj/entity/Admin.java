package com.xjj.entity;

public class Admin {
	
	private Integer uid;//π‹¿Ì‘±±‡∫≈
	private String username;
	private String password;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [uid=" + uid + ", username=" + username + ", password=" + password + "]";
	}
	

}
