package com.bhtwitter.twitter.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhtwitter.twitter.entity.Tweets;
import com.bhtwitter.twitter.entity.Users;
import com.bhtwitter.twitter.service.LikesService;
import com.bhtwitter.twitter.service.SensitiveWordsService;
import com.bhtwitter.twitter.service.TweetService;
import com.bhtwitter.twitter.service.UsersService;

@RestController
@RequestMapping("/api")
public class TweetsRestController {
	//private UsersService usersService;
	private TweetService tweetService;
	@Autowired
	public TweetsRestController(TweetService theTweetService) {
		tweetService = theTweetService;
		//usersService = theUsersService;
	}
	@Autowired
	private LikesService likesService;
	@Autowired
	private SensitiveWordsService sensitiveWordsService;
	
	@PostMapping("/{userId}/tweets")
	public void addTweets(@PathVariable int userId, @RequestBody Tweets theTweet)
	
	{
		//theTweet.setTweetUserId(Users);
		
		theTweet.setCreatedOn(LocalDateTime.now());
		tweetService.save(theTweet, userId);
	}
	
	@GetMapping("/tweets/{tag}")
	public void getTagRelatedTweets(@PathVariable String tag, @RequestParam int page) {
		List<Tweets> tt = tweetService.getTagRelatedTweets(tag, page);
		for(Tweets t : tt) {
			System.out.println(t);
		}
	}
	
	
	@DeleteMapping("/users/{userId}/tweets/{tweetId}")
	public void deleteTweet(@PathVariable int tweetId, @PathVariable int userId) {
		tweetService.delete(tweetId, userId);
	}
	
	
	@GetMapping("/tweets/{tweetId}/likes")
	@ResponseBody
	public List<Users> getTweetLikedByUsers(@PathVariable int tweetId){
		return tweetService.getTweetLikedByUsers(tweetId);
	}
	
	@GetMapping("/admin/tweets")	
	public List<Tweets> getAllTweets(@RequestParam int page, @RequestParam(defaultValue = "createdOn") String sort)
	{
		return tweetService.getAllTweets(page , sort);
	}
	
	@GetMapping("/admin/trending")
	public List<String> getTrendingTags(){
		return tweetService.getTrendingTags();
	}
	

	

	@DeleteMapping("/admin/tweets/{tweetId}")
	public void deleteTweets(@PathVariable int tweetId){
		tweetService.delete(tweetId);
	//	return new ResponseEntity<T>
	}
	
}
