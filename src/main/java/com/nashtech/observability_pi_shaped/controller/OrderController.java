package com.nashtech.observability_pi_shaped.controller;


import com.nashtech.observability_pi_shaped.dto.CreateOrderRequest;
import com.nashtech.observability_pi_shaped.dto.CreateOrderResponse;
import com.nashtech.observability_pi_shaped.entity.Order;
import com.nashtech.observability_pi_shaped.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-service")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public ResponseEntity<CreateOrderResponse> createOrder(
            @RequestBody CreateOrderRequest request) {

        Order order = orderService.createOrder(request);

        CreateOrderResponse response =
                new CreateOrderResponse(order.getId(), order.getStatus());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getOrder")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id) {

        Optional<Order> order = orderService.getOrderbyId(id);

        if (order.isEmpty()) {
            return ResponseEntity
                    .status(404)
                    .body("Order not found with id: " + id);
        }

        return ResponseEntity.ok(order.get());
    }
}
