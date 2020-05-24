package com.bhtwitter.twitter.dao;

import java.util.List;

import com.bhtwitter.twitter.entity.Tweets;

public interface TweetsDAO {
	public void save(Tweets theTweet);
	public List<Tweets> getTagRelatedTweets(String tag);
	public void delete(int tweetId);
	public Tweets getTweetById(int id);
}
