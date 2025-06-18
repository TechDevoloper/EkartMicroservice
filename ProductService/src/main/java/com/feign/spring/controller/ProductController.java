package com.feign.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feign.spring.Product.Product;
import com.feign.spring.service.Pservice;

@RestController
public class ProductController {
	
	@Autowired
	private Pservice service;
	
	@PostMapping("/Product")
	public ResponseEntity<Product>addProduct(@RequestBody Product product) throws JsonProcessingException{
		Product saveProduct=service.saveProduct(product);
		ObjectMapper obj = new ObjectMapper();
		String json=obj.writeValueAsString(product);
		System.out.println(json);
		System.out.println("POJO: " + product);
		
		return new ResponseEntity<>(saveProduct,HttpStatus.CREATED);
	}
	@PostMapping("/Products")
	public ResponseEntity<List<Product>>saveMulitpleProduct(@RequestBody List<Product>product){
		List<Product>saveMultipleProducts=service.saveMultipelProducts(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveMultipleProducts);
	}
	
	@GetMapping("/product/{id}")
	public Optional<Product>  getProductById(@PathVariable int id) {
		Optional<Product> getById=service.getProductById(id);
		return getById;
	}

}
