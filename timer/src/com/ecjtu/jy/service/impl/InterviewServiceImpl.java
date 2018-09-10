package com.ecjtu.jy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ecjtu.jy.dao.IInterviewDao;
import com.ecjtu.jy.dao.impl.InterviewDaoImpl;
import com.ecjtu.jy.pojo.Interview;
import com.ecjtu.jy.service.IInterviewService;

public class InterviewServiceImpl implements IInterviewService {
	private IInterviewDao interviewDao = new InterviewDaoImpl(); 
	
	@Override
	public int insertInterview(Interview interview) {
		int result = 0;
		result = interviewDao.insertInterview(interview);
		return result;
	}

	@Override
	public int deleteInterview(int interid) {
		int result = 0;
		result = interviewDao.deleteInterview(interid);
		return result;
	}

	@Override
	public List<Interview> selectInterviewByPageNum(int pageNum, int userid) {
		List<Interview> interviews = new ArrayList<>();
		interviews = interviewDao.selectInterviewByPageNum(pageNum, userid);
		return interviews;
	}

}
