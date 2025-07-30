package com.jijamataCollege.storeManagementSystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jijamataCollege.storeManagementSystem.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	 Optional<User> findByUserNameAndPassword(String userName, String password);
}
