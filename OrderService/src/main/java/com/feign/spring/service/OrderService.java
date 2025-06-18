package com.feign.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feign.spring.ProductClient.ProductClient;
import com.feign.spring.client.OrderRepository.OrderRepository;
import com.feign.spring.model.Order;
import com.feign.spring.model.Product;

@Service
public class OrderService {
	
	@Autowired
	private ProductClient client;
	
	@Autowired
	private OrderRepository repository;
	
	public Order placeOrder(Long productId,int quantity) {
		Product product=client.getProductById(productId);
		
		if(product.getStock()<quantity) {
			throw new RuntimeException("Insufficient stock");
        }
		Order order = new Order();
		order.setProductId(productId);
		order.setQuantity(quantity);
		order.setTotalPrice(product.getPrice() * quantity);

        return repository.save(order);
    }
		
		
	
}
