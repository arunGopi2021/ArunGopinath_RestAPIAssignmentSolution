package com.mainapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainapp.entities.Role;
import com.mainapp.repositories.RoleRepository;




@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);

	}

	@Override
	public Role getRole(String roleType) {
		return roleRepository.findByRoleType(roleType);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public void deleteRole(String roleType) {
		roleRepository.deleteByRoleType(roleType);		
	}
	
	

}
