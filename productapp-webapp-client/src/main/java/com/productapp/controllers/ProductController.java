package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@Controller
public class ProductController {
	@Autowired
	private IProductService productService;
	
	@GetMapping("/")
//	public String getAllProducts(ModelMap model){
//		// call the service layer
//		List<Product> products = productService.getAll();
//		model.addAttribute("products", products);
//		return "home";
//	}
	public ModelAndView getAllProducts() {
	    List<Product> products = productService.getAll();
	    ModelAndView mav = new ModelAndView("home");
	    mav.addObject("products", products);
	    return mav;
	}

}
