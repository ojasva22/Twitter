package com.bhtwitter.twitter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhtwitter.twitter.dao.UsersDAO;
import com.bhtwitter.twitter.entity.Users;
@Service
public class UsersServiceImpl implements UsersService {
	
	private UsersDAO usersDAO;
	@Autowired
	public UsersServiceImpl(UsersDAO theUserDAO) {
		usersDAO = theUserDAO;
	}
	@Override
	@Transactional
	public void save(Users theUser) {
		usersDAO.save(theUser);

	}
	@Override
	public Users getUserById(Integer id) {
		// TODO Auto-generated method stub
		return usersDAO.getUserById(id);
	}
	@Override
	public Users getUserByUsername(String username) {
		return usersDAO.getUserByUsername(username);
	}
	@Override
	public List<Users> getUsers() {
		return usersDAO.getUsers();
	}

}
