/**
 * 
 */
package com.changepond.hrms.services;

import java.util.List;

import com.changepond.hrms.domain.Employee;


/**
 * @author muthukumar.m
 *
 */
public interface EmployeeService {

	public List<Employee> getAll();

	public Employee create(Employee employee);

	public Employee update(Employee employee);

	public Employee findById(int id);

	public Employee findByEmail(String email);

	public void deleteById(int id);
	
	public void changePassword(String currentClearTextPassword, String newPassword);

}
