package org.dnyanyog.controller;

import org.dnyanyog.dto.OrderRequest;
import org.dnyanyog.dto.OrderResponse;
import org.dnyanyog.dto.OrdersData;
import org.dnyanyog.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OdersController {
	
	@Autowired
	OrdersService service;
	
	@GetMapping("/api/v1/order/{id}")
	public OrdersData getOrder(@PathVariable int id) {
		return service.searchOrderDetails(id);
	}
	
	@PostMapping("/api/v1/order")
	public OrderResponse getOrder(@RequestBody OrderRequest request) {
		return service.getOrder(request);
	}
	
	@DeleteMapping("/api/v1/order/{orderId}")
	public String cancleOrder(@PathVariable int orderId) {
		return service.cancleOrder(orderId);
	}

}
