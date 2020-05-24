package com.bhtwitter.twitter.service;

import java.util.List;

import com.bhtwitter.twitter.entity.Tweets;

public interface TweetService {
	public void save(Tweets theTweet, Integer userId);
	public List<Tweets> getTagRelatedTweets(String tag);
	public void delete(int tweetId);
	public Tweets getTweetById(int id);
}
