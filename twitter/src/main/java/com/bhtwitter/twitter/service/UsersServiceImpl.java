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
import com.bhtwitter.twitter.exception.UniqueException;
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
	/*
	 * @Autowired private BCryptPasswordEncoder bCrypt;
	 */
	
	@Override
	@Transactional
	public void save(Users theUser) {
		String r = theUser.getUsername();
		/*
		 * System.out.println(r); System.out.println(theUser.getRole());
		 */
		
		boolean userExist = userAlreadyExists(theUser.getUsername());
		if(userExist) {
			throw new UniqueException("Username Already Exists");
		}
		if(emailAlreadyExists(theUser.getEmail())) {
			throw new UniqueException("Email already exists");
		}
		
		
		try {
		theUser.setUserType(userTypeService.getUserType(theUser.getRole()));
		}catch(Exception e) {
			System.out.println(e.getClass());
			throw new UserNotFoundException("Role can be either USER or ADMIN");
		}
		
		//theUser.setPassword(bCrypt.encode(theUser.getPassword()));
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
		//try {
		return usersDAO.getUserByUsername(username);
		//}catch(Exception e)
		//{
		//	throw new UserNotFoundException("User not found");
		//}
		
	
	
	}
	@Override
	public List<Users> getUsers() {
		return usersDAO.getUsers();
	}
	@Override
	public boolean emailAlreadyExists(String email) {
		
		return usersDAO.emailAlreadyExists(email);
	}
	@Override
	public boolean userAlreadyExists(String name) {
		
		return usersDAO.userAlreadyExists(name);
	}
	

}
