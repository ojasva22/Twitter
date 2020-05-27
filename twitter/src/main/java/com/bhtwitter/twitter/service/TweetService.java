package com.bhtwitter.twitter.service;

import java.util.List;

import com.bhtwitter.twitter.entity.Tweets;
import com.bhtwitter.twitter.entity.Users;

public interface TweetService {
	public void save(Tweets theTweet, Integer userId);
	public List<Tweets> getTagRelatedTweets(String tag);
	
	public Tweets getTweetById(int id);
	void delete(int tweetId, int userId);
	public List<Users> getTweetLikedByUsers(int tweetId);
	public List<Tweets> getAllTweets();
	public List<String> getTrendingTags();
	
}
