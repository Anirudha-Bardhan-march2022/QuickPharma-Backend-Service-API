package com.quickpharma.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickpharma.daos.OrderItemDao;
import com.quickpharma.entities.Order;
import com.quickpharma.entities.OrderItem;

@Transactional
@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemDao orderItemDao;

	@Override
	public OrderItem saveOrderItem(OrderItem orderItem) {
		return orderItemDao.save(orderItem);
	}

	@Override
	public List<OrderItem> findAllByOrder(Order order) {
		return orderItemDao.findAllByOrder(order);

	}

	@Override
	public int getQuantityByOrderId(Order order) {
		int quantity = 0;
		List<OrderItem> orderItemList = orderItemDao.findByOrder(order);
		for (OrderItem orderItem : orderItemList) {
			quantity += orderItem.getQuantity();
		}
		return quantity;
	}

}