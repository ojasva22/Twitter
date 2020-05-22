package com.bhtwitter.twitter.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhtwitter.twitter.entity.Users;
import com.bhtwitter.twitter.service.UsersService;


@RestController
@RequestMapping("/api")
public class UsersRestController {
	
	private UsersService usersService;
	//private UserTypeService userTypeService;
	@Autowired
	public UsersRestController(UsersService theUserService) {
		usersService = theUserService;
		
	}
	
	
	@PostMapping("/users")
	public void addUser( @RequestBody Users theUser)
	{
		
		theUser.setCreatedOn(LocalDateTime.now());
		usersService.save(theUser);
		//return theUser;
		
		
	}
	
	

}
