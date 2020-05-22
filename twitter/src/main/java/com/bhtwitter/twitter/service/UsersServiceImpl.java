package com.bhtwitter.twitter.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.dao.UsersDAO;
import com.bhtwitter.twitter.entity.Users;
@Repository
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

}
