package com.mainapp.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.mainapp.entities.Employee;
import com.mainapp.services.EmployeeService;





@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeServiceImpl;
	
	
	//read all
	@RequestMapping(method = RequestMethod.GET, path = "/list")
	public List<Employee> getAll(){
		return employeeServiceImpl.getAllEmployees();
	}
	
	//read all ascending order or descending order
	@RequestMapping(method = {RequestMethod.GET}, path = "/list/{sortOrder}")
	public List<Employee> getAllByOrder(@PathVariable String sortOrder){
		
		if(sortOrder.equalsIgnoreCase("asc")) {
			return employeeServiceImpl.getAllEmployeesAscending();
		}else if(sortOrder.equalsIgnoreCase("desc")) {
			return employeeServiceImpl.getAllEmployeesDescending();
		}
		return null;
	}
	
	
	//search by Id
	@RequestMapping(method = {RequestMethod.GET}, path = "/search/id/{id}")
	public Employee getById(@PathVariable Integer id) {
		return employeeServiceImpl.getEmployeeById(id);
	}
	
	
	//search by name
	@RequestMapping(method= {RequestMethod.GET}, path = "/search/firstName/{firstName}")
	public List<Employee> getByFirstName(@PathVariable String firstName){
		return employeeServiceImpl.getEmployeesByFirstName(firstName);
	}
	
	
	
	// delete by Id
	@RequestMapping(method = {RequestMethod.DELETE}, path ="/delete/{id}" )
	public void deletebyId(@PathVariable Integer id) {
		employeeServiceImpl.deleteEmployeeById(id);
	}
	
	
	
	//create an employee
	@RequestMapping(method= RequestMethod.POST,path="/add")
	public void saveEmployee(@RequestBody Employee employee) {
		employeeServiceImpl.saveEmployee(employee);
	}
	
	
	//update an employee
	@RequestMapping(method= RequestMethod.PUT,path="/update")
	public void updateEmployee(@RequestBody Employee employee) {
		employeeServiceImpl.saveEmployee(employee);
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
