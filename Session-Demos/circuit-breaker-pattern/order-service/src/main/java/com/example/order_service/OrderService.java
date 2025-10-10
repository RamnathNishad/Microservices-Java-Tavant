package com.example.order_service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;


    @Retry(name="retryServiceBreaker",fallbackMethod = "fallbackProduct")
    public String getProductDetails(String id){
        return restTemplate.getForObject("http://localhost:8081/api/products/"+id,String.class);
    }


    public String fallbackProduct(String id,Throwable t){
        return "Product service is currently unavailable, Please try again later";
    }
}
