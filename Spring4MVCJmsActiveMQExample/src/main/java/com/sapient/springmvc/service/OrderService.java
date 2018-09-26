package com.sapient.springmvc.service;

import java.util.Map;

import com.sapient.springmvc.model.InventoryResponse;
import com.sapient.springmvc.model.Order;

public interface OrderService {
	public void sendOrder(Order order);
	
	public void updateOrder(InventoryResponse response);
	
	public Map<String, Order> getAllOrders();
}
