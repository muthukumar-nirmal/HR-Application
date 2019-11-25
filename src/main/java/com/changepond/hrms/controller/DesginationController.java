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
import com.changepond.hrms.domain.Desgination;
import com.changepond.hrms.services.DesginationService;

/**
 * @author muthukumar.m
 *
 */
@RestController
@RequestMapping(RestAPICommonConstants.REST_API_BASE_URL)
public class DesginationController {

	public static final Logger logger = LoggerFactory.getLogger(DesginationController.class);

	@Autowired
	DesginationService desginationService;

	@CrossOrigin
	@GetMapping(RestAPICommonConstants.REST_API_DES_BASE_URL + "list")
	public ResponseEntity<List<Desgination>> getAll() {
		logger.info("Get all the desgination details");
		return ResponseEntity.ok(desginationService.getAll());
	}

	@CrossOrigin
	@GetMapping(RestAPICommonConstants.REST_API_DES_BASE_URL + "getById/{id}")
	public ResponseEntity<Desgination> getById(@PathVariable Integer id) {
		logger.info("Get desgination information based on desgination id {} : " + id);
		return ResponseEntity.ok(desginationService.findById(id));
	}

	@CrossOrigin
	@PostMapping(RestAPICommonConstants.REST_API_DES_BASE_URL + "add")
	public ResponseEntity<Desgination> create(@RequestBody Desgination desgination) {
		return ResponseEntity.status(HttpStatus.CREATED).body(desginationService.create(desgination));
	}

	@CrossOrigin
	@PutMapping(RestAPICommonConstants.REST_API_DES_BASE_URL + "update/{id}")
	public ResponseEntity<Desgination> update(@PathVariable Long id, @RequestBody Desgination desgination) {
		return ResponseEntity.accepted().body(desginationService.update(desgination));
	}

	@CrossOrigin
	@DeleteMapping(RestAPICommonConstants.REST_API_DES_BASE_URL + "delete/{id}")
	public ResponseEntity<Desgination> delete(@PathVariable Integer id) {
		logger.info("Getting desgination information by id to delete {}  :" + id);
		desginationService.deleteById(id);
		return ResponseEntity.accepted().build();
	}
}
