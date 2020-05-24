package com.bhtwitter.twitter.service;

public interface FollowersService {
	public void addFollower(int user, int toFollow);

	public void unfollow(int userFollower, int toUnfollow);
}
