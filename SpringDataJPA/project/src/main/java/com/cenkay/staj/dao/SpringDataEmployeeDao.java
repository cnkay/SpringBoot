package com.cenkay.staj.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.cenkay.staj.model.Employee;

@Repository
@Configuration
@EnableJpaRepositories
public interface SpringDataEmployeeDao extends JpaRepository<Employee, Long> {
	
	Employee findByCitizenNumber(String citizenNumber);
	Employee findByUsername(String username);
	void deleteById(Long id);
	
}
