package com.mainapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainapp.entities.Employee;
import com.mainapp.repositories.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getAllEmployeesAscending() {
		return employeeRepository.findAllByOrderByFirstName();
	}

	@Override
	public List<Employee> getAllEmployeesDescending() {
		return employeeRepository.findAllByOrderByFirstNameDesc();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public List<Employee> getEmployeesByFirstName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}

}
