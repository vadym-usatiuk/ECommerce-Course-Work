package com.tts.eCommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity //Let Spring Boot know that the instances of the Product class should be stored in a database
		// (We need to keep track of all the products by saving them in an H2 database to distinguish between customer, manager, administrator etc.) 

public class Product {
	
	
	@Id	// Use @Id annotation so it is recognized by JPA as "Product"’s primary key
	@GeneratedValue(strategy = GenerationType.AUTO)	// The id property is also annotated with @GeneratedValue to indicate that the ID should be generated automatically
	@Column(name = "product_id") // Specifies the mapped column for a persistent property ("Product") with its name in the H2 database being "product_id"
	private Long id;


	@NotBlank(message = "Product name cannot be blank") // what is being sold?
	private String name;

	@PositiveOrZero(message = "Product wholesale price cannot be negative")
	private Double wholesalePrice;

	@PositiveOrZero(message = "Product retail price cannot be negative")
	private Double retailPrice;

	@NotBlank(message = "Product brand cannot be blank")
	private String brand;
	
	@NotBlank(message = "Category cannot be blank")
	private String category;
	
	@NotBlank(message = "Product description cannot be blank") // You cannot create a product without adding a brief description first.
	private String description;

	@PositiveOrZero(message = "Inventory numbers cannot be negative") // Inventory numbers cannot be zero
	private Integer inventory;

	private String image; // image attribute is a string representing the path where the image file is stored.
						// It is possible to create a product and add an image file path later.

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	private Product() {}

	private Product(Long id, @NotBlank(message = "Product name cannot be blank") String name,
			@PositiveOrZero(message = "Product wholesale price cannot be negative") Double wholesalePrice,
			@PositiveOrZero(message = "Product retail price cannot be negative") Double retailPrice,
			@NotBlank(message = "Product brand cannot be blank") String brand,
			@NotBlank(message = "Category cannot be blank") String category,
			@NotBlank(message = "Product description cannot be blank") String description,
			@PositiveOrZero(message = "Inventory numbers cannot be negative") Integer inventory, String image,
			Date createdAt, Date updatedAt) {
		this.id = id;
		this.name = name;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.inventory = inventory;
		this.image = image;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWholesalePrice() {
		return wholesalePrice;
	}

	public void setWholesalePrice(Double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", wholesalePrice=" + wholesalePrice + ", retailPrice="
				+ retailPrice + ", brand=" + brand + ", category=" + category + ", description=" + description
				+ ", inventory=" + inventory + ", image=" + image + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

}
