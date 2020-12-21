package com.tts.eCommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tts.eCommerce.model.Cart;

@Controller
@RequestMapping("/storefront")
public class CartController {

	@GetMapping("/cart")
	public String viewCart(Cart cart, Model model) {
		// code for cart
		model.addAttribute("cart", cart);
		return "storefront/cart";
	}

}