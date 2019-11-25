package com.changepond.hrms.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import com.changepond.atrs.util.CustomErrorType;
import com.changepond.hrms.domain.User;
import com.changepond.hrms.serviceimpl.UserServiceImpl;
/**
 * 
 * @author muthukumar.m
 *
 */
@RestController
@RequestMapping("/api")
public class AccountController {

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private UserServiceImpl userService;

	@CrossOrigin
	@PostMapping("/account/register")
	public ResponseEntity<?> createUser(@RequestBody User newUser) {
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("username Already exist " + newUser.getUsername());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new CustomErrorType("user with username " + newUser.getUsername() + "already exist "));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(newUser));
	}
	
	@CrossOrigin
	@GetMapping("/account/list")
	public ResponseEntity<List<User>> listUser(){
		logger.info("List all the users ");
		List<User> list = userService.list();
		return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/account/login")
	public Principal user(Principal principal) {
		logger.info("user logged "+principal);
		return principal;
	}
	
	
	@CrossOrigin
	@GetMapping("/account/getById/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id){
		logger.info("Get User information based on flight id {} : " + id);
        return ResponseEntity.ok(userService.find(id));
	}

	@CrossOrigin
	@PutMapping("/account/update/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
		return ResponseEntity.accepted().body(userService.update(user));
	}
	
	@CrossOrigin
	@DeleteMapping("/account/delete/{id}")
	public ResponseEntity<User> delete(@PathVariable Long id){
		logger.info("Getting User information by id to delete {} :" + id);
		userService.delete(id);
		return ResponseEntity.accepted().build();
	}
	
}
