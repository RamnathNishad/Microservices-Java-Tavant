package com.example.product_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getProduct(@PathVariable String id){
        if(id.equalsIgnoreCase("0")){
            throw new RuntimeException("Product Server is down");
        }
        System.out.println("created");
        return ResponseEntity.ok("Product ID:" + id); //from database
    }
}
