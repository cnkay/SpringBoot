package com.cenkay.staj.dao;

import java.util.List;

import com.cenkay.staj.model.Employee;

public interface EmployeeDao {

	Long save(Employee employee);

	Employee getByID(Long id);

	Boolean deleteEmployeeById(Long id);

	Employee getByUsername(String username);

	Employee getByCitizenNumber(String citizenNumber);

	List<Employee> getAll();

	Employee findByUsername(String username);

	Employee findByCitizenNumber(String citizenNumber);
}
