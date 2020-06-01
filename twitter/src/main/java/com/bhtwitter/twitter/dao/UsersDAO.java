package com.bhtwitter.twitter.dao;

import java.util.List;

import com.bhtwitter.twitter.entity.Users;

public interface UsersDAO {
	public void save(Users theUser);
	public Users getUserById(Integer id);
	public Users getUserByUsername(String username);
	public List<Users> getUsers();
	public boolean emailAlreadyExists(String email);
	public boolean userAlreadyExists(String name);
}
