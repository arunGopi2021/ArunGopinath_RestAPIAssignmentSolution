package com.mainapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainapp.entities.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//get all employees in ascending order
	public List<Employee> findAllByOrderByFirstName();
		
	//get all employees in descending order
	public List<Employee> findAllByOrderByFirstNameDesc();
	
	//Search by first name
	public List<Employee> findByFirstName(String firstName);
		

}
