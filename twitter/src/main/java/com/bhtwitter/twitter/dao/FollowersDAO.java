package com.bhtwitter.twitter.dao;

import java.util.List;

import com.bhtwitter.twitter.entity.Followers;
import com.bhtwitter.twitter.entity.Users;

public interface FollowersDAO {
	
	void followerAdd(Followers theFollower);

	void unfollow(Users userF, Users userToUnfollow);

	List<Users> getFollowers(int userId);
	
}
