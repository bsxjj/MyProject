package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Follow;

/**
 * ��˿����ע����ӿڲ�
 * @author ��ΰ
 * @date 20180726
 * @version 1.0
 */
public interface IFollowService {

	/**
	 * ���ӹ�ע(��ӹ�ע)
	 * @param follw ��עʵ��
	 * @return >0�ɹ�  =0ʧ��
	 */
	int insertFocus(Follow follw);
	
	/**
	 * ɾ����ע(ȡ����ע)
	 * @param follow ��עʵ��
	 * @return >0�ɹ�  =0ʧ��
	 */
	int deleteFocus(Follow follow);
	
	/**
	 * ��ҳ��ȡ����ע����
	 * @param userid �û�id
	 * @param pageNum ҳ��
	 * @return ��ע����
	 */
	List<Follow> selectFocusByPageNum(int userid,int pageNum);
	
	/**
	 * ��ȡ��ע���˵�����
	 * @param userid �û�id
	 * @return ����ע���˵�����
	 */
	int selectFocusCountNum(int userid);
	
	/**
	 * ��ҳ��ȡ��˿����
	 * @param userid �û�id
	 * @param pageNum ҳ��
	 * @return ��˿����
	 */
	List<Follow> selectFansByPageNum(int userid,int pageNum);
	
	/**
	 * ��ȡ��˿����
	 * @param userid �û�id
	 * @return ��˿����
	 */
	int selectFansCountNum(int userid);
	
	public boolean isFocus(int userid, int myid);
	
	
	public int deleteFollowByFollow(Follow follow);
	
}
