/**
 * 
 */
package com.changepond.atrs.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author muthukumar.m
 *
 */
public class SendEmail {
	
	@Autowired
	JavaMailSender javaMailSender;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendEmail sendEmail = new SendEmail();
		sendEmail.sendEmail();
	}

	void sendEmail() {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("nirmal.biit@gmail.com", "muthukumarnirmal@gmail.com");

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		javaMailSender.send(msg);

	}

}
