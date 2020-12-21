package com.tts.eCommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerce.model.Product;
import com.tts.eCommerce.model.User;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> findAllByOrderByCreatedAtDesc();
	public List<Product> findAllByUserOrderByCreatedAtDesc(User user);
	public List<Product> findAllByUserInOrderByCreatedAtDesc(List<User> users);
}
