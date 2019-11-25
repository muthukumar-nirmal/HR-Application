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
import com.changepond.hrms.domain.Customer;
import com.changepond.hrms.services.CustomerService;

/**
 * @author muthukumar.m
 *
 */
@RestController
@RequestMapping(RestAPICommonConstants.REST_API_BASE_URL)
public class CustomerController {

	public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;

	@CrossOrigin
	@GetMapping(RestAPICommonConstants.REST_API_CUS_BASE_URL + "list")
	public ResponseEntity<List<Customer>> getAll() {
		logger.info(this.getClass().getSimpleName() + "Get all the customer details");
		return ResponseEntity.ok(customerService.getAll());
	}

	@CrossOrigin
	@GetMapping(RestAPICommonConstants.REST_API_CUS_BASE_URL + "getById/{id}")
	public ResponseEntity<Customer> getById(@PathVariable Integer id) {
		logger.info(this.getClass().getSimpleName() + "Get cutomer information based on cutomer id {} : " + id);
		return ResponseEntity.ok(customerService.findById(id));
	}

	@CrossOrigin
	@PostMapping(RestAPICommonConstants.REST_API_CUS_BASE_URL + "add")
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(customer));
	}

	@CrossOrigin
	@PutMapping(RestAPICommonConstants.REST_API_CUS_BASE_URL + "update/{id}")
	public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
		return ResponseEntity.accepted().body(customerService.update(customer));
	}

	@CrossOrigin
	@DeleteMapping(RestAPICommonConstants.REST_API_CUS_BASE_URL + "delete/{id}")
	public ResponseEntity<Customer> delete(@PathVariable Integer id) {
		logger.info(this.getClass().getSimpleName() + "Getting customer information by id to delete {} :" + id);
		customerService.deleteById(id);
		return ResponseEntity.accepted().build();
	}
}
