package com.app.estore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.estore.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByLastName(String lastName);
	List<Customer> findByFirstName(String firstName);
	Customer findByEmail(String email);
	Customer findById(Long id);
}
