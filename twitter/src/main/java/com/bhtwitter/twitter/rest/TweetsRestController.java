package com.bhtwitter.twitter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhtwitter.twitter.entity.Tweets;
import com.bhtwitter.twitter.service.TweetService;
import com.bhtwitter.twitter.service.UsersService;

@RestController
@RequestMapping("/api")
public class TweetsRestController {
	private UsersService usersService;
	private TweetService tweetService;
	@Autowired
	public TweetsRestController(TweetService theTweetService, UsersService theUsersService) {
		tweetService = theTweetService;
		usersService = theUsersService;
	}
	
	@PostMapping("/{userId}/tweets")
	public void addTweets(@PathVariable int userId, @RequestBody Tweets theTweet)
	
	{
		//theTweet.setTweetUserId(Users);
		
		
		tweetService.save(theTweet, userId);
	}
	@GetMapping("/tweets/{tag}")
	public void getTagRelatedTweets(@PathVariable String tag) {
		List<Tweets> tt = tweetService.getTagRelatedTweets(tag);
		for(Tweets t : tt) {
			System.out.println(t);
		}
	}
}
