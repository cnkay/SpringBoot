package com.cenkay.staj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenkay.staj.dao.EmployeeDao;
import com.cenkay.staj.model.Employee;
import com.cenkay.staj.rest.employee.CreateEmployeeRequest;
import com.cenkay.staj.rest.employee.EmployeeDTO;
import com.cenkay.staj.service.exception.BusinessRuleException;

import java.util.ArrayList;
import java.util.List;

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
            throw new BusinessRuleException("CitizenNumber already used!");
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
    public EmployeeDTO getByID(Long id) {
        try {
            Employee employee = employeeDao.getByID(id);
            return converToDTO(employee);
        } catch (Exception e) {
            System.out.println("EmployeeDTO getByID exception");
            return null;
        }

    }

    @Override
    public Boolean delete(Long id) {
        try {
            employeeDao.deleteEmployeeById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Long update(Long id, CreateEmployeeRequest request) {
        try {
            Employee employee=employeeDao.getByID(id);
            if(employee!=null)
            {
                employee=getEmployeeFromRequest(request);
                EmployeeDTO employeeDTO=converToDTO(employee);
                return employeeDao.updateEmployeeById(id,employeeDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return save(request);
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
        List<Employee> employeeList = employeeDao.getAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (Employee employeeFromList : employeeList) {
            employeeDTOs.add(converToDTO(employeeFromList));
        }
        return employeeDTOs;
    }
}
