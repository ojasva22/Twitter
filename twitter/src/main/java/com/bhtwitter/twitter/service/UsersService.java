package com.bhtwitter.twitter.service;

import com.bhtwitter.twitter.entity.Users;

public interface UsersService {
	public void save(Users theUser);
	public Users getUserById(Integer id);
}
