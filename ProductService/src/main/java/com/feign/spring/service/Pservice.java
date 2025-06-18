package com.feign.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feign.spring.Exceptions.ResourceNotFoundException;
import com.feign.spring.Product.Product;
import com.feign.spring.repository.ProductRepository;

@Service
public class Pservice {
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		if (product.getId() != null) {
	        Product existing = repository.findById(product.getId())
	            .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + product.getId()));

	        // Update fields
	        existing.setName(product.getName());
	        existing.setPrice(product.getPrice());
	        existing.setStock(product.getStock());

	        return repository.save(existing);
	    } else {
	        return repository.save(product); // It's a new product
	    }
	}
	public List<Product>saveMultipelProducts(List<Product>product){
		return repository.saveAll(product);
	}
	public Optional<Product> getProductById(int id) {
		Optional<Product>products=repository.findById((long) id);
				if(products.isEmpty()) {        
					throw new ResourceNotFoundException("Product is not presesnt with Required stock: "+id);
				}
				else {
					return products;
				}
	}

}
