package com.bhtwitter.twitter.service;

import java.util.List;

import com.bhtwitter.twitter.entity.Users;

public interface LikesService {
	public void likeTweet(int userId, int tweetId);

	public void unlikeTweet(int userId, int tweetId);

	
}
