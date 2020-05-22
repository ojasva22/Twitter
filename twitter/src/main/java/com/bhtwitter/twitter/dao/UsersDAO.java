package com.bhtwitter.twitter.dao;

import com.bhtwitter.twitter.entity.Users;

public interface UsersDAO {
	public void save(Users theUser);
	public Users getUserById(Integer id);
}
