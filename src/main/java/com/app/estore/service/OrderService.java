package com.app.estore.service;

import com.app.estore.model.WaffleOrder;

public interface OrderService {

	WaffleOrder createOrder(WaffleOrder order);
	WaffleOrder getOrder(Long id);
	Iterable<WaffleOrder> getAllOrders();
	String deleteOrder(Long id);
	WaffleOrder addOrder(Long customerId, WaffleOrder order);
	WaffleOrder addOrder(String email, WaffleOrder order);
}
