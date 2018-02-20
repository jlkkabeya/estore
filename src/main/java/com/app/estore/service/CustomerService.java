package com.app.estore.service;

import com.app.estore.model.Customer;

public interface CustomerService {

	Customer getCustomerById(Long id);
	Customer getCustomerByEmail(String email);
	String deleteCustomer(Long id);
	Customer updateCustomer(Customer customer);
	Customer registerCustomer(Customer customer);
	Iterable<Customer> gelAllCustomers();
}
