package com.tts.eCommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.eCommerce.model.Product;
import com.tts.eCommerce.repository.ProductRepository;

import ch.qos.logback.core.db.dialect.DBUtil;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	public List<Product> findCategories() {
		List<Product> products = productRepository.findDistinctCategories();
		return products;
	}

	public List<Product> findBrands() {
		List<Product> products = productRepository.findDistinctBrands();
		return products;
	}

	public List<Product> findByBrandAndOrCategory(String brand, String category) {
		List<Product> products = new ArrayList<Product>();
		if (brand == "") {
			List<Product> productset1 = productRepository.findDistinctCategories();
		}
		if (category == "") {
			List<Product> productset2 = productRepository.findDistinctBrands();
		}
		List<String> columnsOld = DBUtils.GetColumns(db, TableName); 
		List<String> columnsNew = DBUtils.GetColumns(db, TableName); 

		for(int i = columnsNew.size() - 1; i > -1; --i){
		    String str = columnsNew.get(i);
		    if(!columnsOld.remove(str))
		        columnsNew.remove(str);
		}		
		return products;
	}

	public Product findProductById(long id) {
		Product product = productRepository.findbyId(id);
		return product;
	}

	public void save(Product product) {
		productRepository.save(product);
	}

	public void deleteById(long id) {
		productRepository.deleteById(id);
	}
}
