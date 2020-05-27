package com.bhtwitter.twitter.dao;

import java.util.List;

import com.bhtwitter.twitter.entity.Likes;
import com.bhtwitter.twitter.entity.Tweets;
import com.bhtwitter.twitter.entity.Users;

public interface LikesDAO {
	public void likeTweet(Likes theLike);

	

	



	void unlikeTweet(Users user, Tweets tweet);







}
