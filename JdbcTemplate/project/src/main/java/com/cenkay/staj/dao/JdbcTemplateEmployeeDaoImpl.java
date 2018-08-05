package com.cenkay.staj.dao;

import java.util.List;
import com.cenkay.staj.dao.mapper.EmployeeRowMapper;
import com.cenkay.staj.rest.employee.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cenkay.staj.model.Employee;

@Repository
@Primary
public class JdbcTemplateEmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long save(Employee employee) {
        String saveQuery = "INSERT INTO Employee(citizenNumber,username,password) VALUES(?,?,?);";
        // *
        return (long) jdbcTemplate.update(saveQuery, new Object[]{employee.getCitizenNumber(),
                employee.getUsername(), employee.getPassword()});

    }

    @Override
    public Employee getByID(Long id) {
        String getByIdQuery = "SELECT * FROM Employee WHERE id=?;";
        Employee employee = new Employee();
        List<Employee> employeeList = jdbcTemplate.query(getByIdQuery, new Object[]{id}, new EmployeeRowMapper());
        if(employeeList.isEmpty())
            return null;
        employee = employeeList.get(employeeList.size() - 1);
        return employee;
    }

    @Override
    public Employee getByCitizenNumber(String citizenNumber) {

        String getByCitizenNumberQuery = "SELECT * FROM Employee WHERE citizenNumber IN(?);";
        Employee employee = new Employee();
        List<Employee> employeeList = jdbcTemplate.query(getByCitizenNumberQuery, new Object[]{citizenNumber}, new EmployeeRowMapper());
        if (employeeList.size() == 0)
            return null;
        else {
            employee = employeeList.get(employeeList.size() - 1);
            return employee;
        }
    }

    @Override
    public Employee getByUsername(String username) {
        String getByUsernameQuery = "SELECT * FROM Employee WHERE username IN(?);";
        Employee employee = new Employee();
        List<Employee> employeeList = jdbcTemplate.query(getByUsernameQuery, new Object[]{username}, new EmployeeRowMapper());// *
        if (employeeList.size() == 0)
            return null;
        else {
            employee = employeeList.get(employeeList.size() - 1);
            return employee;
        }
    }

    @Override
    public Long updateEmployeeById(Long id, EmployeeDTO employeeDTO) {
        String updateEmployeeByIdQuery = "UPDATE Employee SET citizenNumber=?, username=?, password=? WHERE id=?;";
        return (long) jdbcTemplate.update(updateEmployeeByIdQuery, new Object[]{employeeDTO.getCitizenNumber(),
                employeeDTO.getUsername(),employeeDTO.getPassword(),id});
    }

    @Override
    public Boolean deleteEmployeeById(Long id) {
        try {
            String deleteEmployeeByIdQuery = "DELETE FROM Employee WHERE id=?;";
            jdbcTemplate.update(deleteEmployeeByIdQuery, new Object[]{id});
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public List<Employee> getAll() {
        String getAllQuery = "SELECT * FROM Employee";
        List<Employee> employeeList = jdbcTemplate.query(getAllQuery, new EmployeeRowMapper());
        return employeeList;
    }
}
