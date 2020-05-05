package com.spring.dto;

import java.io.Serializable;
import java.util.List;

import com.spring.model.Address;

public class EmployeeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	//private Integer employeeId;

	private String firstName;

	private String lastName;

	private String emailId;

	private List<Address> employeeAddresses;

	public EmployeeDto() {

	}

	public EmployeeDto(String firstName, String lastName, String emailId) {
		super();
		//this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}

	public EmployeeDto(String firstName, String lastName, String emailId,
			List<Address> employeeAddresses) {
		super();
		//this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.employeeAddresses = employeeAddresses;
	}

	/*public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Address> getEmployeeAddresses() {
		return employeeAddresses;
	}

	public void setEmployeeAddresses(List<Address> employeeAddresses) {
		this.employeeAddresses = employeeAddresses;
	}

	@Override
	public String toString() {
		return "EmployeeDto [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", employeeAddresses=" + employeeAddresses + "]";
	}
	
	

}
