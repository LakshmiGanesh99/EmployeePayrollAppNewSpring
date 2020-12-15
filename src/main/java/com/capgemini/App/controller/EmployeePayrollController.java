package com.capgemini.App.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.App.Exception.EmployeeException;
import com.capgemini.App.dto.EmployeePayrollDTO;
import com.capgemini.App.dto.ResponseDTO;
import com.capgemini.App.model.Employee;
import com.capgemini.App.service.IEmployeePayrollService;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@ApiOperation(value = "This api is used for demo purpose only.")
	@GetMapping
	public String demo() {
		return "hello";
	}

	@ApiOperation(value = "This api used to fetch the employee details by empId.", notes = "Enter empId in long form.", response = Employee.class)
	@GetMapping("/get/{empId}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable long empId) throws EmployeeException {
		Employee emp = employeePayrollService.getEmployeeData(empId);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List employeesList = employeePayrollService.getAllEmployeeData();
		return new ResponseEntity<>(employeesList, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody @Valid EmployeePayrollDTO employeePayrollDTO) {
		System.out.println("In create api");
		Employee emp = employeePayrollService.addEmployeePayrollData(employeePayrollDTO);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Added EmployeePayroll Data", emp), HttpStatus.CREATED);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<String> updateEmployee(@PathVariable long empId,
			@RequestBody EmployeePayrollDTO employeePayrollDTO) throws EmployeeException {
		employeePayrollService.updateEmployeeById(empId, employeePayrollDTO);
		return new ResponseEntity<String>("Employee updated", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long empId,
			@RequestBody EmployeePayrollDTO employeePayrollDTO) throws EmployeeException {
		employeePayrollService.deleteEmployeeById(empId);
		return new ResponseEntity<String>("Employee deleted", HttpStatus.OK);
	}
}
