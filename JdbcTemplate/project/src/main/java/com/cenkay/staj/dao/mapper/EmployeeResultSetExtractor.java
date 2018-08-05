package com.cenkay.staj.dao.mapper;

import com.cenkay.staj.model.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import java.sql.SQLException;
import java.sql.ResultSet;

public class EmployeeResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Employee employee=new Employee();
        employee.setCitizenNumber(resultSet.getString(2));
        employee.setUsername(resultSet.getString(3));
        employee.setPassword(resultSet.getString(4));
        return employee;
    }

}
