package com.mainapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainapp.entities.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	public Role findByRoleType(String roleType);
	
	public void deleteByRoleType(String roleType);
}
