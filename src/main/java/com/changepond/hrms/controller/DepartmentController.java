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

import com.changepond.atrs.util.RestAPICommonConstants;
import com.changepond.hrms.domain.Department;
import com.changepond.hrms.services.DepartmentService;

/**
 * @author muthukumar.m
 *
 */
@RestController
@RequestMapping(RestAPICommonConstants.REST_API_BASE_URL)
public class DepartmentController {

	public static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	DepartmentService departmentService;

	@CrossOrigin
	@GetMapping(RestAPICommonConstants.REST_API_DEP_BASE_URL + "list")
	public ResponseEntity<List<Department>> getAll() {
		logger.info("Get all the department details");
		return ResponseEntity.ok(departmentService.getAll());
	}

	@CrossOrigin
	@GetMapping(RestAPICommonConstants.REST_API_DEP_BASE_URL + "getById/{id}")
	public ResponseEntity<Department> getById(@PathVariable Integer id) {
		logger.info("Get department information based on desgination id {} : " + id);
		return ResponseEntity.ok(departmentService.findById(id));
	}

	@CrossOrigin
	@PostMapping(RestAPICommonConstants.REST_API_DEP_BASE_URL + "add")
	public ResponseEntity<Department> create(@RequestBody Department department) {
		return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.create(department));
	}

	@CrossOrigin
	@PutMapping(RestAPICommonConstants.REST_API_DEP_BASE_URL + "update/{id}")
	public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department department) {
		return ResponseEntity.accepted().body(departmentService.update(department));
	}

	@CrossOrigin
	@DeleteMapping(RestAPICommonConstants.REST_API_DEP_BASE_URL + "delete/{id}")
	public ResponseEntity<Department> delete(@PathVariable Integer id) {
		logger.info("Getting department information by id to delete {} :" + id);
		departmentService.deleteById(id);
		return ResponseEntity.accepted().build();
	}
}
