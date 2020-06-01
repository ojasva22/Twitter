package com.bhtwitter.twitter.service;

import java.util.List;

import com.bhtwitter.twitter.entity.TweetMapping;
import com.bhtwitter.twitter.entity.Tweets;

public interface TagTweetMappingService {
	public void saveMapping(String tag, Tweets theTweet);
	public List<TweetMapping> getMapping(int tweetId);
}
