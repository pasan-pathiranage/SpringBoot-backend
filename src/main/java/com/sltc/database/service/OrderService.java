package com.sltc.database.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sltc.database.dto.OrderDTO;
import com.sltc.database.entity.Order;

@Service
public interface OrderService  {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(OrderDTO orderDTO);
    
}
