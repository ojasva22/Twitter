package com.bhtwitter.twitter.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhtwitter.twitter.dao.FollowersDAO;
import com.bhtwitter.twitter.dao.UsersDAO;
import com.bhtwitter.twitter.entity.Followers;
import com.bhtwitter.twitter.entity.Users;
import com.bhtwitter.twitter.exception.FollowerException;
import com.bhtwitter.twitter.exception.UserNotFoundException;

@Service
public class FollowersServiceImpl implements FollowersService {
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private FollowersDAO followersDAO;
	@Override
	@Transactional
	public void addFollower(int user, int toFollow) { 
		//check if int user is logged in user
		
		Users userF = usersDAO.getUserById(user);
		Users userToFollow = usersDAO.getUserById(toFollow);
		if(userF==null || userToFollow ==null)
			throw new UserNotFoundException("User not found");
		if(user == toFollow)
			throw new FollowerException("Not Allowed");
		Followers flw = new Followers(userF, userToFollow, LocalDateTime.now());

		followersDAO.followerAdd(flw);
	}
	@Override
	@Transactional
	public void unfollow(int userFollower, int toUnfollow) {
		Users userF = usersDAO.getUserById(userFollower);
		Users userToUnfollow = usersDAO.getUserById(toUnfollow);
		if(userF==null || userToUnfollow ==null)
			throw new UserNotFoundException("User not found");
		List<Followers> follower = userF.getFollowers();
		ArrayList<Integer> followerId = new ArrayList<>();
		for(Followers f : follower) {
			followerId.add(f.getUserToFollow().getId());
		}
		if(!followerId.contains(toUnfollow) || userFollower == toUnfollow) {
			throw new FollowerException("Not Allowed");
		}
		
		followersDAO.unfollow(userF, userToUnfollow);
		
	}
	@Override
	public List<Users> getFollowers(int userId) {
		try {
		return followersDAO.getFollowers(userId);
		}catch(Exception e) {
			throw new UserNotFoundException("User not found");
		}
	}

}
