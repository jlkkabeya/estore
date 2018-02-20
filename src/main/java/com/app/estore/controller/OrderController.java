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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.estore.model.WaffleOrder;
import com.app.estore.service.OrderService;

@Controller
@RequestMapping(path="/estore/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/add", method=RequestMethod.PUT)
	public ResponseEntity<WaffleOrder> createOrder(@RequestBody WaffleOrder order){
		orderService.createOrder(order);
		return new ResponseEntity<WaffleOrder>(order, HttpStatus.OK);
	}
		
	@GetMapping(path="/id/{id}")
	@ResponseBody
	public WaffleOrder getOrder(@PathVariable("id") Long id) {
		return orderService.getOrder(id);
	}
	
	@GetMapping(path="/all")
	@ResponseBody
	public Iterable<WaffleOrder> getAllOrders() {
		
		return orderService.getAllOrders();
	}
	
	@RequestMapping(path="/delete/{id}", method=RequestMethod.DELETE)
	public String deleteOrder(@PathVariable("id") Long id) {
		return orderService.getOrder(id) == null? "order not found" : "deleted";
	}
	
	@RequestMapping(value="/addOrder/customerId/{customerId}", method=RequestMethod.POST)
	public ResponseEntity<WaffleOrder> addOrder(@PathVariable("customerId") Long customerId, @RequestBody WaffleOrder order){
		orderService.addOrder(customerId, order);
		return new ResponseEntity<WaffleOrder>(order, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addOrder/email/{email}", method=RequestMethod.POST)
	public ResponseEntity<WaffleOrder> addOrder(@PathVariable("email") String email, @RequestBody WaffleOrder order){
		orderService.addOrder(email, order);
		return new ResponseEntity<WaffleOrder>(order, HttpStatus.OK);
	}
}
