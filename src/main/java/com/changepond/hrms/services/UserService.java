package com.changepond.hrms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.changepond.hrms.domain.User;
import com.changepond.hrms.repository.UserRepository;
/**
 * 
 * @author muthukumar.m
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<User> list(){
		List<User> list = userRepository.findAll();
		if(list.size() > 0) {
			return list;
		}else {
			return new ArrayList<User>();
		}
	}

	public User save(User user) {
		user.setRole("USER");
		user.setStatus("ACTIVE");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.saveAndFlush(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public User find(String userName) {
		return userRepository.findOneByUsername(userName);
	}

	public User find(Long id) {
		return userRepository.getOne(id);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
}
