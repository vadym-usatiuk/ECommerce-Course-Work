package com.tts.eCommerce.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tts.eCommerce.model.Cart;
import com.tts.eCommerce.model.Order;
import com.tts.eCommerce.service.OrderService;

public class OrderController {
	
	@GetMapping("/checkout")
	public String checkout (Cart cart, Model model) {
		Order purchaseOrder = OrderService.makePurchaseOrder(cart);
		model.addAttribute("purchaseOrder", purchaseOrder);
		return "storefront/invoice";
	}

}
