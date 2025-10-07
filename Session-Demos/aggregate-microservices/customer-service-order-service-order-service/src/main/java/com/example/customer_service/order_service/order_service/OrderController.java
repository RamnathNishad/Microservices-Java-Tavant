package com.example.customer_service.order_service.order_service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository repository;

    public OrderController(OrderRepository repository){
        this.repository=repository;
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersForCustomer(@PathVariable Long customerId){
        return repository.findByCustomerId(customerId);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return repository.save(order);
    }
}
