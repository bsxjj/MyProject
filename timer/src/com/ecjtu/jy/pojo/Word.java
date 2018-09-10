package com.ecjtu.jy.pojo;

/**
 * 过滤词汇表实体类
 * @author 建伟
 * @date 20180724
 * @version 1.0
 *
 */
public class Word {

	private Integer wordId; //词汇Id
	private String words;	// 具体词汇
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
