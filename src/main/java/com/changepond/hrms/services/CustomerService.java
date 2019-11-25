/**
 * 
 */
package com.changepond.hrms.services;

import java.util.List;

import com.changepond.hrms.domain.Customer;


/**
 * @author muthukumar.m
 *
 */
public interface CustomerService {

	public List<Customer> getAll();

	public Customer create(Customer customer);

	public Customer update(Customer customer);

	public Customer findById(int id);

	public Customer findByClientName(String name);

	public void deleteById(int id);

}
