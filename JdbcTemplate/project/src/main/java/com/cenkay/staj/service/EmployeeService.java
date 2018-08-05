package com.cenkay.staj.service;

import com.cenkay.staj.rest.employee.CreateEmployeeRequest;
import com.cenkay.staj.rest.employee.EmployeeDTO;
import java.util.List;

public interface EmployeeService {

	Long save(CreateEmployeeRequest request);

	EmployeeDTO getByID(Long id);

	Boolean delete(Long id);

	Long update(Long id, CreateEmployeeRequest request);

	List<EmployeeDTO> getAll();
}
