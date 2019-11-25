/**
 * 
 */
package com.changepond.hrms.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changepond.hrms.domain.Customer;
import com.changepond.hrms.repository.CustomerRepository;
import com.changepond.hrms.services.CustomerService;

/**
 * @author muthukumar.m
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer create(Customer customer) {
		customer.setCreatedAt(new Date());
		customer.setUpdatedAt(new Date());
		return customerRepository.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer findById(int id) {
		return customerRepository.getOne(id);
	}

	@Override
	public Customer findByClientName(String name) {
		return customerRepository.findByClientName(name);
	}

	@Override
	public void deleteById(int id) {
		customerRepository.deleteById(id);
	}

}
