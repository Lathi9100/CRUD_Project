package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceImplementation.ServiceImplementation;
import com.example.demo.entity.Employee;

@RestController
@RequestMapping("api")
public class EmployeeController {

	@Autowired
	ServiceImplementation serviceImplementation;
	
	EmployeeController(ServiceImplementation serviceImplementation){
		this.serviceImplementation=serviceImplementation;
	}
	@PostMapping("post")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		
		return new ResponseEntity<Employee>(serviceImplementation.saveEmployee(employee),HttpStatus.CREATED);
	}
	@GetMapping("get")
	public List<Employee> getAllEmployees(){
		
		return serviceImplementation.getAllEmployees();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
		
		return new ResponseEntity<Employee>(serviceImplementation.getEmployeeById(id), HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee,@PathVariable("id") int id){
		
		return new ResponseEntity<Employee>(serviceImplementation.updateEmployeeById(employee,id), HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") int id){
		
		serviceImplementation.deleteEmployee(id);
		return new ResponseEntity<String>("Employee Deleted successfully",HttpStatus.OK);
	}
}



