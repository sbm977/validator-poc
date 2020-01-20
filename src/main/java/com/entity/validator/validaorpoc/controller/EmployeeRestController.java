package com.entity.validator.validaorpoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.entity.validator.validaorpoc.entity.Employee;
import com.entity.validator.validaorpoc.repository.EmployeeRepository;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@GetMapping("/employee/name/{name}")
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) {
		Employee employee = employeeRepository.findByName(name);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	@GetMapping("/employee/email/{email}")
	public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
		Employee employee = employeeRepository.findByEmail(email);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@PostMapping("/employee/update")
	public ResponseEntity<List<String>> getEmployeeBy(@RequestBody Employee emp) {
		List<String> response = employeeRepository.updateEmployee(emp);
		return new ResponseEntity<List<String>>(response, HttpStatus.OK);
	}
}