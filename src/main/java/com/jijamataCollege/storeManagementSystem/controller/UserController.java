package com.jijamataCollege.storeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jijamataCollege.storeManagementSystem.Entity.User;
import com.jijamataCollege.storeManagementSystem.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/getAlllUsers")
	public List<User> getAllUser() {
		
		return userService.findAllUsers();
	}
	
	@PostMapping("/login")
	public User findValidUser(@RequestBody User user) {
		return userService.findValidUser(user);
//		return "userService.findValidUser(user)";
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}
