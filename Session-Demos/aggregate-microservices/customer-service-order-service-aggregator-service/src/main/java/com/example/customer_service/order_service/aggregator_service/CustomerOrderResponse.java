package com.example.customer_service.order_service.aggregator_service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomerOrderResponse {
    private CustomerDTO customer;
    private List<OrderDTO> orders;
}
