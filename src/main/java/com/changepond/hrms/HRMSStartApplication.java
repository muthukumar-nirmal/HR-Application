package com.changepond.hrms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * 
 * @author muthukumar.m
 *
 */
@SpringBootApplication
public class HRMSStartApplication {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HRMSStartApplication.class, args);
	}
	
}
