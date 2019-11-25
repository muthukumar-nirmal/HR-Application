/**
 * 
 */
package com.changepond.hrms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.changepond.hrms.domain.Department;
import com.changepond.hrms.domain.Desgination;
import com.changepond.hrms.domain.Employee;
import com.changepond.hrms.services.DepartmentService;
import com.changepond.hrms.services.DesginationService;
import com.changepond.hrms.services.EmployeeService;
import com.changepond.hrms.util.RestAPICommonConstants;

/**
 * @author muthukumar.m
 *
 */
@RestController
@RequestMapping(RestAPICommonConstants.REST_API_BASE_URL)
public class EmployeeController {

	public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	DesginationService desginationService;
	
	@CrossOrigin
	@GetMapping(RestAPICommonConstants.REST_API_EMP_BASE_URL + "list")
	public ResponseEntity<List<Employee>> getAll() {
		logger.info(this.getClass().getSimpleName() + "Get all the employee details");
		return ResponseEntity.ok(employeeService.getAll());
	}
	
	@CrossOrigin
	@GetMapping(RestAPICommonConstants.REST_API_EMP_BASE_URL + "getById/{id}")
	public ResponseEntity<Employee> getById(@PathVariable Integer id) {
		logger.info(this.getClass().getSimpleName() + "Get employee information based on desgination id {} : " + id);
		return ResponseEntity.ok(employeeService.findById(id));
	}

	@CrossOrigin
	@PostMapping(RestAPICommonConstants.REST_API_EMP_BASE_URL + "add")
	public ResponseEntity<Employee> create(@RequestBody Employee employee) {
		Department department = departmentService.findById(8);
		Desgination desgination = desginationService.findById(6);
		employee.setDepartment(department);
		employee.setDesgination(desgination);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(employee));
	}

	@CrossOrigin
	@PutMapping(RestAPICommonConstants.REST_API_EMP_BASE_URL + "update/{id}")
	public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
		return ResponseEntity.accepted().body(employeeService.update(employee));
	}

	@CrossOrigin
	@DeleteMapping(RestAPICommonConstants.REST_API_EMP_BASE_URL + "delete/{id}")
	public ResponseEntity<Employee> delete(@PathVariable Integer id) {
		logger.info(this.getClass().getSimpleName() + "Getting employee information by id to delete {} :" + id);
		employeeService.deleteById(id);
		return ResponseEntity.accepted().build();
	}
}
