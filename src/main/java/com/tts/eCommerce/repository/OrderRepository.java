package com.tts.eCommerce.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerce.model.Order;

@Repository
public interface OrderRepository 
	extends CrudRepository<Order, Long> {
		public Optional <Order> findById(Long orderId);
}
