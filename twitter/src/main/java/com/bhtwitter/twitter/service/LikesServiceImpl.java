package com.bhtwitter.twitter.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhtwitter.twitter.dao.LikesDAO;
import com.bhtwitter.twitter.entity.Likes;
import com.bhtwitter.twitter.entity.Tweets;
import com.bhtwitter.twitter.entity.Users;

@Service
public class LikesServiceImpl implements LikesService {
	@Autowired
	private UsersService usersService;
	@Autowired
	private TweetService tweetService;
	@Autowired
	private LikesDAO likesDAO;
	
	@Override
	@Transactional
	public void likeTweet(int userId, int tweetId) {
		Users user = usersService.getUserById(userId);
		Tweets tweet = tweetService.getTweetById(tweetId);
		Likes l = new Likes(LocalDateTime.now(), user, tweet);
		likesDAO.likeTweet(l);

	}

	@Override
	@Transactional
	public void unlikeTweet(int userId, int tweetId) {
		Users userLiked = usersService.getUserById(userId);
		Tweets tweetLiked = tweetService.getTweetById(tweetId);
		
		likesDAO.unlikeTweet(userLiked, tweetLiked);
		
	}

}
