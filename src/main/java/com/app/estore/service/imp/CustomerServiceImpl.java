package com.app.estore.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.estore.model.Customer;
import com.app.estore.repository.CustomerRepository;
import com.app.estore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Override
	public Customer getCustomerById(Long id) {
		return repository.findById(id);
	}

	@Override
	public String deleteCustomer(Long id) {
		Customer customer = repository.findById(id);
		if (customer == null) {
			return "not found";
		} else {
			repository.delete(customer);
		}
		return "Customer ID " + id + " deleted";
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer registerCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public Iterable<Customer> gelAllCustomers() {
		return repository.findAll();
	}

}
