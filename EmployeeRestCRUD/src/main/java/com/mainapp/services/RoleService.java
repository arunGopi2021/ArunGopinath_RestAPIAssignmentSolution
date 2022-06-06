package com.mainapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mainapp.entities.Role;

@Service
public interface RoleService {

	// save role
	public void saveRole(Role role);
	
	// get role by role type
	public Role getRole(String roleType);
	
	// get all roles
	public List<Role> getAllRoles();
	
	// delete by role type
	public void deleteRole(String roleType);
}
