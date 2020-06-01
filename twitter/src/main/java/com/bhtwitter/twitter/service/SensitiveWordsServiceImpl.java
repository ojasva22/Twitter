package com.bhtwitter.twitter.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhtwitter.twitter.dao.SensitiveWordsDAO;
import com.bhtwitter.twitter.dao.TagTweetMappingDAO;
import com.bhtwitter.twitter.dao.TweetsDAO;
import com.bhtwitter.twitter.entity.SensitiveWords;
import com.bhtwitter.twitter.entity.TweetMapping;
import com.bhtwitter.twitter.entity.Tweets;
import com.bhtwitter.twitter.exception.TweetNotFoundException;
@Service
public class SensitiveWordsServiceImpl implements SensitiveWordsService{
	@Autowired
	private SensitiveWordsDAO sensitiveWordsDAO;
	@Autowired
	private TweetsDAO tweetsDAO;
	@Autowired
	private TagTweetMappingDAO tagTweetMappingDAO;
	@Override
	public List<String> getSensitiveWords() {
		List<String> words = sensitiveWordsDAO.getSensitiveWords();
		return words;
	}
	@Override
	@Transactional
	public void addSensitive(SensitiveWords theSensitiveWord) {
		
		sensitiveWordsDAO.addSensitiveWords(theSensitiveWord);
		
	}
	@Override
	@Transactional
	public void updateWord(SensitiveWords sensitiveWord) {
		sensitiveWordsDAO.updateWord(sensitiveWord);
		
	}
	@Override
	public SensitiveWords findByWord(String word) {
		return sensitiveWordsDAO.findByWord(word);
	}
	
	@Override
	@Transactional
	public boolean checkSensitive(int tweetId) {
		Tweets tweet = tweetsDAO.getTweetById(tweetId);
		if(tweet==null) throw new TweetNotFoundException("Tweet not found");
		String[] text = tweet.getTweet().trim().split(" ");
		//List<String> tags = tweet.getTags();
		List<TweetMapping> tm = tagTweetMappingDAO.getMapping(tweetId);
		List<String> tags = new ArrayList<>();
		for(TweetMapping t : tm) {
			tags.add(t.getTagId().getTag());
		}
		
		for(String t : text) {
			if(t.charAt(0)!='#') {
			if(isWordSensitive(t))
				return true;	
			}
		}
		for(String t : tags) {
			if(isWordSensitive(t))
				return true;
		}
		return false;
		
	}
	
	@Override
	public boolean isWordSensitive(String word) {
		return sensitiveWordsDAO.isWordSensitive(word);
		
	}
}
