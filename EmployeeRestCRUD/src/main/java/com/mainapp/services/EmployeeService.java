package com.mainapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mainapp.entities.Employee;



@Service
public interface EmployeeService {
	
	//get all employees in unsorted order
	public List<Employee> getAllEmployees();
	
	//get all employees in ascending order
	public List<Employee> getAllEmployeesAscending();
	
	//get all employees in descending order
	public List<Employee> getAllEmployeesDescending();
	
	//Search by Id
	public Employee getEmployeeById(int id);
	
	//Search by first name
	public List<Employee> getEmployeesByFirstName(String firstName);
	
	
	//Save or Update
	public void saveEmployee(Employee employee);
	
	
	//Delete
	public void deleteEmployeeById(int id);
	
}
