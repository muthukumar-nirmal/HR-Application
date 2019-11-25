/**
 * 
 */
package com.changepond.hrms.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.changepond.hrms.domain.Employee;
import com.changepond.hrms.repository.EmployeeRepository;
import com.changepond.hrms.services.EmployeeService;


/**
 * @author muthukumar.m
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;


	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee create(Employee employee) {
		employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
		employee.setConfirmPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
		employee.setStatus("ACTIVE");
		employee.setCreatedAt(new Date());
		employee.setUpdatedAt(new Date());
		return employeeRepository.saveAndFlush(employee);
	}

	@Override
	public Employee update(Employee employee) {
		return create(employee);
	}

	@Override
	public Employee findById(int id) {
		return employeeRepository.getOne(id);
	}

	@Override
	public Employee findByEmail(String email) {
		return employeeRepository.findByUsername(email);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
}
