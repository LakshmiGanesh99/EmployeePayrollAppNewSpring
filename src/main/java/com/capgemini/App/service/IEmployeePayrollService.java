package com.capgemini.App.service;

import java.util.List;

import com.capgemini.App.Exception.EmployeeException;
import com.capgemini.App.dto.EmployeePayrollDTO;
import com.capgemini.App.model.Employee;

public interface IEmployeePayrollService {
	
	Employee addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

	void updateEmployeeByID(long empID, EmployeePayrollDTO employeePayrollDTO) throws EmployeeException;

	Employee getEmployeeData(long empId) throws EmployeeException;

	List getAllEmployeeData();

	void deleteEmployeeById(long empId)  throws EmployeeException;

}
