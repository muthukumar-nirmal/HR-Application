package com.changepond.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.changepond.hrms.domain.Employee;


/**
 * 
 * @author muthukumar.m
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	Employee findByUsername(String username);
}