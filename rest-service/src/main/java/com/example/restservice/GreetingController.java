package com.example.restservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@GetMapping("/")
	public List<User> getAllUsers() {
    Users getAllUsers = new Users();
    List<User> returnContent = getAllUsers.getAllUsers(); 
		return returnContent;
  }

	@GetMapping("/{id}")
	public List<User> userById(@PathVariable("id") int id) {
    Users getUser = new Users();
    List<User> returnContent = getUser.getUserById(id); 
		return returnContent;
  }
  
	@PostMapping("/")
	public User addUser(@RequestBody User inUser) {
    String firstName = inUser.firstName;
    String lastName = inUser.lastName;
    User newUser = new User(10, firstName, lastName);
    System.out.println(inUser);
    return newUser;
    
  }
  
}