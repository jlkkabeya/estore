package com.app.estore.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.estore.model.Customer;
import com.app.estore.model.WaffleOrder;
import com.app.estore.repository.WaffleOrderRepository;
import com.app.estore.service.CustomerService;
import com.app.estore.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private WaffleOrderRepository repository;
	@Autowired
	private CustomerService customerService;
	
	@Override
	public WaffleOrder createOrder(WaffleOrder order) {
		return repository.save(order);
	}

	@Override
	public WaffleOrder getOrder(Long id) {
		return repository.findByOrderId(id);
	}

	@Override
	public Iterable<WaffleOrder> getAllOrders() {
		return repository.findAll();
	}

	@Override
	public String deleteOrder(Long id) {
		WaffleOrder order = repository.findByOrderId(id);
		if (order == null) {
			return "Order ID not found!";
		} 
		repository.delete(order);
		return "order ID: " + id + "deleted";
	}

	@Override
	public WaffleOrder addOrder(Long customerId, WaffleOrder order) {	
		Customer customer = customerService.getCustomerById(customerId);
		customer.getOrders().add(repository.save(order));
		customerService.updateCustomer(customer);
		return order;
	}

	@Override
	public WaffleOrder addOrder(String email, WaffleOrder order) {
		Customer customer = customerService.getCustomerByEmail(email);
		customer.getOrders().add(repository.save(order));
		customerService.updateCustomer(customer);
		return order;	
	}
}


