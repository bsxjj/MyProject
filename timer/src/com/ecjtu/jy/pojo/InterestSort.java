package com.ecjtu.jy.pojo;

/**
 * ��Ȥ�����ʵ����
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public class InterestSort {

	private Integer interestSortId;//��Ȥ����ID
	private String interestSortName;//��Ȥ��������
	public InterestSort(Integer interestSortId, String interestSortName) {
		super();
		this.interestSortId = interestSortId;
		this.interestSortName = interestSortName;
	}
	public InterestSort() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InterestSort [interestSortId=" + interestSortId + ", interestSortName=" + interestSortName + "]";
	}
	public Integer getInterestSortId() {
		return interestSortId;
	}
	public void setInterestSortId(Integer interestSortId) {
		this.interestSortId = interestSortId;
	}
	public String getInterestSortName() {
		return interestSortName;
	}
	public void setInterestSortName(String interestSortName) {
		this.interestSortName = interestSortName;
	}
	
	
	
}
