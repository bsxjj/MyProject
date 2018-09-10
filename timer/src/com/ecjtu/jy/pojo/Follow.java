package com.ecjtu.jy.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 关注表实体类
 * @author 建伟
 * @date 20180724
 * @version 1.0
 */
public class Follow {

	private Integer id;				//关注表的id
	private Integer followerId;		//关注者Id
	private Integer beFollowerId;	//被关注者Id
	private Timestamp followTime;		//关注时间
	private String followerName;	//关注者名称
	private String followerImg;		//关注者头像
	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Follow(int id,Integer followerId, Integer beFollowerId, Timestamp followTime, String followerName, String followerImg) {
		super();
		this.id = id;
		this.followerId = followerId;
		this.beFollowerId = beFollowerId;
		this.followTime = followTime;
		this.followerName = followerName;
		this.followerImg = followerImg;
	}
	public Integer getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Integer followerId) {
		this.followerId = followerId;
	}
	public Integer getBeFollowerId() {
		return beFollowerId;
	}
	public void setBeFollowerId(Integer beFollowerId) {
		this.beFollowerId = beFollowerId;
	}
	public Timestamp getFollowTime() {
		return followTime;
	}
	public void setFollowTime(Timestamp followTime) {
		this.followTime = followTime;
	}
	public String getFollowerName() {
		return followerName;
	}
	public void setFollowerName(String followerName) {
		this.followerName = followerName;
	}
	public String getFollowerImg() {
		return followerImg;
	}
	public void setFollowerImg(String followerImg) {
		this.followerImg = followerImg;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Follow [followerId=" + followerId + ", beFollowerId=" + beFollowerId + ", followTime=" + followTime
				+ ", followerName=" + followerName + ", followerImg=" + followerImg + "]";
	}
	
	
}
