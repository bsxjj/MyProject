package com.ecjtu.jy.service;

import java.util.List;

import com.ecjtu.jy.pojo.Word;

/**
 * ���˴ʻ����ӿ�
 * @author ��ΰ
 * @date 20180726
 * @version 1.0
 */
public interface IWordService {

	/**
	 * �������˴ʻ�
	 * @param word ���˴ʻ�ʵ����
	 * @return >0 �����ɹ� =0����ʧ�� 
	 */
	int insertWord(Word word);
	
	/**
	 * ���ݴʻ�id����ɾ��
	 * @param id �ʻ�id
	 * @return >0 ɾ���ɹ� =0ɾ��ʧ�� 
	 */
	int deleteWord(int id);
	
	/**
	 * �޸Ĺ��˴ʻ�
	 * @param word
	 * @return >0 �޸ĳɹ� =0�޸�ʧ�� 
	 */
	int updateWord(Word word);
	
	/**
	 * ����ҳ�Ų�ѯ���˴ʻ�
	 * @param pageNum ҳ��
	 * @return
	 */
	List<Word> selectWordByPageNum(int pageNum);
	/**
	 * ���ع��˴ʻ������
	 * @return
	 */
	int selectWordCount();
}
