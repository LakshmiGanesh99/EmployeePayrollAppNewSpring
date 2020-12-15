package com.capgemini.App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.App.Exception.EmployeeException;
import com.capgemini.App.dto.EmployeePayrollDTO;
import com.capgemini.App.model.Employee;
import com.capgemini.App.repository.IEmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private IEmployeePayrollRepository employeePayrollRepo;
	
	@Override
	public Employee addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		Employee emp = new Employee(employeePayrollDTO);
		return employeePayrollRepo.save(emp);
	}

	@Override
	public Employee getEmployeeData(long empId) throws EmployeeException{
		return employeePayrollRepo.findById(empId).orElseThrow(() -> new EmployeeException("Invalid User id"));
	}
	
	@Override
	public List getAllEmployeeData() {
		return employeePayrollRepo.findAll();
	}	

	@Override
	public void updateEmployeeById(long empId, EmployeePayrollDTO employeePayrollDTO) throws EmployeeException {
		Employee emp = getEmployeeData(empId);
		if(employeePayrollDTO.name != null) {
			emp.setName(employeePayrollDTO.name);
		}
		if(employeePayrollDTO.salary != 0.0) {
			emp.setSalary(employeePayrollDTO.salary);
		}
		employeePayrollRepo.save(emp);
		
	}

	@Override
	public void deleteEmployeeById(long empId) throws EmployeeException {
		Employee emp = employeePayrollRepo.findById(empId).orElseThrow(() -> new EmployeeException("Invalid User id"));
		if(emp==null)
			return;
		employeePayrollRepo.deleteById(empId);
	}	
}
