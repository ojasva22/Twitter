package com.bhtwitter.twitter.rest;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bhtwitter.twitter.entity.Users;
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
	public void addUser( @RequestBody Users theUser)
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
	public Users getUserByUsername(@PathVariable String name) {
		Users user = usersService.getUserByUsername(name);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return user;
	}

	
	

}
