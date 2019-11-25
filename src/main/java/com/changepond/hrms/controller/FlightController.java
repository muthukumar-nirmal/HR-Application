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

import com.changepond.hrms.domain.FlightDetails;
import com.changepond.hrms.serviceimpl.FlightServiceImpl;

/**
 * @author muthukumar.m
 *
 */
@RestController
@RequestMapping("/api")
public class FlightController {

	public static final Logger logger = LoggerFactory.getLogger(FlightController.class);

	@Autowired
	FlightServiceImpl flightService;

	@CrossOrigin
	@GetMapping("/flight/list")
	public ResponseEntity<List<FlightDetails>> getFlightDetails(){
		logger.info("Get all the filght details");
		 return ResponseEntity.ok(flightService.list());
	}
	
	@CrossOrigin
	@GetMapping("/flight/getById/{id}")
	public ResponseEntity<FlightDetails> getById(@PathVariable Long id){
		logger.info("Get flight information based on flight id {} : " + id);
        return ResponseEntity.ok(flightService.find(id));
	}
	
	@CrossOrigin
	@PostMapping("/flight/add")
	public ResponseEntity<FlightDetails> create(@RequestBody FlightDetails flightDetails){
		return ResponseEntity.status(HttpStatus.CREATED).body(flightService.save(flightDetails));
	}
	
	@CrossOrigin
	@PutMapping("/flight/update/{id}")
	public ResponseEntity<FlightDetails> update(@PathVariable Long id, @RequestBody FlightDetails flightDetails){
		return ResponseEntity.accepted().body(flightService.update(flightDetails));
	}
	
	@CrossOrigin
	@DeleteMapping("/flight/delete/{id}")
	public ResponseEntity<FlightDetails> delete(@PathVariable Long id){
		logger.info("Getting flight information by id to delete {} :" + id);
		flightService.delete(id);
		return ResponseEntity.accepted().build();
	}
}
