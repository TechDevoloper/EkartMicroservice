package com.feign.spring;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
public class ProductService{

	public static void main(String[] args) {
		SpringApplication.run(ProductService.class, args);
	}

}
