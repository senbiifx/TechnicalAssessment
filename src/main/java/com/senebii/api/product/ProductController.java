package com.senebii.api.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senebii.api.common.ResponseModel;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("list")
	public ResponseModel getItems() {
		return productService.getProducts();
	}
	
}
