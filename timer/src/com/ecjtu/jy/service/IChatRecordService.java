package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.ChatRecord;

public interface IChatRecordService {

	/**
	 * 向记录表中插入数据(sendid receiveid数值不区分左右)
	 * @param cr
	 * @return
	 */
	ChatRecord insertChatRecord(ChatRecord cr);

	/**
	 * 删除本人的聊天记录(将记录表中的sendstat改为1)
	 * @param sendid
	 * @return
	 */
	int deleteChatRecord(int crid,int userid);
	
	/**
	 * 暂不提供该方法
	 * @param crid
	 * @return
	 */
	int updateChatRecord(int crid);
	
	/**
	 * 查询我的聊天列表
	 * @param userid
	 * @return
	 */
	List<ChatRecord> selectChatRecordList(int userid);
}
