package com.bhtwitter.twitter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bhtwitter.twitter.entity.Users;

public interface UsersService {
	public void save(Users theUser);
	public Users getUserById(Integer id);
	public Users getUserByUsername(String username);
	public List<Users> getUsers();
	public boolean emailAlreadyExists(String email);
	public boolean userAlreadyExists(String name);
	
}
