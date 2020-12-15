package com.capgemini.App.dto;

import com.capgemini.App.model.Employee;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseDTO {
	
	public ResponseDTO(String string, Employee emp) {
		// TODO Auto-generated constructor stub
	}
	public String message;
	public Object object;
	
}
