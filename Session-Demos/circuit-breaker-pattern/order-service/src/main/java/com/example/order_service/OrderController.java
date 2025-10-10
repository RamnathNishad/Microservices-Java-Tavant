package com.example.order_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{productId}")
    public ResponseEntity<String> getOrderDetails(@PathVariable String productId){
        String response = orderService.getProductDetails(productId);
        return ResponseEntity.ok("Order created with:" + response);
    }
}
