package com.bhtwitter.twitter.service;

import java.util.List;

import com.bhtwitter.twitter.entity.SensitiveWords;

public interface SensitiveWordsService {
	public List<String> getSensitiveWords();

	public void addSensitive(SensitiveWords theSensitiveWord);

	public void updateWord(SensitiveWords sensitiveWord);

	public SensitiveWords findByWord(String word);

	public boolean checkSensitive(int tweetId);

	public boolean isWordSensitive(String word);

}
