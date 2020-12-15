package com.capgemini.App.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,9}$", message = "Invalid name")
	public String name;

	@Min(value = 2, message = "Salary digit should be greater than 1")
	public long salary;

	public EmployeePayrollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

	public EmployeePayrollDTO() {
		// TODO Auto-generated constructor stub
	}

}
