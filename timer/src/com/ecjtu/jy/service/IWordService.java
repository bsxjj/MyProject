package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Word;

/**
 * 过滤词汇服务接口
 * @author 建伟
 * @date 20180726
 * @version 1.0
 */
public interface IWordService {

	/**
	 * 新增过滤词汇
	 * @param word 过滤词汇实体类
	 * @return >0 新增成功 =0新增失败 
	 */
	int insertWord(Word word);
	
	/**
	 * 根据词汇id进行删除
	 * @param id 词汇id
	 * @return >0 删除成功 =0删除失败 
	 */
	int deleteWord(int id);
	
	/**
	 * 修改过滤词汇
	 * @param word
	 * @return >0 修改成功 =0修改失败 
	 */
	int updateWord(Word word);
	
	/**
	 * 根据页号查询过滤词汇
	 * @param pageNum 页号
	 * @return
	 */
	List<Word> selectWordByPageNum(int pageNum);
	/**
	 * 返回过滤词汇的总数
	 * @return
	 */
	int selectWordCount();
}
