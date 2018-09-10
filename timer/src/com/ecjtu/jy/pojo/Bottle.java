package com.ecjtu.jy.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * ʱ��ƿ
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public class Bottle {
	private Integer Id;//id 
	//ƿ����
	private String bottlename;
	//ʱ��ƿ����
	private String bottlecontent;
	//ƿ����id
	private Integer bottleuserid;
	//ƿ��������
	private String bottleusername;
	//Ư��ʱ��
	private Timestamp drifttime;
	//״̬
	private Integer state;
	//��ȡ��id
	private Integer gainuserid;
	//��ȡ������
	private String gainuser;
	public Bottle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bottle(Integer id, String bottlename, String bottlecontent, Integer bottleuserid, String bottleusername,
			Timestamp drifttime, Integer state, Integer gainuserid, String gainuser) {
		super();
		Id = id;
		this.bottlename = bottlename;
		this.bottlecontent = bottlecontent;
		this.bottleuserid = bottleuserid;
		this.bottleusername = bottleusername;
		this.drifttime = drifttime;
		this.state = state;
		this.gainuserid = gainuserid;
		this.gainuser = gainuser;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getBottlename() {
		return bottlename;
	}
	public void setBottlename(String bottlename) {
		this.bottlename = bottlename;
	}
	public String getBottlecontent() {
		return bottlecontent;
	}
	public void setBottlecontent(String bottlecontent) {
		this.bottlecontent = bottlecontent;
	}
	public Integer getBottleuserid() {
		return bottleuserid;
	}
	public void setBottleuserid(Integer bottleuserid) {
		this.bottleuserid = bottleuserid;
	}
	public String getBottleusername() {
		return bottleusername;
	}
	public void setBottleusername(String bottleusername) {
		this.bottleusername = bottleusername;
	}
	public Timestamp getDrifttime() {
		return drifttime;
	}
	public void setDrifttime(Timestamp drifttime) {
		this.drifttime = drifttime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getGainuserid() {
		return gainuserid;
	}
	public void setGainuserid(Integer gainuserid) {
		this.gainuserid = gainuserid;
	}
	public String getGainuser() {
		return gainuser;
	}
	public void setGainuser(String gainuser) {
		this.gainuser = gainuser;
	}
	@Override
	public String toString() {
		return "Bottle [Id=" + Id + ", bottlename=" + bottlename + ", bottlecontent=" + bottlecontent
				+ ", bottleuserid=" + bottleuserid + ", bottleusername=" + bottleusername + ", drifttime=" + drifttime
				+ ", state=" + state + ", gainuserid=" + gainuserid + ", gainuser=" + gainuser + "]";
	}
	
	
	

}
