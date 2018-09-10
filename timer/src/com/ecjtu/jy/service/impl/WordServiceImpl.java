package com.ecjtu.jy.service.impl;

import java.util.List;

import com.ecjtu.jy.dao.IWordDao;
import com.ecjtu.jy.dao.impl.WordDaoImpl;
import com.ecjtu.jy.pojo.Word;
import com.ecjtu.jy.service.IWordService;

public class WordServiceImpl implements IWordService{

	IWordDao dao=new WordDaoImpl();
	@Override
	public int insertWord(Word word) {
		return dao.insertWord(word);
	}

	@Override
	public int deleteWord(int id) {
		return dao.deleteWord(id);
	}

	@Override
	public int updateWord(Word word) {
		return dao.updateWord(word);
	}

	@Override
	public List<Word> selectWordByPageNum(int pageNum) {
		return dao.selectWordByPageNum(pageNum);
	}

	@Override
	public int selectWordCount() {
		return dao.selectWordCount();
	}

}
