package com.feign.spring.ProductClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.feign.spring.model.Product;

@FeignClient(name="Product-Service")
public interface ProductClient {
	

	 @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
