package com.bhtwitter.twitter.service;

public interface LikesService {
	public void likeTweet(int userId, int tweetId);

	public void unlikeTweet(int userId, int tweetId);
}
