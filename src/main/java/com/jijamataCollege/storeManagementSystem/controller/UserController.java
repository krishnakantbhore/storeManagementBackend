package com.jijamataCollege.storeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jijamataCollege.storeManagementSystem.Entity.User;
import com.jijamataCollege.storeManagementSystem.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/getAllUsers")
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
	@GetMapping("/getAllUsersById")
	public User getAllUserById(@RequestParam int id) {
		
		return userService.findAllUsersById(id);
	}
	
	@DeleteMapping("deleteById/{id}")
	public void deleteData(@PathVariable int id) {
		userService.deleteData(id);
		
	}
	
}
