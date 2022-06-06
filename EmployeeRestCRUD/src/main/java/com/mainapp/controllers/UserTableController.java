package com.mainapp.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mainapp.entities.Role;
import com.mainapp.entities.User;
import com.mainapp.services.RoleServiceImpl;
import com.mainapp.services.UserTableServiceImpl;





@RestController
@RequestMapping("/users")
public class UserTableController {
	
	@Autowired
	private RoleServiceImpl roleServImpl;
	@Autowired
	private UserTableServiceImpl userTableServImpl;
	
	
	// read all users
	@RequestMapping(method =RequestMethod.GET, path = "/list")
	public List<User> readAllusers(){
		return userTableServImpl.getAllUsers();
	}
	
	
	// save a user
	@RequestMapping(method = RequestMethod.POST, path = "/add/{roleType}")
	public void saveUser(@RequestBody User user, @PathVariable String roleType) {
		
		User userAndRoles = new User();
		userAndRoles.setUsername(user.getUsername());
		userAndRoles.setPassword(user.getPassword());
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleServImpl.getRole(roleType));
		userAndRoles.setRoles(roles);
		userTableServImpl.saveUser(userAndRoles);
		
		// add the role to the users_roles table....to be done
		// at this moment I am just fetching the role id and user id
		System.out.println("user id is: "+ userTableServImpl.findUser(user.getUsername()).getUserId());
		System.out.println("role id is: "+ roleServImpl.getRole(roleType).getId());
		
	}
	

	
	//403 - Access denied
	@RequestMapping(value = "/403")
	public String accesssDenied(Principal user) {
		String msg="";

		if (user != null) {
			msg = "Hi " + user.getName() + ", you do not have permission to access this page!";
		} else {
			msg = "You do not have permission to access this page!";
		}
		return msg;
	}
	
}
