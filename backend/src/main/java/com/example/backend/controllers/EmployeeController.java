package com.example.backend.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entities.Employee;
import com.example.backend.repositories.EmployeeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
    
	@GetMapping(value = "/get")
	public ResponseEntity<List<Employee>> getALl() {
		System.out.println("===================Enter==========================");
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
	}
	@GetMapping(value = "/add")
	public ResponseEntity<List<Employee>> add() {
		System.out.println("===================Add Enter==========================");
		Employee employee = new Employee();
		employee.setName("Name" + UUID.randomUUID().toString());
		employee.setAddress("Address" + UUID.randomUUID().toString());
		employeeRepository.save(employee);
		System.out.println("===================Persisted==========================");
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		System.out.println("===================Delete Enter==========================");
		employeeRepository.deleteById(id);
		System.out.println("===================Deleted==========================");
		return new ResponseEntity(HttpStatus.OK);
	}
}
