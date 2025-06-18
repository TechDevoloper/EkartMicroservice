package com.feign.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feign.spring.model.Order;
import com.feign.spring.service.OrderService;

@RestController
public class OrderController {
	@Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestParam Long productId, @RequestParam int quantity) {
        Order order = orderService.placeOrder(productId, quantity);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

}
