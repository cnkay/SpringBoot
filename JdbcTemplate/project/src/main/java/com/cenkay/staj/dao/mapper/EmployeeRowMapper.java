package com.cenkay.staj.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        EmployeeResultSetExtractor extractor = new EmployeeResultSetExtractor();
        return extractor.extractData(resultSet);
    }
}
