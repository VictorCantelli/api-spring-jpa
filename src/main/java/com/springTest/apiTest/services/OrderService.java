package com.springTest.apiTest.services;

import com.springTest.apiTest.dto.OrderDTO;
import com.springTest.apiTest.entities.Order;
import com.springTest.apiTest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(OrderDTO::new).collect(Collectors.toList());
    }

    public OrderDTO findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        Order order = obj.orElseThrow(() -> new RuntimeException("Order not found"));
        return new OrderDTO(order);
    }
}
