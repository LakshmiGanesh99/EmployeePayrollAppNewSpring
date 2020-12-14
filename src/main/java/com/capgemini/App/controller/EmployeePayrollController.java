package com.capgemini.App.controller;

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
import com.capgemini.App.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@GetMapping
	public String demo() {
		return "Hello World";
	}

	@GetMapping("/get")
	public ResponseEntity getEmployeeDetails() {
		return null;
	}

	@PostMapping("/create")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		employeePayrollService.addEmployeePayrollData(employeePayrollDTO);
		return new ResponseEntity<String>("Add Employee payroll Data", HttpStatus.CREATED);
	}

	@PutMapping("/update/{empID}")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO,
			@PathVariable long empID) throws EmployeeException {
		employeePayrollService.updateEmployeeByID(empID, employeePayrollDTO);

		return new ResponseEntity<String>("Employee Updated", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empID}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long empId, @RequestBody EmployeePayrollDTO employeePayrollDTO) throws EmployeeException{
		employeePayrollService.deleteEmployeeById(empId);
		return new ResponseEntity<String>("Employee deleted", HttpStatus.OK);
	}

}
