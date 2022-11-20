package com.quickpharma.services;


import java.util.List;

import com.quickpharma.entities.Order;
import com.quickpharma.entities.OrderItem;

public interface OrderItemService {
	
	OrderItem saveOrderItem(OrderItem orderItem);
	
	List<OrderItem> findAllByOrder(Order order);

	int getQuantityByOrderId(Order order);
}
