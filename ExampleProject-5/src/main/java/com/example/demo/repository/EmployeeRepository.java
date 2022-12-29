package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
