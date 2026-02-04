package com.nashtech.observability_pi_shaped.service;

import com.nashtech.observability_pi_shaped.dto.CreateOrderRequest;
import com.nashtech.observability_pi_shaped.entity.Order;
import com.nashtech.observability_pi_shaped.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(CreateOrderRequest request) {

        Order order = new Order(
                request.getItemName(),
                request.getPrice(),
                "CREATED"
        );

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderbyId(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
