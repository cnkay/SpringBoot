package com.cenkay.staj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenkay.staj.dao.EmployeeDao;
import com.cenkay.staj.model.Employee;
import com.cenkay.staj.rest.employee.CreateEmployeeRequest;
import com.cenkay.staj.rest.employee.EmployeeDTO;
import com.cenkay.staj.service.exception.BusinessRuleException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Long save(CreateEmployeeRequest request) {
		checkCitizenNumber(request);
		checkUsername(request);
		Employee employee = getEmployeeFromRequest(request);
		return employeeDao.save(employee);
	}

	private void checkCitizenNumber(CreateEmployeeRequest request) {
		Employee employeeByCitizenNumber = employeeDao.getByCitizenNumber(request.getCitizenNumber());
		if (employeeByCitizenNumber != null)
			throw new BusinessRuleException("Citizen number already used!");
	}

	private void checkUsername(CreateEmployeeRequest request) {
		Employee employeeByUsername = employeeDao.getByUsername(request.getUsername());
		if (employeeByUsername != null)
			throw new BusinessRuleException("Username already used!");

	}

	private Employee getEmployeeFromRequest(CreateEmployeeRequest request) {
		Employee employee = new Employee(request.getUsername(), request.getPassword(), request.getCitizenNumber());
		return employee;
	}

	@Override
	public EmployeeDTO get(Long id) {
		Employee employee = employeeDao.get(id);
		return converToDTO(employee);
	}

	public EmployeeDTO converToDTO(Employee employee) {
		EmployeeDTO employeeFromDB = new EmployeeDTO();
		employeeFromDB.setUsername(employee.getUsername());
		employeeFromDB.setPassword(employee.getPassword());
		employeeFromDB.setCitizenNumber(employee.getCitizenNumber());
		return employeeFromDB;
	}

}
