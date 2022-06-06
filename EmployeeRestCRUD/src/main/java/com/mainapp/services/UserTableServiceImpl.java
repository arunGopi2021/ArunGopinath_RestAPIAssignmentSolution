package com.mainapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainapp.entities.User;
import com.mainapp.repositories.UserRepository;



@Service
public class UserTableServiceImpl implements UserTableService {
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(String username) {
		userRepository.deleteByUsername(username);
	}

	@Override
	public User findUser(String username) {
		return userRepository.findByUsername(username);
	}

}
