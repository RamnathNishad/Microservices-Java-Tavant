package com.example.customer_service.order_service.aggregator_service;

import lombok.Data;

@Data
public class OrderDTO {
    private Long id;
    private Long customerId;
    private String Item;
}
