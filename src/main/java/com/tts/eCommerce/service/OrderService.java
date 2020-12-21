package com.tts.eCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.eCommerce.model.Cart;
import com.tts.eCommerce.model.Order;
import com.tts.eCommerce.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	public static Order makePurchaseOrder(Cart cart) {
		
		//Order thatObjectThatBecomesAnOrderFromACart.(whateverthefield) = new Order();
		// code to populate fields to create an order object
		//return thatObjectThatBecomesAnOrderFromACart;
		return null;
	}
	
	//Method to calculate Order Sales Tax
	private Double calculateSalesTax(Double subTotal) {
		Double salesTax = 0.07 * subTotal;
		return salesTax;
	}
	
	//Method to calculate Order Total
	private Double calculateTotal(Double subTotal, Double salesTax, Double shipping) {
		Double total = subTotal + salesTax + shipping;
		return total;
	}



}
