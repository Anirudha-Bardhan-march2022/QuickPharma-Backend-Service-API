package com.quickpharma.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quickpharma.dtos.out.OrderDto;
import com.quickpharma.entities.Order;
import com.quickpharma.entities.OrderItem;
import com.quickpharma.entities.User;
import com.quickpharma.models.Response;
import com.quickpharma.services.OrderItemService;

@CrossOrigin
@RestController
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderItemService;
	
//	@GetMapping("/orderitems")
//	public ResponseEntity<?> getQuantityByOrderId(@RequestParam("orderId") String orderId) {
//		int orderid = Integer.parseInt(orderId);
//		int quantity = orderItemService.getQuantityByOrderId(orderid);
//		System.out.println(quantity);
//		if (quantity != 0) {
//			
//			return Response.success(quantity);
//		}
//		return Response.error(null);
//}
}
