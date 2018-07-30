package com.cenkay.staj.service;

import java.util.List;

import com.cenkay.staj.rest.employee.CreateEmployeeRequest;
import com.cenkay.staj.rest.employee.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO getByid(Long id);

	Boolean delete(Long id);

	List<EmployeeDTO> getAll();

	Long save(CreateEmployeeRequest request);
}
