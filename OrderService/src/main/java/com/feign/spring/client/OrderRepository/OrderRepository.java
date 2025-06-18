package com.feign.spring.client.OrderRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feign.spring.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	Order save(Order order);

}
