package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.OrderRequest;
import org.dnyanyog.dto.OrderResponse;
import org.dnyanyog.dto.OrdersData;
import org.dnyanyog.entity.Orders;
import org.dnyanyog.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
	
	@Autowired
	OrderRepository repo;
	
	public OrdersData searchOrderDetails(int orderId) {
		OrdersData response = new OrdersData();
		
		Optional<Orders> order = repo.findById(orderId);
		if(order.isEmpty()) {
			response.setStaus("Fail");
			response.setMsg("order not found");
		}else {
			Orders ord = order.get();
			response.setStaus("Success");
			response.setMsg("Order found successfully");
			response.setProductId(ord.getProductId());
			response.setOrderid(ord.getOrderId());
			response.setPrice(ord.getPrice());
			response.setQuantity(ord.getQuantity());
		
		}
		
		return response;	
	}
	
	public OrderResponse getOrder(OrderRequest request) {
		OrderResponse response = new OrderResponse();
		
		Orders order = new Orders();
		
		order.setProductId(request.getProductId());
		order.setPrice(request.getPice());
		order.setQuantity(request.getQuantity());
		
		order = repo.save(order);
		
		response.setMsg("Order place successfully");
		response.setStatus("Success");
		response.setOrderId(order.getOrderId());
		
		return response;
		
	}
	
	public String cancleOrder(int orderId) {
		  repo.deleteById(orderId);
		  return "deleted "+orderId;
		
	}

}
