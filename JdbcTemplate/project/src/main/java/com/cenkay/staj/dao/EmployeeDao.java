package com.cenkay.staj.dao;


import java.util.List;
import com.cenkay.staj.model.Employee;
import com.cenkay.staj.rest.employee.EmployeeDTO;

public interface EmployeeDao {

	Long save(Employee employee);

	Employee getByID(Long id);

	Long updateEmployeeById(Long id, EmployeeDTO employeeDTO);

	Boolean deleteEmployeeById(Long id);

	Employee getByUsername(String username);

	Employee getByCitizenNumber(String citizenNumber);

	List<Employee> getAll();

}
