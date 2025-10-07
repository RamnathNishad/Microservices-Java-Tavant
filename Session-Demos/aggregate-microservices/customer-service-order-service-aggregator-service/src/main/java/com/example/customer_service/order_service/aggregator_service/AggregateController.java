package com.example.customer_service.order_service.aggregator_service;

import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/aggregate")
public class AggregateController {

    private final RestTemplate restTemplate;
    public AggregateController(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @GetMapping("/customer/{id}")
    public CustomerOrderResponse getCustomerOrders(@PathVariable Long id){

        CustomerDTO customer=restTemplate.getForObject("http://localhost:8081/customers/"+id,CustomerDTO.class);

        OrderDTO[] orders=restTemplate.getForObject("http://localhost:8082/orders/customer/"+id,OrderDTO[].class);

        return new CustomerOrderResponse(customer, Arrays.asList(orders));
    }

//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

}

@Configuration
class AppConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}