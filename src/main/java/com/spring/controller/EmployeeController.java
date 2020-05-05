package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exceptions.EmployeeExceptions;
import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController extends EmployeeExceptions {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "/produce", consumes = { "application/json; charset=UTF-8" }, produces = {
			"application/json; charset=UTF-8" })
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) throws Exception {
		return new ResponseEntity<>(employeeService.insert(employee), HttpStatus.CREATED);
	}

	@GetMapping(value = "/consume", produces = { "application/json; charset=UTF-8" })
	public ResponseEntity<?> consume() throws Exception {
		return new ResponseEntity<>(employeeService.consume(), HttpStatus.OK);
	}
}
