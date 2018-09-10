package com.ecjtu.jy.pojo;

/**
 * 参加活动表实例
 * @author 建伟
 * @date 20180724
 * @version 1.0
 */
public class JoinActivity {

	private Integer joinActivityId; //参加活动Id
	private Integer joinerId;		// 参加人Id
	private Integer activityid;		//活动id
	private Integer stat;			//审核状态
	public JoinActivity(Integer joinActivityId, Integer joinerId, Integer activityid,Integer stat) {
		super();
		this.joinActivityId = joinActivityId;
		this.joinerId = joinerId;
		this.activityid = activityid;
		this.stat = stat;
	}
	public JoinActivity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getJoinActivityId() {
		return joinActivityId;
	}
	public void setJoinActivityId(Integer joinActivityId) {
		this.joinActivityId = joinActivityId;
	}
	public Integer getJoinerId() {
		return joinerId;
	}
	public void setJoinerId(Integer joinerId) {
		this.joinerId = joinerId;
	}
	public Integer getActivityid() {
		return activityid;
	}
	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}
	
	public Integer getStat() {
		return stat;
	}
	public void setStat(Integer stat) {
		this.stat = stat;
	}
	@Override
	public String toString() {
		return "JoinActivity [joinActivityId=" + joinActivityId + ", joinerId=" + joinerId + ", activityid="
				+ activityid + "]";
	}
	
	
	
	
}
