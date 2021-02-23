package com.example.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
