package com.bhtwitter.twitter.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhtwitter.twitter.dao.LikesDAO;
import com.bhtwitter.twitter.entity.Likes;
import com.bhtwitter.twitter.entity.Tweets;
import com.bhtwitter.twitter.entity.Users;
import com.bhtwitter.twitter.exception.TweetNotFoundException;
import com.bhtwitter.twitter.exception.UserNotFoundException;

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
		Tweets tweet;
		if(user==null)
			throw new UserNotFoundException("User not Found");
		try {
			 tweet = tweetService.getTweetById(tweetId);		
		}catch(Exception e) {
			throw new TweetNotFoundException("Tweet not found");
		}
		Likes l = new Likes(LocalDateTime.now(), user, tweet);
		likesDAO.likeTweet(l);

	}

	@Override
	@Transactional
	public void unlikeTweet(int userId, int tweetId) {
		Users userLiked = usersService.getUserById(userId);
		
		if(userLiked==null)
			throw new UserNotFoundException("User not Found");
		Tweets tweetLiked;
		try {
			tweetLiked = tweetService.getTweetById(tweetId);
		}catch(Exception e) {
			throw new TweetNotFoundException("Tweet not found");
		}
		likesDAO.unlikeTweet(userLiked, tweetLiked);
		
	}


}
