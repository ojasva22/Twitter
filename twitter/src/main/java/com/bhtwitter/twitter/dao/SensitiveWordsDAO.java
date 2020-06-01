package com.bhtwitter.twitter.dao;

import java.util.List;

import com.bhtwitter.twitter.entity.SensitiveWords;

public interface SensitiveWordsDAO {
	public List<String> getSensitiveWords();

	public void addSensitiveWords(SensitiveWords theSensitiveWord);

	public void updateWord(SensitiveWords sensitiveWord);

	public SensitiveWords findByWord(String word);

	public boolean isWordSensitive(String word);
	

}
