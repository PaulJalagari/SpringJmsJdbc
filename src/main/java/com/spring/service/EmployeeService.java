package com.spring.service;

import com.spring.dto.EmployeeDto;
import com.spring.model.Employee;

public interface EmployeeService {
	public Boolean insert(Employee employee) throws Exception;

	public Boolean consume() throws Exception;

	public Boolean insertEmployeeInfo(EmployeeDto employeeDto) throws Exception;

	public Boolean consumeEmployeeInfo() throws Exception;

}
