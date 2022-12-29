package com.example.demo.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Component
public class ServiceImplementation implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	ServiceImplementation(EmployeeRepository employeeRepository){
		super();
		this.employeeRepository=employeeRepository;
	}
	
	public Employee saveEmployee(Employee employee){
		
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		
		return employeeRepository.findById(id).orElseThrow();
	}
	
	public Employee updateEmployeeById(Employee employee, int id) {
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow();
		
		existingEmployee.setId(employee.getId());
		existingEmployee.setMail(employee.getMail());
		existingEmployee.setName(employee.getName());
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}
	
	public void deleteEmployee(int id) {
		employeeRepository.findById(id).orElseThrow();
		employeeRepository.deleteById(id);
	}
}



