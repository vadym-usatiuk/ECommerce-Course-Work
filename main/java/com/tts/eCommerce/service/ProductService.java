package com.tts.eCommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.eCommerce.model.Product;
import com.tts.eCommerce.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		    List<Product> products = productRepository.findAllByOrderByCreatedAtDesc();
		return products;
	}

	public Object findCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findBrands() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findByBrandAndOrCategory(String brand, String category) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
