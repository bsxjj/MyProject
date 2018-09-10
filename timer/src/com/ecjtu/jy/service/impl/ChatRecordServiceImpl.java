package com.ecjtu.jy.service.impl;

import java.util.List;
import com.ecjtu.jy.dao.IChatRecordDao;
import com.ecjtu.jy.dao.impl.ChatRecordDaoImpl;
import com.ecjtu.jy.pojo.ChatRecord;
import com.ecjtu.jy.pojo.UserInfo;
import com.ecjtu.jy.service.IChatRecordService;
import com.ecjtu.jy.service.IUserInfoService;

public class ChatRecordServiceImpl implements IChatRecordService{
	IChatRecordDao icrdao = null;
	public ChatRecordServiceImpl() {
		icrdao = new ChatRecordDaoImpl();
	}
	@Override
	public ChatRecord insertChatRecord(ChatRecord cr) {
		
		return icrdao.insertChatRecord(cr);
	}

	@Override
	public int deleteChatRecord(int crid, int userid) {
		return icrdao.deleteChatRecord(crid, userid);
	}

	@Override
	public int updateChatRecord(int crid) {
		return icrdao.updateChatRecord(crid);
	}

	@Override
	public List<ChatRecord> selectChatRecordList(int userid) {
		IUserInfoService iuservice = new UserInfoServiceImpl();
		List<ChatRecord> chatRecordList = icrdao.selectChatRecordList(userid);
		for (ChatRecord chatRecord : chatRecordList) {
			UserInfo user = null;
			if (chatRecord.isSend()){
				
				user = iuservice.selectUserById(chatRecord.getReceiveid());
			}else{
				user = iuservice.selectUserById(chatRecord.getSendid());
			}
			chatRecord.setOtherhead(user.getHeadPicture());
			chatRecord.setOthername(user.getUsername());
			
		}
		
		return chatRecordList;
		
	}

}
