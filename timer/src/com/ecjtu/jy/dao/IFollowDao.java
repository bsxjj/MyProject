package com.ecjtu.jy.dao;

import java.util.List;

import com.ecjtu.jy.pojo.Follow;

/**
 * �û���ע��ӿ�
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 */
public interface IFollowDao {

	/**
	 * ����ҳ������ѯ����ע����
	 * @param pageNum ҳ�� ÿҳ����10��
	 * @param id ��ע��id
	 * @param type type������ѯ������ֻ�������ѯ��ע�б��Ƿ�˿�б�
	 * ��typeΪ0��ʾִ�в�ѯ��ע���˵Ĳ�ѯ��typeΪ1��ʾִ�в�ѯ��ע�ҵ��˵Ĳ�ѯ
	 * @return ����ע�ߵļ��� ���ע�ߵļ���
	 */
	List<Follow> selectFollowByPageNum(int pageNum,int id,int type);
	
	/**
	 * ��ȡ����ע���˵�����
	 * @param id ��ע��id
	 * @param type������ѯ������ֻ�������ѯ��ע�б��������Ƿ�˿�б�����
	 * ��typeΪ0��ʾִ�в�ѯ��ע���˵�������ѯ��typeΪ1��ʾִ�в�ѯ��ע�ҵ��˵�������ѯ
	 * @return ����ע������
	 */
	int selectFollowUserCount(int id,int type);
	
	/**
	 * ����id����ѯFollow
	 * @param id ��ע��id�򱻹�ע��id
	 * @param type type������ѯ������ֻ�������ѯ��ע�߻��Ƿ�˿
	 * ��typeΪ0��ʾִ�в�ѯ��ע���˵Ĳ�ѯ��typeΪ1��ʾִ�в�ѯ��˿�Ĳ�ѯ
	 * @return
	 */
	Follow selectFollowById(int id,int type);
	
	/**
	 * ȡ����ע
	 * @param id ����id��Ϊfollowerid
	 * @return >0��ʾȡ�سɹ�  =0ȡ��ʧ��
	 */
	int deleteFollowById(int id);
	
	/**
	 * ��ע
	 * @param follow ��ע����
	 * @return ���� >0��ע�ɹ�  =0��עʧ��
	 */
	int insertFollow(Follow follow);
	
	/**
	 * �鿴�Ƿ��Ѿ���ע
	 * @param userid ���û�id
	 * @param myid �ҵ�id
	 * @return true �ѹ�ע falseδ��ע
	 * 
	 */
	boolean isFocus(int userid,int myid);
	
	
	/**
	 * �����û�֮��Ĺ�ϵ����ȡ��
	 * @param follow
	 * @return
	 */
	int deleteFollowByFollow(Follow follow);
}
