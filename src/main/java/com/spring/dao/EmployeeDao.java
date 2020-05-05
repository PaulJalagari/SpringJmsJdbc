package com.spring.dao;

import com.spring.dto.EmployeeDto;
import com.spring.model.Employee;

public interface EmployeeDao {

	public int insert(Employee employee) throws Exception;

	public int insert(EmployeeDto employeeDto) throws Exception;

}
