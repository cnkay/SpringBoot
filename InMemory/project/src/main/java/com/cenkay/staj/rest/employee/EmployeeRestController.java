package com.cenkay.staj.rest.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenkay.staj.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.POST)
	public Long save(@RequestBody CreateEmployeeRequest request) {
		return employeeService.save(request);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public EmployeeDTO get(@PathVariable Long id) {
		return employeeService.get(id);
	}

}
