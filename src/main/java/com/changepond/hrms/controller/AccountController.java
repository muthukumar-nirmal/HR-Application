/**
 * 
 */
package com.changepond.hrms.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.changepond.hrms.dto.PasswordChangeDTO;
import com.changepond.hrms.services.EmployeeService;
import com.changepond.hrms.util.RestAPICommonConstants;

/**
 * @author muthukumar.m
 *
 */
@RestController
@RequestMapping(RestAPICommonConstants.REST_API_BASE_URL)
public class AccountController {
	
	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	
	/**
     * {@code POST  /account/change-password} : changes the current user's password.
     *
     * @param passwordChangeDto current and new password.
	 * @throws IOException 
     * @throws InvalidPasswordException {@code 400 (Bad Request)} if the new password is incorrect.
     */
	@CrossOrigin
    @PostMapping(RestAPICommonConstants.REST_API_ACCOUNT_BASE_URL + "change-password")
    public void changePassword(@RequestBody PasswordChangeDTO passwordChangeDto) throws IOException {
    	employeeService.changePassword(passwordChangeDto.getCurrentPassword(), passwordChangeDto.getNewPassword());
    }

}
