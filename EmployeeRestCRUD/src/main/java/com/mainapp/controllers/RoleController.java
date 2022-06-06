package com.mainapp.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mainapp.entities.Role;
import com.mainapp.services.RoleServiceImpl;





@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	
	// read all
	@RequestMapping(method = RequestMethod.GET, path = "/list")
	public List<Role> getAll(){
		return roleServiceImpl.getAllRoles();
	}
	
	
	
	// Save a role
	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public void saveRole(@RequestBody Role role) {
		roleServiceImpl.saveRole(role);
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
