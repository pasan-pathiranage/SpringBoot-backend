package com.sltc.database.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sltc.database.dto.OrderDTO;
import com.sltc.database.entity.Order;
import com.sltc.database.entity.Product;
import com.sltc.database.repository.OrderRepository;
import com.sltc.database.repository.PrductRepository;

@Service
public class OrderServiceImpl implements OrderService {
    

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PrductRepository prductRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();

    }

    @Override
    public Order createOrder(OrderDTO orderDTO){

         Order order =  new Order();


        List<Long> products = orderDTO.getProducts();
        Set<Product> productsSet = new HashSet<>();

        order.setTotal(0.0);

        for (Long productId : products) {
            Product product = prductRepository.findById(productId).orElse(null);

            if(product != null){
                productsSet.add(product);
                order.setTotal(order.getTotal()+ product.getPrice());          
            }
        }

       
        order.setOrdertime(LocalDateTime.now());  
        order.setProducts(productsSet);
        order.setTax(((order.getTotal()*15)/100));
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }
}
