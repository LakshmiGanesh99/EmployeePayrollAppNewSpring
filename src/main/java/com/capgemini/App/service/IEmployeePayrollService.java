package com.capgemini.App.service;

import java.util.List;

import com.capgemini.App.Exception.EmployeeException;
import com.capgemini.App.dto.EmployeePayrollDTO;
import com.capgemini.App.model.Employee;

public interface IEmployeePayrollService {
	
	Employee addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

	Employee getEmployeeData(long empID) throws EmployeeException;

	void updateEmployeeById(long empId, EmployeePayrollDTO employeePayrollDTO) throws EmployeeException;

	void deleteEmployeeById(long empId) throws EmployeeException;

	List getAllEmployeeData();
}
