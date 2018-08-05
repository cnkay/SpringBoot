package com.cenkay.staj.rest.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return employeeService.getByID(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<EmployeeDTO> getAll() {
        return employeeService.getAll();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean deleteEmployeeById(@PathVariable Long id) {

        return employeeService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Long updateEmployeeById(@PathVariable Long id, @RequestBody CreateEmployeeRequest request) {
        return employeeService.update(id, request);
    }

}
