package com.bhtwitter.twitter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhtwitter.twitter.service.LikesService;

@RestController
@RequestMapping("/api")
public class LikesRestController {
	@Autowired
	private LikesService likesService;
	
	@PostMapping("/users/{userId}/likes/{tweetId}")
	public void likeTweet(@PathVariable int userId, @PathVariable int tweetId) {
		likesService.likeTweet(userId, tweetId);
	}
	@DeleteMapping("/users/{userId}/likes/{tweetId}")
	public void unlikeTweet(@PathVariable int userId, @PathVariable int tweetId) {
		likesService.unlikeTweet(userId, tweetId);
	}
}
