package com.tomtom.controller;

import com.tomtom.model.Product;
import com.tomtom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping(value = "/product")
	public ResponseEntity<Object> addProducts(@RequestParam String username, @RequestBody Product product) {
		return new ResponseEntity<>(productService.addProduct(username, product), HttpStatus.CREATED);
	}

	@GetMapping(value = "/products")
	public ResponseEntity<Object> getProducts() {
		return new ResponseEntity<>(productService.getListOfProducts(), HttpStatus.OK);
	}
}
