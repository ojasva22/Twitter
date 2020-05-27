package com.bhtwitter.twitter.rest;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bhtwitter.twitter.entity.Users;
import com.bhtwitter.twitter.exception.AlreadyExists;
import com.bhtwitter.twitter.exception.UserNotFoundException;
import com.bhtwitter.twitter.service.UsersService;


@RestController
@RequestMapping("/api")
public class UsersRestController {
	
	//private PasswordEncoder passwordEncoder;
	@Autowired
	private UsersService usersService;
	//private UserTypeService userTypeService;
/*	@Autowired
	public UsersRestController(PasswordEncoder passwordEncoder, UsersService usersService) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.usersService = usersService;
	}*/
	
	@PostMapping("/register")
	public void addUser( @Valid @RequestBody Users theUser)
	{
		//theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
		
		theUser.setCreatedOn(LocalDateTime.now());
		usersService.save(theUser);
		
		
		//return theUser;
		
		
	}
	@GetMapping("/users")
	public List<Users> getUsers(){
		return usersService.getUsers();
	}
	
	@GetMapping("/users/{name}")
	public Users getUserByUsername(@PathVariable String name) throws UserNotFoundException {
		Users user = usersService.getUserByUsername(name);
		if(user==null)
			throw new UserNotFoundException("Username Not Found");
		return user;
	}

	
	

}
