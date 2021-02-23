package com.example.backend.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entities.Employee;
import com.example.backend.repositories.EmployeeRepository;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping(value = "/data")
	public ResponseEntity<List<Employee>> getALl() {
		System.out.println("===================Enter==========================");
		Employee employee = new Employee();
		employee.setName("Name" + UUID.randomUUID().toString());
		employee.setAddress("Address" + UUID.randomUUID().toString());
		employeeRepository.save(employee);
		System.out.println("===================Persisted==========================");
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
	}
}
