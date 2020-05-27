package com.bhtwitter.twitter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bhtwitter.twitter.dao.UserTypeDAO;
import com.bhtwitter.twitter.dao.UsersDAO;
import com.bhtwitter.twitter.entity.Users;
import com.bhtwitter.twitter.exception.UserNotFoundException;
@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UserTypeService userTypeService;
	
	private UsersDAO usersDAO;
	@Autowired
	public UsersServiceImpl(UsersDAO theUserDAO) {
		usersDAO = theUserDAO;
	}
	@Override
	@Transactional
	public void save(Users theUser) {
		String r = theUser.getUsername();
		System.out.println(r);
		System.out.println(theUser.getRole());
		theUser.setUserType(userTypeService.getUserType(theUser.getRole()));
		usersDAO.save(theUser);
		

	}
	@Override
	public Users getUserById(Integer id) {
		try {
		return usersDAO.getUserById(id);
		}catch(Exception e)
		{
			throw new UserNotFoundException("User not found");
		}
	}
	@Override
	public Users getUserByUsername(String username) {
		try {
		return usersDAO.getUserByUsername(username);
		}catch(Exception e)
		{
			throw new UserNotFoundException("User not found");
		}
		
	
	}
	@Override
	public List<Users> getUsers() {
		return usersDAO.getUsers();
	}

}
