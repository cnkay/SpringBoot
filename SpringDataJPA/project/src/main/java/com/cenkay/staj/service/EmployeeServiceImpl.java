package com.cenkay.staj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.cenkay.staj.dao.SpringDataEmployeeDao;
import com.cenkay.staj.model.Employee;
import com.cenkay.staj.rest.employee.CreateEmployeeRequest;
import com.cenkay.staj.rest.employee.EmployeeDTO;
import com.cenkay.staj.service.exception.BusinessRuleException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private SpringDataEmployeeDao springDataEmployeeDao;

	@Override
	public Long save(CreateEmployeeRequest request) {
		checkCitizenNumber(request);
		checkUsername(request);
		Employee employee = getEmployeeFromRequest(request);
		return springDataEmployeeDao.save(employee).getId();
	}

	private void checkCitizenNumber(CreateEmployeeRequest request) {
		Employee employeeByCitizenNumber = springDataEmployeeDao.findByCitizenNumber(request.getCitizenNumber());
		if (employeeByCitizenNumber != null)
			throw new BusinessRuleException("CitizenNumber already used!");
	}

	private void checkUsername(CreateEmployeeRequest request) {
		Employee employeeByUsername = springDataEmployeeDao.findByUsername(request.getUsername());
		if (employeeByUsername != null)
			throw new BusinessRuleException("Username already used!");

	}

	private Employee getEmployeeFromRequest(CreateEmployeeRequest request) {
		Employee employee = new Employee(request.getUsername(), request.getPassword(), request.getCitizenNumber());
		return employee;
	}

	@Override
	public EmployeeDTO getByid(Long id) throws HttpClientErrorException {

		Employee employee=springDataEmployeeDao.findById(id).get();
		return converToDTO(employee);

	}

	@Override
	public Boolean delete(Long id) throws HttpClientErrorException {

		springDataEmployeeDao.deleteById(id);
		return true;

	}

	public EmployeeDTO converToDTO(Employee employee) {
		EmployeeDTO employeeFromDB = new EmployeeDTO();
		employeeFromDB.setUsername(employee.getUsername());
		employeeFromDB.setPassword(employee.getPassword());
		employeeFromDB.setCitizenNumber(employee.getCitizenNumber());
		return employeeFromDB;
	}

	@Override
	public List<EmployeeDTO> getAll() {
		List<Employee> employeeList = springDataEmployeeDao.findAll();
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		for (Employee employeeFromList : employeeList) {
			employeeDTOs.add(converToDTO(employeeFromList));
		}
		return employeeDTOs;
	}
}
