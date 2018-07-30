package com.cenkay.staj.dao;

import com.cenkay.staj.model.Employee;

public interface EmployeeDao {

	Long save(Employee employee);

	Employee get(Long id);

	// todo bu > by
	Employee getByUsername(String username);

	// todo bu > by
	Employee getByCitizenNumber(String citizenNumber);

//alt shift r
}
