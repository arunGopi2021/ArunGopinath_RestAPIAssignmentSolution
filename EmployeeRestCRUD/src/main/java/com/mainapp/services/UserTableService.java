package com.mainapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mainapp.entities.User;





@Service
public interface UserTableService {
	
	// save user
	public void saveUser(User user);
	
	// get all users
	public List<User> getAllUsers();
	
	// delete user by username
	public void deleteUser(String username);
	
	
	// find a user by username
	public User findUser(String username);

}
