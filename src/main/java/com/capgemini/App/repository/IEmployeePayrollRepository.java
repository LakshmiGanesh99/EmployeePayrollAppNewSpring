package com.capgemini.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.App.model.Employee;

@Repository
public interface IEmployeePayrollRepository extends JpaRepository<Employee, Long>{
	
}
