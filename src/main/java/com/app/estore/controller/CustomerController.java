package com.app.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.estore.model.Customer;
import com.app.estore.repository.CustomerRepository;
import com.app.estore.service.CustomerService;

@Controller
@RequestMapping(path="/estore/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path="/register", method= RequestMethod.PUT)
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
		customerService.registerCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(path="/update", method= RequestMethod.POST)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		customerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Customer> getAllCustomers() {
		return customerService.gelAllCustomers();
	}
	
	@GetMapping(path="/id/{id}")
	@ResponseBody
	public Customer getCustomer(@PathVariable("id") Long id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping(path="/email/{email}")
	@ResponseBody
	public Customer getCustomer(@PathVariable("email") String email) {
		return customerService.getCustomerByEmail(email);
	}
	
	@RequestMapping(path="/delete/{id}", method= RequestMethod.DELETE)
	@ResponseBody
	public String deleteCustomer(@PathVariable("id") Long id) {
		Customer customer = customerService.getCustomerById(id);
		if (customer == null) {
			return "not found";
		} else {
			customerRepository.delete(customer);
		}
		return "deleted";
	}

}
