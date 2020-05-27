package com.bhtwitter.twitter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhtwitter.twitter.entity.Followers;
import com.bhtwitter.twitter.entity.Users;
import com.bhtwitter.twitter.service.FollowersService;

@RestController
@RequestMapping("/api")
public class FollowersRestController {
	@Autowired
	private FollowersService followerService;
	
	@PostMapping("/users/{userFollower}/follow/{toFollow}")
	public void addFollower(@PathVariable int userFollower, @PathVariable int toFollow) {
		
		followerService.addFollower(userFollower, toFollow);
	}
	@DeleteMapping("/users/{userFollower}/follow/{toFollow}")
	public void unfollow(@PathVariable int userFollower, @PathVariable int toFollow) {
		followerService.unfollow(userFollower, toFollow);
	}
	@GetMapping("/users/{userId}/followers")
	@ResponseBody
	public List<Users> getFollowers(@PathVariable int userId) {
		return followerService.getFollowers(userId);
	}
}
