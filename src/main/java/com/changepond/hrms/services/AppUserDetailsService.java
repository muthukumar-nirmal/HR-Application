package com.changepond.hrms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.changepond.hrms.domain.User;


/**
 * This Service class for providing the user credentials from the database.
 * 
 * @author muthukumar.m
 *
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.find(username);
		if("ACTIVE".equals(user.getStatus())){
			return user;
		}
		return null;
	}

}
