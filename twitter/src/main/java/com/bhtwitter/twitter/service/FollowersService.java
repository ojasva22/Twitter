package com.bhtwitter.twitter.service;

import java.util.List;

import com.bhtwitter.twitter.entity.Followers;
import com.bhtwitter.twitter.entity.Users;

public interface FollowersService {
	public void addFollower(int user, int toFollow);

	public void unfollow(int userFollower, int toUnfollow);

	public List<Users> getFollowers(int userId);
}
