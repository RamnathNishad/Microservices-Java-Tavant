package com.example.customer_service.order_service.order_service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="orders")
public class Order {
    @Id
    private Long id;
    private Long customerId;
    private String item;
}
