package com.example.customer_service.order_service.customer_service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository=repository;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return repository.save(customer);
    }
}
