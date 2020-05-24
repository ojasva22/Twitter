package com.bhtwitter.twitter.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhtwitter.twitter.dao.FollowersDAO;
import com.bhtwitter.twitter.dao.UsersDAO;
import com.bhtwitter.twitter.entity.Followers;
import com.bhtwitter.twitter.entity.Users;

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
		//error if userid does not exist
		Users userF = usersDAO.getUserById(user);
		Users userToFollow = usersDAO.getUserById(toFollow);
		Followers flw = new Followers(userF, userToFollow, LocalDateTime.now());

		followersDAO.followerAdd(flw);
	}
	@Override
	@Transactional
	public void unfollow(int userFollower, int toUnfollow) {
		Users userF = usersDAO.getUserById(userFollower);
		Users userToUnfollow = usersDAO.getUserById(toUnfollow);
		followersDAO.unfollow(userF, userToUnfollow);
		
	}

}
