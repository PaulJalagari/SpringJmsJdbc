package com.spring.model;

import java.io.Serializable;

/**
 * @author Paul Jalagari
 *
 */
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer addressId;

	private String addressDetails;

	private Integer employeeId;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

}
