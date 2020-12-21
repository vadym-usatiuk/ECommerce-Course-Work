package com.tts.eCommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerce.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> findAll();
	public Product findbyId(Long id);
	public List<Product> findbyName(String name);
	public List<Product> findbyBrand(String brand);
	public List<Product> findbyCategory(String category);
	public List<Product> findbyBrandAndCategory(String brand, String category);
	
	@Query(name="findAllProductsWithBrand", value="SELECT DISTINCT product.brand FROM Product product")
	public List<Product> findDistinctBrands();
	
	@Query(name="findAllProductsWithCategories", value="SELECT DISTINCT product.category FROM Product product")
	public List<Product> findDistinctCategories();


}
