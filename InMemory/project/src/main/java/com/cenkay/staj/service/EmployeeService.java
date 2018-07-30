package com.cenkay.staj.service;

import com.cenkay.staj.rest.employee.CreateEmployeeRequest;
import com.cenkay.staj.rest.employee.EmployeeDTO;

public interface EmployeeService {

	Long save(CreateEmployeeRequest request);
	
	EmployeeDTO get(Long id);
	
}
