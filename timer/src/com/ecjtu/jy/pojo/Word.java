package com.ecjtu.jy.pojo;

/**
 * ���˴ʻ��ʵ����
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 *
 */
public class Word {

	private Integer wordId; //�ʻ�Id
	private String words;	// ����ʻ�
	public Word(Integer wordId, String words) {
		super();
		this.wordId = wordId;
		this.words = words;
	}
	public Word() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getWordId() {
		return wordId;
	}
	public void setWordId(Integer wordId) {
		this.wordId = wordId;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	@Override
	public String toString() {
		return "Word [wordId=" + wordId + ", words=" + words + "]";
	}
	
	
}
