package com.ecjtu.jy.pojo;

import java.sql.Timestamp;

/**
 * ���ʼ�¼��ʵ����
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public class Interview {
	//id
	private Integer id;
	//������
	private Integer interviewid;
	//�����˵�����
	private String interviewName;
	//������ͷ��
	private String interviewImg;
	//��������
	private Integer beinterviewid;
	//����ʱ��
	private Timestamp interviewtime;
	public Interview() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Interview(Integer id, Integer interviewid, String interviewName, String interviewImg, Integer beinterviewid,
			Timestamp interviewtime) {
		super();
		this.id = id;
		this.interviewid = interviewid;
		this.interviewName = interviewName;
		this.interviewImg = interviewImg;
		this.beinterviewid = beinterviewid;
		this.interviewtime = interviewtime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getInterviewid() {
		return interviewid;
	}
	public void setInterviewid(Integer interviewid) {
		this.interviewid = interviewid;
	}
	public String getInterviewName() {
		return interviewName;
	}
	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}
	public String getInterviewImg() {
		return interviewImg;
	}
	public void setInterviewImg(String interviewImg) {
		this.interviewImg = interviewImg;
	}
	public Integer getBeinterviewid() {
		return beinterviewid;
	}
	public void setBeinterviewid(Integer beinterviewid) {
		this.beinterviewid = beinterviewid;
	}
	public Timestamp getInterviewtime() {
		return interviewtime;
	}
	public void setInterviewtime(Timestamp interviewtime) {
		this.interviewtime = interviewtime;
	}
	@Override
	public String toString() {
		return "Interview [id=" + id + ", interviewid=" + interviewid + ", interviewName=" + interviewName
				+ ", interviewImg=" + interviewImg + ", beinterviewid=" + beinterviewid + ", interviewtime="
				+ interviewtime + "]";
	}
	
	
	
	
	
	
	
}
