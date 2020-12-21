package com.tts.eCommerce.model;

import java.util.HashMap;
import java.util.List;

import javax.validation.constraints.Positive;

public class Cart {

	private User user;
	private String image;
	private String date;

	@Positive(message = "Number of items bought cannot be zero or negative")
	private List<HashMap<Product, Integer>> lineItems;

	private Double subTotal;
	private Double total;

	public Cart() {}

	public Cart(User user, String image, String date,
			@Positive(message = "Number of items bought cannot be zero or negative") List<HashMap<Product, Integer>> lineItems,
			Double subTotal, Double total) {
		this.user = user;
		this.image = image;
		this.date = date;
		this.lineItems = lineItems;
		this.subTotal = subTotal;
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<HashMap<Product, Integer>> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<HashMap<Product, Integer>> lineItems) {
		this.lineItems = lineItems;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [user=" + user + ", image=" + image + ", date=" + date + ", lineItems=" + lineItems + ", subTotal="
				+ subTotal + ", total=" + total + "]";
	}

}
