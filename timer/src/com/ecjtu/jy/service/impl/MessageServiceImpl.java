package com.ecjtu.jy.service.impl;

import java.util.List;

import com.ecjtu.jy.dao.IMessageDao;
import com.ecjtu.jy.dao.impl.MessageDaoImpl;
import com.ecjtu.jy.pojo.Message;
import com.ecjtu.jy.service.IMessageService;

public class MessageServiceImpl implements IMessageService{

	IMessageDao dao=new MessageDaoImpl();
	@Override
	public int insertMessage(Message mess) {
		int result=0;
		result=dao.insertMessage(mess);
		return result;
	}

	@Override
	public int deleteMessage(int id) {
		
		return dao.deleteMessage(id);
	}

	@Override
	public List<Message> selectMessagesByPageNum(int pageNum, int userid) {
		return dao.selectMessagesByPageNum(pageNum, userid);
	}

	@Override
	public int selectMessageCount(int userid) {
		return dao.selectMessageCount(userid);
	}

}
