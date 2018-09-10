package com.ecjtu.jy.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 活动实体类
 * @author 建伟
 * @date 20180724
 * @version 2.0 增加活动已加入人的属性，采取get set方法形式进行设置
 */
public class Activity {
	private Integer activityId;		//活动Id
	private String activityName;	//活动名
	private String activityContent;	//活动内容 
	private Integer callId;			//召集人Id
	private String callName;		//召集人姓名
	private Integer needNum;		//需要人数
	private Timestamp beginTime;	//开始时间
	private Timestamp endTime;		//结束时间
	private Integer hasNum;			//已加入的人
	
	public Activity(Integer activityId, String activityName, String activityContent, Integer callId, String callName,
			Integer needNum, Timestamp beginTime, Timestamp endTime) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.activityContent = activityContent;
		this.callId = callId;
		this.callName = callName;
		this.needNum = needNum;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getHasNum() {
		return hasNum;
	}

	public void setHasNum(Integer hasNum) {
		this.hasNum = hasNum;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public Integer getCallId() {
		return callId;
	}

	public void setCallId(Integer callId) {
		this.callId = callId;
	}

	public String getCallName() {
		return callName;
	}

	public void setCallName(String callName) {
		this.callName = callName;
	}

	public Integer getNeedNum() {
		return needNum;
	}

	public void setNeedNum(Integer needNum) {
		this.needNum = needNum;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", activityName=" + activityName + ", activityContent="
				+ activityContent + ", callId=" + callId + ", callName=" + callName + ", needNum=" + needNum
				+ ", beginTime=" + beginTime + ", endTime=" + endTime + "]";
	}
	
	
	
	
}
