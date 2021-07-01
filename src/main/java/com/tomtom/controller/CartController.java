package com.tomtom.controller;

import com.tomtom.model.CartItem;
import com.tomtom.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

	@Autowired
	CartService cartService;

	@PostMapping(value = "/cart")
	public ResponseEntity<Object> addToCart(@RequestParam String username, @RequestBody CartItem cartItem) {
		return new ResponseEntity<>(cartService.addItemToCart(username, cartItem), HttpStatus.CREATED);
	}
}
