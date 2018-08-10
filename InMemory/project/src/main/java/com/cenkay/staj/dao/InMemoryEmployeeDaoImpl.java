package com.cenkay.staj.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cenkay.staj.model.Employee;

@Repository
public class InMemoryEmployeeDaoImpl implements EmployeeDao {

	private final Map<Long, Employee> employees;
	private final Map<String, Employee> employeesByCitizenNumber;
	private final Map<String, Employee> employeesByUsername;

	private Long idCounter = 0L;

	public InMemoryEmployeeDaoImpl() {
		employees = new HashMap<Long, Employee>();
		employeesByCitizenNumber = new HashMap<String, Employee>();
		employeesByUsername = new HashMap<String, Employee>();
	}

	@Override
	public Long save(Employee employee) {
		idCounter = increaseAndGetId();
		employee.setId(idCounter);
		employees.put(idCounter, employee);
		employeesByCitizenNumber.put(employee.getCitizenNumber(), employee);
		employeesByUsername.put(employee.getUsername(), employee);
		return employee.getId();
	}

	@Override
	public Employee get(Long id) {
		return employees.get(id);
	}

	private synchronized Long increaseAndGetId() {
		return (long) idCounter.intValue() + 1;
	}

	@Override
	public Employee getByUsername(String username) {
		return employeesByUsername.get(username);
	}

	@Override
	public Employee getByCitizenNumber(String citizenNumber) {
		return employeesByCitizenNumber.get(citizenNumber);
	}

}
