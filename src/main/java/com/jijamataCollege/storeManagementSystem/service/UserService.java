package com.jijamataCollege.storeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jijamataCollege.storeManagementSystem.Entity.User;
import com.jijamataCollege.storeManagementSystem.dao.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	public User findValidUser(User user) {
		
		 
		Optional<User> validUser= userRepo.findByUserNameAndPassword(user.getUserName(),user.getPassword()) ;
		
	 return validUser.orElse(null);
	}
	public User createUser(User user) {
		 return userRepo.save(user);
		 
	}
	

}
