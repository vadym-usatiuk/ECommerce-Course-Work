package com.tts.eCommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.eCommerce.model.Cart;
import com.tts.eCommerce.model.Product;
import com.tts.eCommerce.service.ProductService;

@Controller
@RequestMapping("/storefront")
public class MainController {

	@GetMapping("/cart")
	public String index(Model model) {
		model.addAttribute("cart", new Cart());
		return "storefront/index";
	}

	@Autowired
	private ProductService productService;

	@GetMapping(value = { "/", "/home" })
	public String home(Model model) {
		model.addAttribute("products", productService.findAll());
		model.addAttribute("categories", productService.findCategories());
		model.addAttribute("brands", productService.findBrands());
		return "storefront/index";
	}

	@GetMapping("/filter")
	public String filter(@RequestParam(required = false) String category, @RequestParam(required = false) String brand,
			Model model) {
		List<Product> filtered = productService.findByBrandAndOrCategory(brand, category);
		model.addAttribute("products", filtered);
		model.addAttribute("categories", productService.findCategories());
		model.addAttribute("brands", productService.findBrands());
		return "storefront/index";
	}

	@GetMapping("/about")
	public String about() {
		return "storefront/about";
	}
}
